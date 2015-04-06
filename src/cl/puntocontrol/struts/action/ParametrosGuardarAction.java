package cl.puntocontrol.struts.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cl.puntocontrol.hibernate.dao.DAOParametros;
import cl.puntocontrol.hibernate.domain.Parametros;
import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.struts.form.ParametrosForm;

public class ParametrosGuardarAction extends Action {

	public ActionForward execute(
			ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {
		ParametrosForm form = (ParametrosForm)_form;
		Parametros parametros = new Parametros();
		try{
			
			parametros=DAOParametros.get();
			parametros.setCiudad(form.getCiudad());
			parametros.setFono(form.getFono());
			parametros.setRut(form.getRut());
			parametros.setDireccion(form.getDireccion());
			parametros.setGiro(form.getGiro());
			parametros.setRazon_social(form.getRazon_social());
	    	DAOParametros.update(parametros);
        	
        	String userName = (String)request.getSession().getAttribute("userName");
    		String password = (String)request.getSession().getAttribute("password");
    		Usuario usuario = UsuarioUtil.checkUser(userName, password);
    		form.setUsuario(usuario);
    		
    		form.setSuccessMessage("Operacion Realizada Exitosamente.");
			return mapping.findForward("success");
		}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
			return mapping.findForward("error");
		}finally{
		}
	}
}