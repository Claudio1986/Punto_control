package cl.puntocontrol.json;  
      
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.puntocontrol.hibernate.dao.DAOChofer;
import cl.puntocontrol.hibernate.domain.Chofer;
      
    public class JSONChoferesEstado extends HttpServlet  
    {  
        public void init( ServletConfig config ) throws ServletException  
        {  
        }  
        public final void doGet( HttpServletRequest request, HttpServletResponse response )  
            throws ServletException, IOException  
        {    
            try  
            {  
            	String rut_chofer=request.getParameter("parentId");
        		Chofer chofer = DAOChofer.get(rut_chofer);
        		String estado = "";
        		String rut = formatear(chofer.getRut_chofer());

        		if(chofer.getEstado().equals("Bloqueado"))estado="0";
            	if(chofer.getEstado().equals("No Bloqueado"))estado="1";

        		String jsonLista="[{\"rut_chofer\": \""+rut+"\", \"nombre_chofer\": \""+chofer.getNombre_chofer()+"\", \"fono\": \""+chofer.getFono()+"\", \"estado\": \""+estado+"\"}]";
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
