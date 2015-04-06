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

public class ParametrosVerAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm _form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    	ParametrosForm form = (ParametrosForm)_form;
    	try{
    		Parametros parametros = DAOParametros.get();

    		form.setRazon_social(parametros.getRazon_social()!=null?parametros.getRazon_social():"");
    		form.setGiro(parametros.getGiro()!=null?parametros.getGiro():"");
    		form.setDireccion(parametros.getDireccion()!=null?parametros.getDireccion():"");
    		form.setRut(parametros.getRut()!=null?parametros.getRut():"");
    		form.setFono(parametros.getFono()!=null?parametros.getFono():"");
    		form.setCiudad(parametros.getCiudad()!=null?parametros.getCiudad():"");
    		
    		String userName = (String)request.getSession().getAttribute("userName");
    		String password = (String)request.getSession().getAttribute("password");
    		Usuario usuario = UsuarioUtil.checkUser(userName, password);
    		form.setUsuario(usuario);
    		
    		form.setSuccessMessage("");
			return mapping.findForward("success");
    	}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
			return mapping.findForward("error");
    	}
    	finally{
    	}
    }
}