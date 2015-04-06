package cl.puntocontrol.hibernate.domain;
import java.io.Serializable;


public class Transportista implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8890046680270595773L;
	
	private String 	rut_transportista="";
	private String 	nombre_transportista="";
	private String 	sap_transportista="";
	private Integer estado=0;
	
	public Transportista()
	{
		
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

}
