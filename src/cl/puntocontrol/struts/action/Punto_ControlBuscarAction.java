
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

import cl.puntocontrol.hibernate.dao.DAOPunto_Control;
import cl.puntocontrol.hibernate.domain.Punto_Control;
import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.struts.form.PuntoControlForm;

public class Punto_ControlBuscarAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm _form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
		PuntoControlForm form = (PuntoControlForm)_form;
    	try{
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
			System.out.println("puntos_control.size():"+puntos_control.size());
			System.out.println("puntos_control.size():"+puntos_control.size());

			System.out.println("puntos_control.size():"+puntos_control.size());
			for(int i=0;i<puntos_control.size();i++){
				Punto_Control pc = puntos_control.get(i);
				String fecha = pc.getFecha().toString()==null?" ":pc.getFecha().toString();;
				String ano= fecha.split("-")[0];
				String mes= fecha.split("-")[1];
				String dia= fecha.split("-")[2].split(" ")[0];
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
				String Foto1=pc.getFoto1().toString()==null?" ":pc.getFoto1().toString();
				String Foto2=pc.getFoto2().toString()==null?" ":pc.getFoto2().toString();
				jsonControles+="[\""+fecha+"\",\""+Hora+"\",\""+folio+"\",\""+Punto_Control+"\",\""+guia+"\",\""+Patente+"\",\""+Patente_Carro+"\",\""+Chofer+"\",\""+Proveedor+"\",\""+cod_especie+"\",\""+cod_producto+"\",\""+Producto+"\",\""+rut_prov+"\",\""
						+"<img width='78' height='53'src='/punto_control/imageServlet?idFoto="+Foto1+"&carpeta="+Punto_Control+"' id='"+Foto1+""+"-"+""+Punto_Control+"' onclick='showImagen(this.id)'/>"+"\",\""
						+"<img width='78' height='53'src='/punto_control/imageServlet?idFoto="+Foto2+"&carpeta="+Punto_Control+"' id='"+Foto2+""+"-"+""+Punto_Control+"' onclick='showImagen(this.id)'/>"+"\"]";
				if(i!=puntos_control.size()-1){
					jsonControles+=",";
				}
			}
			jsonControles+="]";
			/*Set JSON*/
			form.setJsonControles(jsonControles);
			/*Set Fecha Actual*/
			
			String userName = (String)request.getSession().getAttribute("userName");
    		String password = (String)request.getSession().getAttribute("password");
    		Usuario usuario = UsuarioUtil.checkUser(userName, password);
    		form.setUsuario(usuario);
			
			form.setSuccessMessage("Busqueda realizada exitosamente.");
			return mapping.findForward("success");
    	}catch(Exception ex){
    		form.setErrorMessage("Ha Ocurrido Un Error Inesperado.");
    		return mapping.findForward("error");
    	}
    	finally{
    	}
    }
}