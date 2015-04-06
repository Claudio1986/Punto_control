
package cl.puntocontrol.struts.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import cl.puntocontrol.hibernate.domain.Especie;
import cl.puntocontrol.hibernate.domain.Producto;
import cl.puntocontrol.hibernate.domain.Usuario;

public class ProductosForm extends ActionForm implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String 	prd_codigo="";
	private String 	prd_descripcion="";
	private int 	codigo_especie=0;

	private Usuario usuario = new Usuario();
	private String nombre ="";
	
	private List<Producto> productos = new ArrayList<Producto>();
	private List<Especie> especies = new ArrayList<Especie>();

	private String successMessage="";
	private String errorMessage="";
	
    public ProductosForm() {
    }

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrd_codigo() {
		return prd_codigo;
	}

	public void setPrd_codigo(String prd_codigo) {
		this.prd_codigo = prd_codigo;
	}

	public String getPrd_descripcion() {
		return prd_descripcion;
	}

	public void setPrd_descripcion(String prd_descripcion) {
		this.prd_descripcion = prd_descripcion;
	}

	public int getCodigo_especie() {
		return codigo_especie;
	}

	public void setCodigo_especie(int codigo_especie) {
		this.codigo_especie = codigo_especie;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Especie> getEspecies() {
		return especies;
	}

	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}


}

