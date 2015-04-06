package cl.puntocontrol.json;  
      
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.puntocontrol.hibernate.dao.DAOUsuario;
import cl.puntocontrol.hibernate.domain.Usuario;
      
    public class JSONUsuarioPermisos extends HttpServlet  
    {  
        public void init( ServletConfig config ) throws ServletException  
        {  
        }  
        public final void doGet( HttpServletRequest request, HttpServletResponse response )  
            throws ServletException, IOException  
        {    
            try  
            {  
            	String nombre=request.getParameter("parentId");
        		Usuario usuario = DAOUsuario.get(nombre);
        		
	    		Integer 	f3=usuario.getF3();	    		
	    		Integer 	f4=usuario.getF4();
	    		Integer 	f5=usuario.getF5();	  
	    		Integer 	f8=usuario.getF8();	  
	    		Integer 	f9=usuario.getF9();	  
	    		Integer 	f11=usuario.getF11();	  
	    		Integer 	f17=usuario.getF17();	    		
	    		Integer 	f18=usuario.getF18();
	    		Integer 	f19=usuario.getF19();	    		
	    		Integer 	f20=usuario.getF20();
	    		
        		String jsonLista="[{\"nombre\": \""+usuario.getNombre()+"\", \"clave_acceso\": \""+usuario.getClave_acceso()+"\"" +
        				", \"f3\": \""+f3+"\""+
        				", \"f4\": \""+f4+"\""+
        				", \"f5\": \""+f5+"\""+
        				", \"f8\": \""+f8+"\""+
        				", \"f9\": \""+f9+"\""+
        				", \"f11\": \""+f11+"\""+
        				", \"f17\": \""+f17+"\""+
        				", \"f18\": \""+f18+"\""+
        				", \"f19\": \""+f19+"\""+
        				", \"f20\": \""+f20+"\""+
        				"}]";
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
