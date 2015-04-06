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

public class ProductoGuardarAction extends Action {
	public ActionForward execute(
			ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {
    	ProductosForm form = (ProductosForm)_form;
    	Producto producto = new Producto();
		try{
			String prd_codigo=request.getParameter("prd_codigo_temporal");
			Boolean nuevo=Boolean.valueOf(request.getParameter("nuevo"));
			if(nuevo==false){
				try{DAOProducto.delete(form.getPrd_codigo());}catch(Exception e){}
			}
			
			producto.setPrd_codigo(prd_codigo.toUpperCase());
	    	producto.setPrd_descripcion(form.getPrd_descripcion().toUpperCase());
	    	producto.setCodigo_especie(form.getCodigo_especie());
        	DAOProducto.add(producto);
	    	
        	form.setPrd_codigo("");
        	form.setPrd_descripcion("");
        	form.setCodigo_especie(0);
        	
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
			List<Producto> productos = new ArrayList<Producto>();
    		productos = DAOProducto.list("");
    		form.setProductos(productos);
    		
    		List<Especie> especies = new ArrayList<Especie>();
    		especies = DAOEspecie.list("");
    		form.setEspecies(especies);
		}
	}
}