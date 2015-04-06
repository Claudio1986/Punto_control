
package cl.puntocontrol.struts.form;

import java.io.Serializable;

import org.apache.struts.action.ActionForm;

import cl.puntocontrol.hibernate.domain.Usuario;

public class LoginUsuarioForm extends ActionForm implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Login*/
	
	private Usuario usuario = new Usuario();

	private String nombre = "";
    private String clave_acceso = "";
    
    private String successMessage="";
	private String errorMessage="";

    public LoginUsuarioForm() {
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



	public String getClave_acceso() {
		return clave_acceso;
	}



	public void setClave_acceso(String clave_acceso) {
		this.clave_acceso = clave_acceso;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
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



}

