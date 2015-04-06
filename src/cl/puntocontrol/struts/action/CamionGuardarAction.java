package cl.puntocontrol.struts.action;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cl.puntocontrol.hibernate.dao.DAOCamion;
import cl.puntocontrol.hibernate.domain.Camion;
import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.struts.form.CamionesForm;

public class CamionGuardarAction extends Action {
	public ActionForward execute(
			ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {
		CamionesForm form = (CamionesForm)_form;
		try{
			List<Camion> camiones = new ArrayList<Camion>();
			camiones = DAOCamion.list("");
			String cam_patente=request.getParameter("cam_patente");
			Boolean nuevo=Boolean.valueOf(request.getParameter("nuevo"));
			
			for(Camion cam:camiones){
				if(form.getCam_observacion().toUpperCase().equals(cam.getCam_observacion().toUpperCase())){
					if(!cam_patente.equals(cam.getCam_patente())){
						form.setErrorMessage("La observacion ("+form.getCam_observacion().toUpperCase()+") ingresada ya existe para: "+cam.getCam_patente());
			    		form.setSuccessMessage("");
						return mapping.findForward("error");
					}
				}
			}
			
			if(nuevo==false){
				try{DAOCamion.delete(form.getCam_patente());}catch(Exception e){}
			}
			Camion camion=new Camion();
			camion.setCam_patente(cam_patente.toUpperCase());
			camion.setCam_observacion(form.getCam_observacion().toUpperCase());
			camion.setEstado(form.getEstado().equals("0")?"Bloqueado":"No Bloqueado");
			camion.setEnviado(0);
			DAOCamion.add(camion);
			
    		
    		form.setSuccessMessage("Operacion Realizada Exitosamente.");
    		form.setErrorMessage("");
			return mapping.findForward("success");
		}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
    		form.setSuccessMessage("");
			return mapping.findForward("error");
		}finally{
			List<Camion> camiones = DAOCamion.list("");
    		if(camiones!=null){form.setCamiones(camiones);}
    		else {form.setCamiones(new ArrayList<Camion>());}
    		form.setCam_patente("");
    		form.setCam_observacion("");
    		form.setEstado("0");
    		form.setEnviado(0);
    		
    		String userName = (String)request.getSession().getAttribute("userName");
    		String password = (String)request.getSession().getAttribute("password");
    		Usuario usuario = UsuarioUtil.checkUser(userName, password);
    		form.setUsuario(usuario);
		}
	}
}