
package cl.puntocontrol.struts.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import cl.puntocontrol.hibernate.domain.Usuario;

public class UsuarioForm extends ActionForm implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Login*/
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	private Usuario usuario = new Usuario();

	private String nombre = "";
    private String clave_acceso = "";
    
    private String successMessage="";
	private String errorMessage="";
	
	private Integer 	f1=0;
	private Integer 	f2=0;
	private Integer 	f3=0;
	private Integer 	f4=0;
	private Integer 	f5=0;
	private Integer 	f6=0;
	private Integer 	f7=0;
	private Integer 	f8=0;
	private Integer 	f9=0;
	private Integer 	f10=0;
	private Integer 	f11=0;
	private Integer 	f12=0;
	private Integer 	f13=0;
	private Integer 	f14=0;
	private Integer 	f15=0;
	private Integer 	f16=0;
	private Integer 	f17=0;
	private Integer 	f18=0;
	private Integer 	f19=0;
	private Integer 	f20=0;
	
    public UsuarioForm() {
    }


	public Integer getF1() {
		return f1;
	}


	public void setF1(Integer f1) {
		this.f1 = f1;
	}


	public Integer getF2() {
		return f2;
	}


	public void setF2(Integer f2) {
		this.f2 = f2;
	}


	public Integer getF3() {
		return f3;
	}


	public void setF3(Integer f3) {
		this.f3 = f3;
	}


	public Integer getF4() {
		return f4;
	}


	public void setF4(Integer f4) {
		this.f4 = f4;
	}


	public Integer getF5() {
		return f5;
	}


	public void setF5(Integer f5) {
		this.f5 = f5;
	}


	public Integer getF6() {
		return f6;
	}


	public void setF6(Integer f6) {
		this.f6 = f6;
	}


	public Integer getF7() {
		return f7;
	}


	public void setF7(Integer f7) {
		this.f7 = f7;
	}


	public Integer getF8() {
		return f8;
	}


	public void setF8(Integer f8) {
		this.f8 = f8;
	}


	public Integer getF9() {
		return f9;
	}


	public void setF9(Integer f9) {
		this.f9 = f9;
	}


	public Integer getF10() {
		return f10;
	}


	public void setF10(Integer f10) {
		this.f10 = f10;
	}


	public Integer getF11() {
		return f11;
	}


	public void setF11(Integer f11) {
		this.f11 = f11;
	}


	public Integer getF12() {
		return f12;
	}


	public void setF12(Integer f12) {
		this.f12 = f12;
	}


	public Integer getF13() {
		return f13;
	}


	public void setF13(Integer f13) {
		this.f13 = f13;
	}


	public Integer getF14() {
		return f14;
	}


	public void setF14(Integer f14) {
		this.f14 = f14;
	}


	public Integer getF15() {
		return f15;
	}


	public void setF15(Integer f15) {
		this.f15 = f15;
	}


	public Integer getF16() {
		return f16;
	}


	public void setF16(Integer f16) {
		this.f16 = f16;
	}


	public Integer getF17() {
		return f17;
	}


	public void setF17(Integer f17) {
		this.f17 = f17;
	}


	public Integer getF18() {
		return f18;
	}


	public void setF18(Integer f18) {
		this.f18 = f18;
	}


	public Integer getF19() {
		return f19;
	}


	public void setF19(Integer f19) {
		this.f19 = f19;
	}


	public Integer getF20() {
		return f20;
	}


	public void setF20(Integer f20) {
		this.f20 = f20;
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


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



}

