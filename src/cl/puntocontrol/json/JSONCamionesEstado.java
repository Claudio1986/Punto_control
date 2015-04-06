package cl.puntocontrol.json;  
      
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.puntocontrol.hibernate.dao.DAOCamion;
import cl.puntocontrol.hibernate.domain.Camion;
      
    public class JSONCamionesEstado extends HttpServlet  
    {  
        public void init( ServletConfig config ) throws ServletException  
        {  
        }  
        public final void doGet( HttpServletRequest request, HttpServletResponse response )  
            throws ServletException, IOException  
        {    
            try  
            {  
            	String cam_patente=request.getParameter("parentId");
        		Camion camion = DAOCamion.get(cam_patente);
        		String estado = "";
        		if(camion.getEstado().equals("Bloqueado"))estado="0";
            	if(camion.getEstado().equals("No Bloqueado"))estado="1";

        		String jsonLista="[{\"cam_patente\": \""+camion.getCam_patente()+"\", \"cam_observacion\": \""+camion.getCam_observacion()+"\", \"estado\": \""+estado+"\"}]";
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
