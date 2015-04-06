
package cl.puntocontrol.struts.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import cl.puntocontrol.hibernate.domain.Camion;
import cl.puntocontrol.hibernate.domain.Usuario;

public class CamionesForm extends ActionForm implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	private String nombre ="";
	
	private String 	cam_patente="";
	private String 	cam_observacion="";
	private String 	estado="";
	private int 	enviado=0;

	private List<Camion> camiones = new ArrayList<Camion>();
	
	private String successMessage="";
	private String errorMessage="";

	
    public CamionesForm() {
    }

	public String getCam_patente() {
		return cam_patente;
	}

	public void setCam_patente(String cam_patente) {
		this.cam_patente = cam_patente;
	}

	public String getCam_observacion() {
		return cam_observacion;
	}

	public void setCam_observacion(String cam_observacion) {
		this.cam_observacion = cam_observacion;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Camion> getCamiones() {
		return camiones;
	}

	public void setCamiones(List<Camion> camiones) {
		this.camiones = camiones;
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

