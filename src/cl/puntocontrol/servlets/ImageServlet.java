    package cl.puntocontrol.servlets;  
      
    import java.awt.Graphics2D;
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
      
    public class ImageServlet extends HttpServlet  
    {  
        private static final long serialVersionUID = 1;
		private static final int IMG_WIDTH = 75;
		private static final int IMG_HEIGHT = 50;  
        private static String maxAge = "3600";  
        private static Log      log = LogFactory.getLog( ImageServlet.class );  

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
                log.info(idFoto);  
                log.info(carpeta);  
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
				int type = img.getType() == 0? BufferedImage.TYPE_INT_ARGB : img.getType();
				BufferedImage resizeImageJpg = resizeImage(img, type);
		        response.setContentType("image/jpeg");  
                response.setHeader( "Cache-Control", "max-age=" + maxAge );  
                ImageIO.write( resizeImageJpg, "jpeg", response.getOutputStream() );  
                
            }  
            catch(Exception e)  
            {  
                log.error("Got exception resizing image", e);  
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage() );  
            }  
        }  
        private static BufferedImage resizeImage(BufferedImage originalImage, int type){
        	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        	Graphics2D g = resizedImage.createGraphics();
        	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        	g.dispose();
        	return resizedImage;
            }
    }  