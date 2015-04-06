package cl.puntocontrol.json;  
      
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.puntocontrol.hibernate.dao.DAOProducto;
import cl.puntocontrol.hibernate.domain.Producto;
      
    public class JSONProductoEspecie extends HttpServlet  
    {  
        public void init( ServletConfig config ) throws ServletException  
        {  
        }  
        public final void doGet( HttpServletRequest request, HttpServletResponse response )  
            throws ServletException, IOException  
        {    
            try  
            {  
            	String prd_codigo=request.getParameter("parentId");
        		Producto producto = DAOProducto.get(prd_codigo);
        		
        		String jsonLista="[{\"prd_codigo\": \""+producto.getPrd_codigo()+"\", \"prd_descripcion\": \""+producto.getPrd_descripcion()+"\", \"codigo_especie\": \""+producto.getCodigo_especie()+"\"}]";
        		
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
