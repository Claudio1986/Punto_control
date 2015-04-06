package cl.puntocontrol.json;  
      
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.puntocontrol.hibernate.dao.DAOTransportista;
import cl.puntocontrol.hibernate.domain.Transportista;
      
    public class JSONTransportistaEstado extends HttpServlet  
    {  
        public void init( ServletConfig config ) throws ServletException  
        {  
        }  
        public final void doGet( HttpServletRequest request, HttpServletResponse response )  
            throws ServletException, IOException  
        {    
            try  
            {  
            	String rut_transportista=request.getParameter("parentId");
        		Transportista transportista = DAOTransportista.get(rut_transportista);
        		String rut = formatear(transportista.getRut_transportista());
        		String jsonLista="[{\"rut_transportista\": \""+rut+"\",\"nombre_transportista\": \""+transportista.getNombre_transportista()+"\", \"sap_transportista\": \""+transportista.getSap_transportista()+"\",\"estado\": \""+transportista.getEstado()+"\"}]";
        		
        		response.setContentType("text/html");
        		PrintWriter writer=response.getWriter();
        		writer.write(jsonLista);
        		writer.close();
            }  
            catch(Exception ex)  
            {  
            }  
        } 
        static public String formatear(String rut){
            int cont=0;
            String format;
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            format = "-"+rut.substring(rut.length()-1);
            for(int i = rut.length()-2;i>=0;i--){
                format = rut.substring(i, i+1)+format;
                cont++;
                if(cont == 3 && i != 0){
                    format = "."+format;
                    cont = 0;
                }
            }
            return format;
        }

    }  
