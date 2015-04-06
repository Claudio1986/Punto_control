
package cl.puntocontrol.struts.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import cl.puntocontrol.hibernate.domain.Chofer;
import cl.puntocontrol.hibernate.domain.Usuario;

public class ChoferesForm extends ActionForm implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	private String nombre ="";
	
	private String 	rut_chofer="";
	private String 	nombre_chofer="";
	private String 	fono="";
	private String 	estado="";
	private int 	enviado=0;

	private String successMessage="";
	private String errorMessage="";

	public Usuario getUsuario() {
		return usuario;
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

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private List<Chofer> choferes = new ArrayList<Chofer>();
	
    public ChoferesForm() {
    }

	public String getRut_chofer() {
		return rut_chofer;
	}

	public void setRut_chofer(String rut_chofer) {
		this.rut_chofer = rut_chofer;
	}

	public String getNombre_chofer() {
		return nombre_chofer;
	}

	public void setNombre_chofer(String nombre_chofer) {
		this.nombre_chofer = nombre_chofer;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getEnviado() {
		return enviado;
	}

	public void setEnviado(int enviado) {
		this.enviado = enviado;
	}

	public List<Chofer> getChoferes() {
		return choferes;
	}

	public void setChoferes(List<Chofer> choferes) {
		this.choferes = choferes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}

