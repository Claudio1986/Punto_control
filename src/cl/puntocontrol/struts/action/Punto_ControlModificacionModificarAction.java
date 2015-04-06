
package cl.puntocontrol.struts.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cl.puntocontrol.hibernate.dao.DAOCamion;
import cl.puntocontrol.hibernate.dao.DAOChofer;
import cl.puntocontrol.hibernate.dao.DAOEspecie;
import cl.puntocontrol.hibernate.dao.DAOProducto;
import cl.puntocontrol.hibernate.dao.DAOPunto_Control;
import cl.puntocontrol.hibernate.dao.DAOTransportista;
import cl.puntocontrol.hibernate.domain.Camion;
import cl.puntocontrol.hibernate.domain.Chofer;
import cl.puntocontrol.hibernate.domain.Especie;
import cl.puntocontrol.hibernate.domain.Producto;
import cl.puntocontrol.hibernate.domain.Punto_Control;
import cl.puntocontrol.hibernate.domain.Transportista;
import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.struts.form.PuntoControlForm;

public class Punto_ControlModificacionModificarAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm _form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
		PuntoControlForm form = (PuntoControlForm)_form;
    	try{
    		/**/
    		String userName = (String)request.getSession().getAttribute("userName");
    		String password = (String)request.getSession().getAttribute("password");
    		Usuario usuario = UsuarioUtil.checkUser(userName, password);
    		
    		form.setUsuario(usuario);
    		
    		Punto_Control pc =DAOPunto_Control.get(form.getId_control());
    		if(!form.getRut_transportista_temporal().equals(pc.getRut_transportista())){
    			Transportista trans = DAOTransportista.get(form.getRut_transportista());
    			if(trans!=null){pc.setCodigo_sap(trans.getSap_transportista());}
    		}
    		pc.setPatente(form.getPatente().toUpperCase());
    		pc.setPatente_carro(form.getPatente_carro().toUpperCase());
    		pc.setGuia_despacho(form.getGuia_despacho().toUpperCase());
    		pc.setRut_chofer(form.getRut_chofer());
    		pc.setNombre_chofer(form.getNombre_chofer());
        	pc.setNombre_transportista(form.getNombre_transportista().toUpperCase());
    		pc.setRut_transportista(form.getRut_transportista().toUpperCase());
        	pc.setId_especie(form.getId_especie());
    		pc.setNombre_especie(form.getNombre_especie());
    		pc.setNombre_producto(form.getNombre_producto().toUpperCase());
    		pc.setCodigo_producto(form.getCodigo_producto());
    		pc.setObservacion(form.getObs().toUpperCase());
    		pc.setObs_modificacion(form.getObs_mod().toUpperCase());
    		pc.setUsuario(usuario.getNombre());
    		DAOPunto_Control.update(pc);
    		
    		ControlUtil.modificar(pc);
    		
    		form.setId_control(pc.getId_control());
    		form.setFoto1(String.valueOf(pc.getFoto1()));
    		form.setFoto2(String.valueOf(pc.getFoto2()));
    		form.setUsuario_(pc.getUsuario());

    		String fecha = pc.getFecha().toString()==null?" ":pc.getFecha().toString();;
			String ano= fecha.split("-")[0];
			String mes= fecha.split("-")[1];
			String dia= fecha.split("-")[2].split(" ")[0];
			fecha = dia+"-"+mes+"-"+ano;
    		form.setFecha_string(fecha);
    		form.setHora(pc.getHora());
    		form.setNombre_control_detalle_mod(pc.getNombre_control_detalle());
    		
    		List<Camion> camiones = DAOCamion.list(""); 
			Camion cm = new Camion();	cm.setCam_patente(pc.getPatente());		cm.setCam_observacion(pc.getPatente());
			camiones.add(cm);
			form.setCamiones(camiones);form.setPatente(pc.getPatente());

			List<Especie> especies = DAOEspecie.list(""); 
			Especie es = new Especie();	es.setId_especie(pc.getId_especie());		es.setNombre_especie(pc.getNombre_especie());
			especies.add(es);
			form.setEspecies(especies);form.setId_especie(pc.getId_especie());
			
			List<Producto> productos = DAOProducto.list(""); 
			Producto pr = new Producto();	pr.setPrd_codigo(pc.getCodigo_producto());		pr.setPrd_descripcion(pc.getNombre_producto());
			productos.add(pr);
			form.setProductos(productos);form.setCodigo_producto(pc.getCodigo_producto());
			
			List<Transportista> tranportistas = DAOTransportista.list("",""); 
			Transportista tr = new Transportista();	tr.setRut_transportista(pc.getRut_transportista());		tr.setNombre_transportista(pc.getNombre_transportista());
			tranportistas.add(tr);
			form.setTranportistas(tranportistas);form.setRut_transportista(pc.getRut_transportista());	form.setRut_transportista_temporal(pc.getRut_transportista());
			
			List<Chofer> choferes = DAOChofer.list("",""); 
			Chofer ch = new Chofer();	ch.setRut_chofer(pc.getRut_chofer());		ch.setNombre_chofer(pc.getNombre_chofer());
			choferes.add(ch);
			form.setChoferes(choferes);form.setRut_chofer(pc.getRut_chofer());
			
			form.setJsonControles(setJson(form,pc,fecha,dia,mes,ano));
			
			form.setSuccessMessage("Modificacion realizada exitosamente.");
    		form.setErrorMessage("");
			return mapping.findForward("success");
    	}catch(Exception ex){
    		System.out.println(ex);
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
			form.setSuccessMessage("");
    		return mapping.findForward("error");
    	}
    	finally{
    		
    	}
    }
    public static String setJson(PuntoControlForm form, Punto_Control pc, String fecha, String dia, String mes, String ano) throws Exception{
    	String jsonControles="[";
		/*Parse Fechas*/
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDesde = null;
		Date fechaHasta = null;
		try {
			fechaDesde = df.parse(form.getYd()+"-"+form.getMd()+"-"+form.getDd());
			fechaHasta = df.parse(form.getYh()+"-"+form.getMh()+"-"+form.getDh());
		} catch (ParseException ex) {}
		/*Parse Punto Control*/
		String nombre_control_detalle = form.getNombre_control_detalle();
		if(nombre_control_detalle.equals("0"))nombre_control_detalle="";
		if(nombre_control_detalle.equals("1"))nombre_control_detalle="ESCUADRON";
		if(nombre_control_detalle.equals("2"))nombre_control_detalle="CONTULMO";
		if(nombre_control_detalle.equals("3"))nombre_control_detalle="SANTAJUANA";
		
		List<Punto_Control> puntos_control = DAOPunto_Control.list(	  ""
																	, ""
																	, fechaDesde
																	, fechaHasta
																	, ""
																	, ""
																	, ""
																	, nombre_control_detalle!=null&&nombre_control_detalle.length()>0?nombre_control_detalle:""
																	, ""
																	, ""
																	, ""
																	, ""
																	, "");
				
		/*Parse JSON*/
		for(int i=0;i<puntos_control.size();i++){
			pc = puntos_control.get(i);
			fecha = pc.getFecha().toString()==null?" ":pc.getFecha().toString();;
			ano= fecha.split("-")[0];
			mes= fecha.split("-")[1];
			dia= fecha.split("-")[2].split(" ")[0];
			fecha = "<div style='width:75px;'>"+dia+"-"+mes+"-"+ano+"</div>";
			String Hora=pc.getHora()==null?" ":pc.getHora().toString();;
			String folio=pc.getId_control()==null?" ":pc.getId_control().toString();;
			String Punto_Control=pc.getNombre_control_detalle()==null?" ":pc.getNombre_control_detalle().toString();;
			String guia=pc.getGuia_despacho()==null?" ":pc.getGuia_despacho().toString();;
			String Patente=pc.getPatente()==null?" ":pc.getPatente().toString();;
			String Patente_Carro=pc.getPatente_carro()==null?" ":pc.getPatente_carro().toString();;
			String Chofer=pc.getNombre_chofer()==null?" ":pc.getNombre_chofer().toString();;
			String Proveedor=pc.getNombre_transportista()==null?" ":pc.getNombre_transportista().toString();
			String cod_especie=pc.getId_especie().toString()==null?" ":pc.getId_especie().toString();
			String cod_producto=pc.getCodigo_producto().toString()==null?" ":pc.getCodigo_producto().toString();
			String Producto=pc.getNombre_producto()==null?" ":pc.getNombre_producto().toString();
			String rut_prov=pc.getRut_transportista()==null?" ":pc.getRut_transportista().toString();
			jsonControles+="[\""+fecha+"\",\""+Hora+"\",\""+folio+"\",\""+Punto_Control+"\",\""+guia+"\",\""+Patente+"\",\""+Patente_Carro+"\",\""+Chofer+"\",\""+Proveedor+"\",\""+cod_especie+"\",\""+cod_producto+"\",\""+Producto+"\",\""+rut_prov+"\",\""
					+"<input type='button' onclick='modificarSubmitForm(this.id)' value='Visualizar' id='"+folio+"'></input>"+"\"]";
			if(i!=puntos_control.size()-1){
				jsonControles+=",";
			}
		}
		jsonControles+="]";
		
		return jsonControles;
    }
}