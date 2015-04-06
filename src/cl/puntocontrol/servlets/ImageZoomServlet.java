    package cl.puntocontrol.servlets;  
      
    import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
      
    public class ImageZoomServlet extends HttpServlet  
    {  
        private static final long serialVersionUID = 1;
        private static String maxAge = "3600";  
        private static Log      log = LogFactory.getLog( ImageZoomServlet.class );  

        public void init( ServletConfig config ) throws ServletException  
        {  
        }  
      
        public final void doGet( HttpServletRequest request, HttpServletResponse response )  
            throws ServletException, IOException  
        {    
            try  
            {  
            	String idFoto = request.getParameter( "idFoto" );  
                String carpeta = request.getParameter( "carpeta" );  
                if( idFoto == null ){  
                    response.sendError( HttpServletResponse.SC_BAD_REQUEST, "Missing image parameter" );  
                    return;  
                } 
                String fileName ="C:\\Servidor\\fotos\\"+carpeta+"\\"+idFoto+".jpg";  
                File imageFile = new File( fileName );  
                if( !imageFile.exists()) {  
                    response.sendError(HttpServletResponse.SC_NOT_FOUND,"File " + idFoto + " not found" );  
                    return;  
                }  
                  
                BufferedImage img = ImageIO.read( imageFile );
		        response.setContentType("image/jpeg");  
                response.setHeader( "Cache-Control", "max-age=" + maxAge );  
                ImageIO.write( img, "jpeg", response.getOutputStream() );  
                
            }  
            catch(Exception e)  
            {  
                log.error("Got exception resizing image", e);  
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage() );  
            }  
        }  
    }  