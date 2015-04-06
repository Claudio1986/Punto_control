
package cl.puntocontrol.struts.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import cl.puntocontrol.hibernate.domain.Camion;
import cl.puntocontrol.hibernate.domain.Chofer;
import cl.puntocontrol.hibernate.domain.Especie;
import cl.puntocontrol.hibernate.domain.Producto;
import cl.puntocontrol.hibernate.domain.Transportista;
import cl.puntocontrol.hibernate.domain.Usuario;

public class PuntoControlForm extends ActionForm implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Login*/
	
	private Usuario usuario = new Usuario();

	private String nombre = "";
    
    /*Para tabla jquery*/
    private String jsonControles ="";
    
    /*Para Posibles Filtros*/
    private String id_control= "";
    private String patente= "";
    private Date   fecha = new Date();
    private String rut_chofer= "";
    private String nombre_chofer= "";
    private String hora= "";
    private String fecha_string= "";
    private String rut_transportista= "";
    private String nombre_transportista= "";
    private String guia_despacho= "";
    private String nombre_control_detalle= "";
    private String nombre_control_detalle_mod= "";
	private String nombre_producto= "";
	private String patente_carro= "";
	private String codigo_producto= "";
	private String nombre_especie= "";
	private Integer id_especie= 0;
	private String cod_sap= "";
	private String obs= "";
	private String obs_mod= "";

	private String dd= "";
	private String md= "";
	private String yd= "";
	private String dh= "";
	private String mh= "";
	private String yh= "";
    private String foto1= "";
    private String foto2= "";

	/*Para Fecha Actual*/
	private String ddHoy= "";
	private String mmHoy= "";
	private String yyHoy= "";

	private String successMessage="";
	private String errorMessage="";
	
	/**/
	private String usuario_= "";
	private List<Chofer> choferes = new ArrayList<Chofer>();
	private List<Transportista> tranportistas = new ArrayList<Transportista>();
	private List<Camion> camiones = new ArrayList<Camion>();
	private List<Especie> especies = new ArrayList<Especie>();
	private List<Producto> productos = new ArrayList<Producto>();
	
	private String rut_transportista_temporal="";

	public String getSuccessMessage() {
		return successMessage;
	}
	
	public String getUsuario_() {
		return usuario_;
	}

	public void setUsuario_(String usuario_) {
		this.usuario_ = usuario_;
	}

	public List<Chofer> getChoferes() {
		return choferes;
	}

	public void setChoferes(List<Chofer> choferes) {
		this.choferes = choferes;
	}

	public List<Transportista> getTranportistas() {
		return tranportistas;
	}

	public void setTranportistas(List<Transportista> tranportistas) {
		this.tranportistas = tranportistas;
	}

	public List<Camion> getCamiones() {
		return camiones;
	}

	public void setCamiones(List<Camion> camiones) {
		this.camiones = camiones;
	}

	public List<Especie> getEspecies() {
		return especies;
	}

	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
    public PuntoControlForm() {
    }


	public String getCod_sap() {
		return cod_sap;
	}

	public void setCod_sap(String cod_sap) {
		this.cod_sap = cod_sap;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getObs_mod() {
		return obs_mod;
	}

	public void setObs_mod(String obs_mod) {
		this.obs_mod = obs_mod;
	}

	public String getDd() {
		return dd;
	}


	public void setDd(String dd) {
		this.dd = dd;
	}


	public String getMd() {
		return md;
	}


	public void setMd(String md) {
		this.md = md;
	}


	public String getYd() {
		return yd;
	}


	public void setYd(String yd) {
		this.yd = yd;
	}


	public String getDh() {
		return dh;
	}


	public void setDh(String dh) {
		this.dh = dh;
	}


	public String getMh() {
		return mh;
	}


	public void setMh(String mh) {
		this.mh = mh;
	}


	public String getYh() {
		return yh;
	}


	public void setYh(String yh) {
		this.yh = yh;
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


	public String getRut_chofer() {
		return rut_chofer;
	}


	public void setRut_chofer(String rut_chofer) {
		this.rut_chofer = rut_chofer;
	}


	public String getRut_transportista() {
		return rut_transportista;
	}


	public void setRut_transportista(String rut_transportista) {
		this.rut_transportista = rut_transportista;
	}


	public String getGuia_despacho() {
		return guia_despacho;
	}


	public void setGuia_despacho(String guia_despacho) {
		this.guia_despacho = guia_despacho;
	}


	public String getNombre_control_detalle() {
		return nombre_control_detalle;
	}


	public void setNombre_control_detalle(String nombre_control_detalle) {
		this.nombre_control_detalle = nombre_control_detalle;
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


	public String getNombre_especie() {
		return nombre_especie;
	}


	public void setNombre_especie(String nombre_especie) {
		this.nombre_especie = nombre_especie;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getJsonControles() {
		return jsonControles;
	}


	public void setJsonControles(String jsonControles) {
		this.jsonControles = jsonControles;
	}


	public String getYyHoy() {
		return yyHoy;
	}


	public void setYyHoy(String yyHoy) {
		this.yyHoy = yyHoy;
	}


	public String getMmHoy() {
		return mmHoy;
	}


	public void setMmHoy(String mmHoy) {
		this.mmHoy = mmHoy;
	}


	public String getDdHoy() {
		return ddHoy;
	}


	public void setDdHoy(String ddHoy) {
		this.ddHoy = ddHoy;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getId_control() {
		return id_control;
	}

	public void setId_control(String id_control) {
		this.id_control = id_control;
	}

	public String getNombre_transportista() {
		return nombre_transportista;
	}

	public void setNombre_transportista(String nombre_transportista) {
		this.nombre_transportista = nombre_transportista;
	}

	public String getFoto2() {
		return foto2;
	}

	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}

	public String getFoto1() {
		return foto1;
	}

	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}

	public String getNombre_control_detalle_mod() {
		return nombre_control_detalle_mod;
	}

	public void setNombre_control_detalle_mod(String nombre_control_detalle_mod) {
		this.nombre_control_detalle_mod = nombre_control_detalle_mod;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getFecha_string() {
		return fecha_string;
	}

	public void setFecha_string(String fecha_string) {
		this.fecha_string = fecha_string;
	}

	public Integer getId_especie() {
		return id_especie;
	}

	public void setId_especie(Integer id_especie) {
		this.id_especie = id_especie;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public String getRut_transportista_temporal() {
		return rut_transportista_temporal;
	}

	public void setRut_transportista_temporal(String rut_transportista_temporal) {
		this.rut_transportista_temporal = rut_transportista_temporal;
	}


}

