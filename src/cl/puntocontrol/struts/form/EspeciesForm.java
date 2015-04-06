
package cl.puntocontrol.struts.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import cl.puntocontrol.hibernate.domain.Especie;
import cl.puntocontrol.hibernate.domain.Usuario;

public class EspeciesForm extends ActionForm implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	private String nombre ="";
	
	private int 	id_especie=0;
	private String 	nombre_especie="";

	private List<Especie> especies = new ArrayList<Especie>();
	
	private String successMessage="";
	private String errorMessage="";
	
    public EspeciesForm() {
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

	public List<Especie> getEspecies() {
		return especies;
	}

	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}

