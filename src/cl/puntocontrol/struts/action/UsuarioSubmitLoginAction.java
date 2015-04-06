package cl.puntocontrol.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.struts.form.LoginUsuarioForm;

public class UsuarioSubmitLoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm _form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    	LoginUsuarioForm form = (LoginUsuarioForm)_form;
    	try{
    		if(form.getNombre()!=null&&form.getNombre().length()>0 && form.getClave_acceso()!=null&&form.getClave_acceso().length()>0){
        		Usuario usuario = UsuarioUtil.checkUser(form.getNombre(), form.getClave_acceso());
	    		if( usuario!=null){
	    			form.setUsuario(usuario);
	    			HttpSession session = request.getSession();
	    		    session.setAttribute("userName", usuario.getNombre());
	    		    session.setAttribute("password", usuario.getClave_acceso());
	    		    
	    		    form.setSuccessMessage("");
	    			return mapping.findForward("success");
	    		}
	    		else {
	    			form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
	    			return mapping.findForward("error");}
    		}
    		else{ 
    			form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
    			return mapping.findForward("error");}
    		
    	}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
    		return mapping.findForward("error");
    	}
    	finally{
    	}
    }

}