package cl.puntocontrol.servlets;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.puntocontrol.hibernate.dao.DAOPunto_Control;
import cl.puntocontrol.hibernate.domain.Punto_Control;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
// Document Object
//For adding content into PDF document

public class CreatePDFServletTicket extends HttpServlet {

        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//invoked from doGet method to create PDF through servlet 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
	    	String id_control 	= request.getParameter("id_control")!=null?request.getParameter("id_control"):"";
	    	Punto_Control pc = DAOPunto_Control.get(id_control);
	    	
	    	response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=\"" +id_control+".pdf" + "\"");
	        OutputStream out=response.getOutputStream();
        try {
        
        	String fecha = pc.getFecha().toString()==null?" ":pc.getFecha().toString();;
			String ano= fecha.split("-")[0];
			String mes= fecha.split("-")[1];
			String dia= fecha.split("-")[2].split(" ")[0];
			fecha = dia+"-"+mes+"-"+ano;
			Font ff = FontFactory.getFont("arial", 7, Font.NORMAL, BaseColor.BLACK);
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph("BOSQUES ARAUCO",ff));       
            document.add(new Paragraph("PUNTO DE CONTROL : "+pc.getNombre_control_detalle(),ff));
            document.add(new Paragraph("BOLETO DE CONTROL NUMERO : "+pc.getId_control(),ff));
            document.add(new Paragraph("______________________________________________________",ff));
            document.add(new Paragraph(" ",ff));
            document.add(new Paragraph("Nombre chofer        :"+pc.getNombre_chofer(),	ff));
            document.add(new Paragraph("Fecha Control         :"+fecha,					ff));
            document.add(new Paragraph("Hora Control           :"+pc.getHora(),			ff));
            document.add(new Paragraph("Especie                   :"+pc.getNombre_especie(),	ff));
            document.add(new Paragraph("Producto                 :"+pc.getNombre_producto(),	ff));
            document.add(new Paragraph("Fotos Numero         :"+pc.getFoto1()+" y "+pc.getFoto2(),ff));
            document.add(new Paragraph("Guia de Proveedor :"+pc.getGuia_despacho(),	ff));
            document.add(new Paragraph("Proveedor               :"+pc.getNombre_transportista(),ff));
            document.add(new Paragraph("Rut Proveedor        :"+pc.getRut_transportista(),ff));
            document.add(new Paragraph("Patente                   :"+pc.getPatente(),			ff));
            document.add(new Paragraph("Patente Carro         :"+pc.getPatente_carro(),	ff));
            document.add(new Paragraph(" ",ff));
            document.add(new Paragraph("Firma__________________",ff));
            document.add(new Paragraph("_____________________________________________________",ff));
            String user = pc.getUsuario()!=null?pc.getUsuario():"";
            String modif = pc.getObs_modificacion()!=null?pc.getObs_modificacion():"";
            document.add(new Paragraph("Usuario Modificacion   :"+user,	ff));
            document.add(new Paragraph("Obs de la Modificacion : "+modif,ff));

            document.close();
        }
        catch (Exception exc){
        }
        finally {            
            out.close();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public String getServletInfo() {
        return "This Servlet Generates PDF Using iText Library";
    }
}