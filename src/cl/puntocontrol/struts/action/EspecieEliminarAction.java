package cl.puntocontrol.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cl.puntocontrol.hibernate.dao.DAOEspecie;
import cl.puntocontrol.hibernate.domain.Especie;
import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.struts.form.EspeciesForm;

public class EspecieEliminarAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm _form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    	EspeciesForm form = (EspeciesForm)_form;
    	try{
        	DAOEspecie.delete(form.getId_especie());

        	form.setId_especie(0);
        	form.setNombre_especie("");
        	
    		List<Especie> especies = new ArrayList<Especie>();
    		especies = DAOEspecie.list("");
    		form.setEspecies(especies);
    		
    		String userName = (String)request.getSession().getAttribute("userName");
    		String password = (String)request.getSession().getAttribute("password");
    		Usuario usuario = UsuarioUtil.checkUser(userName, password);
    		form.setUsuario(usuario);
    		
    		form.setSuccessMessage("Operacion Realizada Exitosamente.");
			return mapping.findForward("success");
    	}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
    		return mapping.findForward("error");
    	}
    	finally{
    	}
    }
}