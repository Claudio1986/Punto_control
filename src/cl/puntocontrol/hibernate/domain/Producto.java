package cl.puntocontrol.hibernate.domain;
import java.io.Serializable;


public class Producto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8890046680270595773L;
	
	private String 	prd_codigo="";
	private String 	prd_descripcion="";
	private int 	codigo_especie=0;
	
	public Producto()
	{
		
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
