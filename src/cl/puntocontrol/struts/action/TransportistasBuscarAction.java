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

public class TransportistasBuscarAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm _form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    	TransportistasForm form = (TransportistasForm)_form;
    	try{
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
    		
    		form.setSuccessMessage("");
    		return mapping.findForward("success");
		}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
			return mapping.findForward("error");
		}finally{
		}
    }
}