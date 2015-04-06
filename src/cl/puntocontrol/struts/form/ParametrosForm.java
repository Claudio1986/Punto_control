package cl.puntocontrol.struts.form;

import java.io.Serializable;

import org.apache.struts.action.ActionForm;

import cl.puntocontrol.hibernate.domain.Usuario;

public class ParametrosForm extends ActionForm implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();

    private String successMessage="";
	private String errorMessage="";
	
	private String rut="";
	private String direccion="";
	private String giro="";
	private String ciudad="";
	private String fono="";
	private String num_instal="";
	private String razon_social="";

    public ParametrosForm() {
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getGiro() {
		return giro;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getNum_instal() {
		return num_instal;
	}

	public void setNum_instal(String num_instal) {
		this.num_instal = num_instal;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}

