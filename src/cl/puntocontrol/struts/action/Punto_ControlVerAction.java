
package cl.puntocontrol.struts.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cl.puntocontrol.hibernate.dao.DAOPunto_Control;
import cl.puntocontrol.hibernate.domain.Punto_Control;
import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.struts.form.PuntoControlForm;

public class Punto_ControlVerAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm _form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    	PuntoControlForm form = (PuntoControlForm)_form;
    	try{
    		
			String jsonControles="[";

			Date fechaHoy = new Date();
			fechaHoy.setHours(0);
			fechaHoy.setMinutes(0);
			fechaHoy.setSeconds(0);
			Date fechaHoy2 = new Date();
			fechaHoy2.setHours(0);
			fechaHoy2.setMinutes(0);
			fechaHoy2.setSeconds(0);
			List<Punto_Control> puntos_control = DAOPunto_Control.list(	  ""
																		, ""
																		, fechaHoy
																		, fechaHoy2
																		, ""
																		, ""
																		, ""
																		, ""
																		, ""
																		, ""
																		, ""
																		, ""
																		, "");
														
			/*Parse JSON*/
			for(int i=0;i<puntos_control.size();i++){
			Punto_Control pc = puntos_control.get(i);
			String fecha = pc.getFecha().toString()==null?" ":pc.getFecha().toString();;
			String ano= fecha.split("-")[0];
			String mes= fecha.split("-")[1];
			String dia= fecha.split("-")[2].split(" ")[0];
			fecha = dia+"-"+mes+"-"+ano;
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
			String Foto1=pc.getFoto1().toString()==null?" ":pc.getFoto1().toString();
			String Foto2=pc.getFoto2().toString()==null?" ":pc.getFoto2().toString();
			jsonControles+="[\""+fecha+"\",\""+Hora+"\",\""+folio+"\",\""+Punto_Control+"\",\""+guia+"\",\""+Patente+"\",\""+Patente_Carro+"\",\""+Chofer+"\",\""+Proveedor+"\",\""+cod_especie+"\",\""+cod_producto+"\",\""+Producto+"\",\""+rut_prov+"\",\""
			+"<img width='78' height='53' src='/punto_control/imageServlet?idFoto="+Foto1+"&carpeta="+Punto_Control+"' id='"+Foto1+""+"-"+""+Punto_Control+"' onclick='showImagen(this.id)'/>"+"\",\""
			+"<img width='78' height='53' src='/punto_control/imageServlet?idFoto="+Foto2+"&carpeta="+Punto_Control+"' id='"+Foto2+""+"-"+""+Punto_Control+"' onclick='showImagen(this.id)'/>"+"\"]";
			if(i!=puntos_control.size()-1){
			jsonControles+=",";
			}
			}
			jsonControles+="]";
			/*Set JSON*/
			form.setJsonControles(jsonControles);
    		
    		form.setNombre_control_detalle("0");
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String Hoy = dateFormat.format(date);
			
			form.setDd(Integer.valueOf(Hoy.split("/")[2]).toString());
			form.setMd(Integer.valueOf(Hoy.split("/")[1]).toString());
			form.setYd(Integer.valueOf(Hoy.split("/")[0]).toString());
			
			form.setDh(Integer.valueOf(Hoy.split("/")[2]).toString());
			form.setMh(Integer.valueOf(Hoy.split("/")[1]).toString());
			form.setYh(Integer.valueOf(Hoy.split("/")[0]).toString());
			
			form.setDdHoy(Integer.valueOf(Hoy.split("/")[2]).toString());
			form.setMmHoy(Integer.valueOf(Hoy.split("/")[1]).toString());
			form.setYyHoy(Integer.valueOf(Hoy.split("/")[0]).toString());

			String userName = (String)request.getSession().getAttribute("userName");
    		String password = (String)request.getSession().getAttribute("password");
    		Usuario usuario = UsuarioUtil.checkUser(userName, password);
    		form.setUsuario(usuario);
			
			form.setSuccessMessage("");
			return mapping.findForward("success");
    	}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
    		return mapping.findForward("error");
    	}
    	finally{
    	}
    }
}