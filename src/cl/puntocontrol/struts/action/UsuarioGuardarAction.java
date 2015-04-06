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

public class UsuarioGuardarAction extends Action {
	public ActionForward execute(
			ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {
    	UsuarioForm form = (UsuarioForm)_form;
		try{
			form.setNombre(request.getParameter("nombre"));
			Usuario usuario = null;
			usuario = DAOUsuario.get(form.getNombre());
			if(null==usuario){//NUEVO
				usuario=new Usuario();
				usuario.setNombre(form.getNombre().toUpperCase());
				usuario.setClave_acceso(form.getClave_acceso().toUpperCase());
				usuario.setF3(form.getF3()); 
				usuario.setF4(form.getF4());
				usuario.setF5(form.getF5());
				usuario.setF8(form.getF8());
				usuario.setF9(form.getF9());
				usuario.setF11(form.getF11());
				usuario.setF17(form.getF17());
				usuario.setF18(form.getF18());
				usuario.setF19(form.getF19());
				usuario.setF20(form.getF20());
				DAOUsuario.add(usuario);
			}
			else{//EXISTENTE
				usuario=DAOUsuario.get(form.getNombre());
				usuario.setNombre(form.getNombre());
				usuario.setClave_acceso(form.getClave_acceso());
				usuario.setF3(form.getF3()); 
				usuario.setF4(form.getF4());
				usuario.setF5(form.getF5());
				usuario.setF8(form.getF8());
				usuario.setF9(form.getF9());
				usuario.setF11(form.getF11());
				usuario.setF17(form.getF17());
				usuario.setF18(form.getF18());
				usuario.setF19(form.getF19());
				usuario.setF20(form.getF20());
				DAOUsuario.update(usuario);
			}
			
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
    		form.setF9(0);    		form.setF10(0);
    		form.setF11(0);    		form.setF12(0);
    		form.setF13(0);    		form.setF14(0);
    		form.setF15(0);    		form.setF16(0);
    		form.setF17(0);    		form.setF18(0);
    		form.setF19(0);    		form.setF20(0);
    		
    		String userName = (String)request.getSession().getAttribute("userName");
    		String password = (String)request.getSession().getAttribute("password");
    		Usuario usuarioForm = UsuarioUtil.checkUser(userName, password);
    		form.setUsuario(usuarioForm);
    		
    		form.setSuccessMessage("Operacion Realizada Exitosamente.");
			return mapping.findForward("success");
		}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
			return mapping.findForward("error");
		}finally{
		}
	}
}