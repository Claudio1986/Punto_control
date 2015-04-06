package cl.puntocontrol.hibernate.domain;
import java.io.Serializable;


public class Chofer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8890046680270595773L;
	
	private String 	rut_chofer="";
	private String 	nombre_chofer="";
	private String 	fono="";
	private String 	estado="";
	private int 	enviado=0;
	
	public Chofer()
	{
		
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
