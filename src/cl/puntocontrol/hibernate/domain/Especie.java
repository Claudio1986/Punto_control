package cl.puntocontrol.hibernate.domain;
import java.io.Serializable;


public class Especie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8890046680270595773L;
	
	private int 	id_especie=0;
	private String 	nombre_especie="";
	
	public Especie()
	{
		
	}

	public int getId_especie() {
		return id_especie;
	}

	public void setId_especie(int id_especie) {
		this.id_especie = id_especie;
	}

	public String getNombre_especie() {
		return nombre_especie;
	}

	public void setNombre_especie(String nombre_especie) {
		this.nombre_especie = nombre_especie;
	}

}
