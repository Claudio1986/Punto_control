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
import cl.puntocontrol.hibernate.dao.DAOProducto;
import cl.puntocontrol.hibernate.domain.Especie;
import cl.puntocontrol.hibernate.domain.Producto;
import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.struts.form.ProductosForm;

public class ProductosBuscarAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm _form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    	ProductosForm form = (ProductosForm)_form;
    	try{
    		List<Producto> productos = new ArrayList<Producto>();
    		productos = DAOProducto.list("");
    		form.setProductos(productos);
    		List<Especie> especies = new ArrayList<Especie>();
    		especies = DAOEspecie.list("");
    		form.setEspecies(especies);
    		
    		form.setPrd_codigo("");
        	form.setPrd_descripcion("");
        	form.setCodigo_especie(0);
        	
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