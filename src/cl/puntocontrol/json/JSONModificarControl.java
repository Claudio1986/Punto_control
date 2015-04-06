package cl.puntocontrol.json;  
      
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.puntocontrol.hibernate.dao.DAOPunto_Control;
import cl.puntocontrol.hibernate.domain.Punto_Control;
      
    public class JSONModificarControl extends HttpServlet  
    {  
        public void init( ServletConfig config ) throws ServletException  
        {  
        }  
        public final void doGet( HttpServletRequest request, HttpServletResponse response )  
            throws ServletException, IOException  
        {    
            try  
            {  
            	String id_control=request.getParameter("parentId");
        		Punto_Control pc = DAOPunto_Control.get(id_control);
        		String fecha = pc.getFecha().toString()==null?" ":pc.getFecha().toString();;
				String ano= fecha.split("-")[0];
				String mes= fecha.split("-")[1];
				String dia= fecha.split("-")[2].split(" ")[0];
				fecha = dia+"-"+mes+"-"+ano;
				String obs_mod = pc.getObs_modificacion()==null?" ":pc.getObs_modificacion();
        		String jsonLista="[{\"patente\": \""+pc.getPatente()+"\", \"patente_carro\": \""+pc.getPatente_carro()+
        				"\", \"guia_despacho\": \""+pc.getGuia_despacho()+
        				"\", \"rut_chofer\": \""+pc.getRut_chofer()+
        				"\", \"nombre_chofer\": \""+pc.getNombre_chofer()+
        				"\", \"nombre_transportista\": \""+pc.getNombre_transportista()+
        				"\", \"rut_transportista\": \""+pc.getRut_transportista()+
        				"\", \"id_especie\": \""+pc.getId_especie()+
        				"\", \"nombre_especie\": \""+pc.getNombre_especie()+
        				"\", \"codigo_producto\": \""+pc.getCodigo_producto()+
        				"\", \"nombre_producto\": \""+pc.getNombre_producto()+
        				"\", \"fecha\": \""+fecha+
        				"\", \"hora\": \""+pc.getHora()+
        				"\", \"foto1\": \""+pc.getFoto1()+
        				"\", \"foto2\": \""+pc.getFoto2()+
        				"\", \"cod_sap\": \""+pc.getCodigo_sap()+
        				"\", \"obs\": \""+pc.getObservacion()+
        				"\", \"obs_mod\": \""+obs_mod+
        				"\", \"usuario_\": \""+pc.getUsuario()+
        				"\", \"nombre_control_detalle_mod\": \""+pc.getNombre_control_detalle()+
        				"\"}]";
        		response.setContentType("text/html");
        		PrintWriter writer=response.getWriter();
        		writer.write(jsonLista);
        		writer.close();
            }  
            catch(Exception ex)  
            {  
            }  
        }  
    }  
