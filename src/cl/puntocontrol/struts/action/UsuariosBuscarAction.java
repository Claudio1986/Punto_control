package cl.puntocontrol.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cl.puntocontrol.hibernate.dao.DAOUsuario;
import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.struts.form.UsuarioForm;

public class UsuariosBuscarAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm _form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    	UsuarioForm form = (UsuarioForm)_form;
    	try{
    		List<Usuario> usuarios = null;
    		usuarios = DAOUsuario.list("");
    		
    		if(usuarios!=null){form.setUsuarios(usuarios);}
    		else {form.setUsuarios(new ArrayList<Usuario>());}
    		form.setNombre("");
    		form.setClave_acceso("");
    		form.setF1(0);    		form.setF2(0);
    		form.setF3(0);    		form.setF4(0);
    		form.setF5(0);    		form.setF6(0);
    		form.setF7(0); 			form.setF8(0);
    		form.setF8(0);    		form.setF10(0);
    		form.setF11(0);    		form.setF12(0);
    		form.setF13(0);    		form.setF14(0);
    		form.setF15(0);    		form.setF16(0);
    		form.setF17(0);    		form.setF18(0);
    		form.setF19(0);    		form.setF20(0);
    		
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