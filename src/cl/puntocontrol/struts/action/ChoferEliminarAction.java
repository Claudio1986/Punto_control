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

public class ChoferEliminarAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm _form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    	ChoferesForm form = (ChoferesForm)_form;
    	try{
        	DAOChofer.delete(form.getRut_chofer());

        	List<Chofer> choferes = new ArrayList<Chofer>();
        	choferes=DAOChofer.list("","");
    		
    		form.setChoferes(choferes);
    		form.setRut_chofer("");
    		form.setNombre_chofer("");
    		form.setFono("");
    		form.setEstado("0");
    		
    		String userName = (String)request.getSession().getAttribute("userName");
    		String password = (String)request.getSession().getAttribute("password");
    		Usuario usuario = UsuarioUtil.checkUser(userName, password);
    		form.setUsuario(usuario);
    		
    		form.setSuccessMessage("Operacion Realizada Exitosamente.");
    		form.setErrorMessage("");
			return mapping.findForward("success");
    	}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
    		form.setSuccessMessage("");
    		return mapping.findForward("error");
    	}
    	finally{
    	}
    }
}