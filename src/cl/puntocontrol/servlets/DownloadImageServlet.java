package cl.puntocontrol.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadImageServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			response.setContentType("image/jpeg");
			PrintWriter out = response.getWriter();

			String idFoto = request.getParameter( "idFoto" );  
	        String carpeta = request.getParameter( "carpeta" ); 
			String filepath = "C:\\Servidor\\fotos\\"+carpeta+"\\";
			String filename = idFoto+".jpg";
			
			response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\""); 
			java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath + filename);
			int i; 
			while ((i=fileInputStream.read()) != -1) {
			    out.write(i); 
			} 
			fileInputStream.close(); 
			out.close(); 
		}
		catch(Exception e){
		}
	}
}