package cl.puntocontrol.struts.action;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cl.puntocontrol.hibernate.dao.DAOTransportista;
import cl.puntocontrol.hibernate.domain.Transportista;
import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.struts.form.TransportistasForm;

public class TransportistaGuardarAction extends Action {
	public ActionForward execute(
			ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {
		TransportistasForm form = (TransportistasForm)_form;
		Transportista transportista = new Transportista();
		try{
			String rut_transportista=request.getParameter("rut_transportista");
			rut_transportista=rut_transportista.replace(".", "");
			rut_transportista=rut_transportista.replace("-", "");
			Boolean nuevo=Boolean.valueOf(request.getParameter("nuevo"));
			
			List<Transportista> transportistas = new ArrayList<Transportista>();
    		transportistas=DAOTransportista.list("","");
    		
			for(Transportista trans:transportistas){
				if(form.getNombre_transportista().toUpperCase().equals(trans.getNombre_transportista().toUpperCase())){
					if(!rut_transportista.toUpperCase().equals(trans.getRut_transportista().toUpperCase())){
						form.setErrorMessage("El Nombre ("+form.getNombre_transportista().toUpperCase()+") ingresado ya existe para: "+trans.getRut_transportista().toUpperCase());
			    		form.setSuccessMessage("");
						return mapping.findForward("error");
					}
				}
				if(form.getSap_transportista().toUpperCase().equals(trans.getSap_transportista().toUpperCase())){
					if(!rut_transportista.toUpperCase().equals(trans.getRut_transportista().toUpperCase())){
						form.setErrorMessage("El codigo Sap ("+form.getSap_transportista().toUpperCase()+") ingresado ya existe para: "+trans.getRut_transportista().toUpperCase());
			    		form.setSuccessMessage("");
						return mapping.findForward("error");
					}
				}
			}
			
			if(nuevo==false){
				try{DAOTransportista.delete(rut_transportista);}catch(Exception e){}
			}

			transportista.setEstado(form.getEstado());
			transportista.setNombre_transportista(form.getNombre_transportista().toUpperCase());
			transportista.setRut_transportista(rut_transportista.toUpperCase());
			transportista.setSap_transportista(form.getSap_transportista().toUpperCase());
			DAOTransportista.add(transportista);
    		
    		form.setSuccessMessage("Operacion Realizada Exitosamente.");
    		form.setErrorMessage("");
    		return mapping.findForward("success");
		}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
    		form.setSuccessMessage("");
			return mapping.findForward("error");
		}finally{
			List<Transportista> transportistas = new ArrayList<Transportista>();
    		transportistas=DAOTransportista.list("","");
    		form.setTransportistas(transportistas);
    		
    		form.setEstado(0);
    		form.setNombre_transportista("");
    		form.setRut_transportista("");
    		form.setSap_transportista("");

    		String userName = (String)request.getSession().getAttribute("userName");
    		String password = (String)request.getSession().getAttribute("password");
    		Usuario usuario = UsuarioUtil.checkUser(userName, password);
    		form.setUsuario(usuario);
		}
	}
}