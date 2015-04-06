
package cl.puntocontrol.struts.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import cl.puntocontrol.hibernate.domain.Transportista;
import cl.puntocontrol.hibernate.domain.Usuario;

public class TransportistasForm extends ActionForm implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String 	rut_transportista="";
	private String 	nombre_transportista="";
	private String 	sap_transportista="";
	private Integer estado=0;

	private Usuario usuario = new Usuario();
	private String nombre ="";
	
	private List<Transportista> transportistas = new ArrayList<Transportista>();
	
	private String successMessage="";
	private String errorMessage="";
	
    public TransportistasForm() {
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

	public String getRut_transportista() {
		return rut_transportista;
	}

	public void setRut_transportista(String rut_transportista) {
		this.rut_transportista = rut_transportista;
	}

	public String getNombre_transportista() {
		return nombre_transportista;
	}

	public void setNombre_transportista(String nombre_transportista) {
		this.nombre_transportista = nombre_transportista;
	}

	public String getSap_transportista() {
		return sap_transportista;
	}

	public void setSap_transportista(String sap_transportista) {
		this.sap_transportista = sap_transportista;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Transportista> getTransportistas() {
		return transportistas;
	}

	public void setTransportistas(List<Transportista> transportistas) {
		this.transportistas = transportistas;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

    
}

