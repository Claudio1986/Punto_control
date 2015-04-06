package cl.puntocontrol.struts.action;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cl.puntocontrol.hibernate.dao.DAOChofer;
import cl.puntocontrol.hibernate.domain.Chofer;
import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.struts.form.ChoferesForm;

public class ChoferGuardarAction extends Action {
	public ActionForward execute(
			ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {
		ChoferesForm form = (ChoferesForm)_form;
		Chofer chofer = new Chofer();
		try{
			String rut_chofer=request.getParameter("rut_chofer");
			rut_chofer=rut_chofer.replace(".", "");
			rut_chofer=rut_chofer.replace("-", "");
			Boolean nuevo=Boolean.valueOf(request.getParameter("nuevo"));
			List<Chofer> choferes = new ArrayList<Chofer>();
        	choferes=DAOChofer.list("","");

			for(Chofer chf:choferes){
				if(form.getNombre_chofer().toUpperCase().equals(chf.getNombre_chofer().toUpperCase())){
					if(!rut_chofer.toUpperCase().equals(chf.getRut_chofer().toUpperCase())){
						form.setErrorMessage("El nombre("+form.getNombre_chofer().toUpperCase()+") ingresado ya existe para: "+chf.getRut_chofer().toUpperCase());
			    		form.setSuccessMessage("");
						return mapping.findForward("error");
					}
				}
			}
			
			if(nuevo==false){
				try{DAOChofer.delete(rut_chofer);}catch(Exception e){}
			}
			chofer.setFono(form.getFono().toUpperCase());
			chofer.setNombre_chofer(form.getNombre_chofer().toUpperCase());
			chofer.setRut_chofer(rut_chofer.toUpperCase());
			chofer.setEstado(form.getEstado().equals("0")?"Bloqueado":"No Bloqueado");
			chofer.setEnviado(0);
			DAOChofer.add(chofer);
			
    		form.setSuccessMessage("Operacion Realizada Exitosamente.");
    		form.setErrorMessage("");
    		return mapping.findForward("success");
		}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
    		form.setSuccessMessage("");
			return mapping.findForward("error");
		}finally{
			List<Chofer> choferes=DAOChofer.list("","");
    		form.setChoferes(choferes);
    		form.setEstado("0");
    		form.setRut_chofer("");
    		form.setNombre_chofer("");
    		form.setFono("");
    		
    		String userName = (String)request.getSession().getAttribute("userName");
    		String password = (String)request.getSession().getAttribute("password");
    		Usuario usuario = UsuarioUtil.checkUser(userName, password);
    		form.setUsuario(usuario);
		}
	}
}