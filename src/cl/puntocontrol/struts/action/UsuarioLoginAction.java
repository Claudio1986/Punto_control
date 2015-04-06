
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

public class UsuarioLoginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm _form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    	LoginUsuarioForm form = (LoginUsuarioForm)_form;
    	try{
    		form.setNombre("");
    		form.setClave_acceso("");
    		
    		HttpSession session = request.getSession();
		    String userName = (String)session.getAttribute("userName");
		    String password = (String)session.getAttribute("password");
		    
    		Usuario usuario = UsuarioUtil.checkUser(userName, password);
		    
		    if(usuario!=null&&userName!=null&&userName.length()>0&&password!=null&&password.length()>0){//sesion existente redirecciona a welcome.jsp
    			form.setUsuario(usuario);
	    		return mapping.findForward("session");
		    }
		    else{									//sesion nueva redirecciona a login.jsp
	    		return mapping.findForward("success");
		    }
    	}catch(Exception ex){
    		return mapping.findForward("error");
    	}
    	finally{
    		
    	}
        
    }

}
