package cl.puntocontrol.hibernate.domain;
import java.io.Serializable;


public class Camion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8890046680270595773L;
	
	private String 	cam_patente="";
	private String 	cam_observacion="";
	private String 	estado="";
	private int 	enviado=0;
	
	public Camion()
	{
		
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

	
}
