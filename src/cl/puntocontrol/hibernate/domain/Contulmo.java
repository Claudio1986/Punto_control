package cl.puntocontrol.hibernate.domain;
import java.io.Serializable;
import java.util.Date;


public class Contulmo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8890046680270595773L;
	
	private String 	id_control="";
	private Integer id_control_correlativo=0;
	private Integer id_control_detalle=0;
	private String 	nombre_chofer="";
	private String 	patente="";
	private Date 	fecha= new Date();
	private String 	hora="";
	private String 	rut_chofer="";
	private String 	codigo_sap="";
	private String 	rut_transportista="";
	private String 	nombre_transportista="";
	private String 	guia_despacho="";
	private String 	rut_chofer2="";
	private String 	rut_transportista2="";
	private String 	nombre_control_detalle ="";
	private String  observacion="";
	private String  obs_modificacion="";
	private Integer enviado=0;
	private String 	nombre_producto="";
	private String 	patente_carro="";
	private String 	codigo_producto="";
	private Integer foto1=0;
	private Integer foto2=0;
	private Integer id_especie=0;
	private String 	nombre_especie="";
	private String 	usuario="";

	public Contulmo()
	{
		
	}

	public String getId_control() {
		return id_control;
	}

	public void setId_control(String id_control) {
		this.id_control = id_control;
	}

	public Integer getId_control_correlativo() {
		return id_control_correlativo;
	}

	public void setId_control_correlativo(Integer id_control_correlativo) {
		this.id_control_correlativo = id_control_correlativo;
	}

	public Integer getId_control_detalle() {
		return id_control_detalle;
	}

	public void setId_control_detalle(Integer id_control_detalle) {
		this.id_control_detalle = id_control_detalle;
	}

	public String getNombre_chofer() {
		return nombre_chofer;
	}

	public void setNombre_chofer(String nombre_chofer) {
		this.nombre_chofer = nombre_chofer;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getRut_chofer() {
		return rut_chofer;
	}

	public void setRut_chofer(String rut_chofer) {
		this.rut_chofer = rut_chofer;
	}

	public String getCodigo_sap() {
		return codigo_sap;
	}

	public void setCodigo_sap(String codigo_sap) {
		this.codigo_sap = codigo_sap;
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

	public String getGuia_despacho() {
		return guia_despacho;
	}

	public void setGuia_despacho(String guia_despacho) {
		this.guia_despacho = guia_despacho;
	}

	public String getRut_chofer2() {
		return rut_chofer2;
	}

	public void setRut_chofer2(String rut_chofer2) {
		this.rut_chofer2 = rut_chofer2;
	}

	public String getRut_transportista2() {
		return rut_transportista2;
	}

	public void setRut_transportista2(String rut_transportista2) {
		this.rut_transportista2 = rut_transportista2;
	}

	public String getNombre_control_detalle() {
		return nombre_control_detalle;
	}

	public void setNombre_control_detalle(String nombre_control_detalle) {
		this.nombre_control_detalle = nombre_control_detalle;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getObs_modificacion() {
		return obs_modificacion;
	}

	public void setObs_modificacion(String obs_modificacion) {
		this.obs_modificacion = obs_modificacion;
	}

	public Integer getEnviado() {
		return enviado;
	}

	public void setEnviado(Integer enviado) {
		this.enviado = enviado;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getPatente_carro() {
		return patente_carro;
	}

	public void setPatente_carro(String patente_carro) {
		this.patente_carro = patente_carro;
	}

	public String getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Integer getFoto1() {
		return foto1;
	}

	public void setFoto1(Integer foto1) {
		this.foto1 = foto1;
	}

	public Integer getFoto2() {
		return foto2;
	}

	public void setFoto2(Integer foto2) {
		this.foto2 = foto2;
	}

	public Integer getId_especie() {
		return id_especie;
	}

	public void setId_especie(Integer id_especie) {
		this.id_especie = id_especie;
	}

	public String getNombre_especie() {
		return nombre_especie;
	}

	public void setNombre_especie(String nombre_especie) {
		this.nombre_especie = nombre_especie;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
