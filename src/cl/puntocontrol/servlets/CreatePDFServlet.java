package cl.puntocontrol.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.puntocontrol.hibernate.dao.DAOPunto_Control;
import cl.puntocontrol.hibernate.domain.Punto_Control;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
// Document Object
//For adding content into PDF document

public class CreatePDFServlet extends HttpServlet {

        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//invoked from doGet method to create PDF through servlet 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + "PDF.pdf" + "\"");
        OutputStream out=response.getOutputStream();
        try {
        	/*Para Posibles Filtros*/
        	String nombre_control_detalle 	= request.getParameter("nombre_control_detalle")!=null?request.getParameter("nombre_control_detalle"):"";
        	String patente 					= request.getParameter("patente")!=null?request.getParameter("patente"):"";
        	String patente_carro 			= request.getParameter("patente_carro")!=null?request.getParameter("patente_carro"):"";
        	String nombre_chofer 			= request.getParameter("nombre_chofer")!=null?request.getParameter("nombre_chofer"):"";
        	String rut_transportista 		= request.getParameter("rut_transportista")!=null?request.getParameter("rut_transportista"):"";
        	String nombre_producto 			= request.getParameter("nombre_producto")!=null?request.getParameter("nombre_producto"):"";
        	String dd 						= request.getParameter("dd")!=null?request.getParameter("dd"):"";
        	String md 						= request.getParameter("md")!=null?request.getParameter("md"):"";
        	String yd 						= request.getParameter("yd")!=null?request.getParameter("yd"):"";
        	String dh 						= request.getParameter("dh")!=null?request.getParameter("dh"):"";
        	String mh 						= request.getParameter("mh")!=null?request.getParameter("mh"):"";
        	String yh 						= request.getParameter("yh")!=null?request.getParameter("yh"):"";
        	
			if(nombre_control_detalle.equals("0"))nombre_control_detalle="";
			if(nombre_control_detalle.equals("1"))nombre_control_detalle="ESCUADRON";
			if(nombre_control_detalle.equals("2"))nombre_control_detalle="CONTULMO";
			if(nombre_control_detalle.equals("3"))nombre_control_detalle="SANTAJUANA";
			
        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaDesde = null;
			Date fechaHasta = null;
			try {
				fechaDesde = df.parse(yd+"-"+md+"-"+dd);
				fechaHasta = df.parse(yh+"-"+mh+"-"+dh);
			} catch (ParseException ex) {
			    ex.printStackTrace();
			}
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("INFORME CONTROL EN RANGO DE FECHAS"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("MOLINSTEC"));
            document.add(new Paragraph("Pesaje, Ingenieria y Desarrollo"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("ARIDOS ARITEC LIMITADA"));
            document.add(new Paragraph("EXTRACCION Y COMERCIALIZACION DE ARIDOS"));
            document.add(new Paragraph("Rut           : 96.697.650 - 0"));
            document.add(new Paragraph("Direccion  : CLAUIDIO MATTE s/n LOTE 4 FDO. SAN PEDRO"));
            document.add(new Paragraph("Telefono   : 8511118"));
            document.add(new Paragraph("Comuna   : PUENTE ALTO"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Fecha Desde :"+dd+"-"+md+"-"+yd));
            document.add(new Paragraph("Fecha Hasta  :"+dh+"-"+mh+"-"+yh));
            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(15);
            table.setWidthPercentage(100);
            int[] itemsCols = {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6};
            table.setWidths(itemsCols);
			table.addCell(new Phrase("Fecha", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Hora", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("N° Folio", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Punto Control", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Guia Proveedor", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Patente", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Carro", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Chofer", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Proveedor", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Cod Especie", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Cod Producto", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Nombre Producto", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Codigo Sap", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Foto1", FontFactory.getFont(FontFactory.HELVETICA, 7)));
			table.addCell(new Phrase("Foto2", FontFactory.getFont(FontFactory.HELVETICA, 7)));
            
            List<Punto_Control> puntos_control = DAOPunto_Control.list(	  nombre_chofer!=null&&nombre_chofer.length()>0?nombre_chofer:""
																		, patente!=null&&patente.length()>0?patente:""
																		, fechaDesde
																		, fechaHasta
																		, ""
																		, rut_transportista!=null&&rut_transportista.length()>0?rut_transportista:""
																		, ""
																		, nombre_control_detalle!=null&&nombre_control_detalle.length()>0?nombre_control_detalle:""
																		, nombre_producto!=null&&nombre_producto.length()>0?nombre_producto:""
																		, patente_carro!=null&&patente_carro.length()>0?patente_carro:""
																		, ""
																		, ""
																		, "");
			for(int i=0;i<puntos_control.size();i++){
				Punto_Control pc = puntos_control.get(i);
				String fecha = pc.getFecha().toString()==null?" ":pc.getFecha().toString();;
				String ano= fecha.split("-")[0];
				String mes= fecha.split("-")[1];
				String dia= fecha.split("-")[2].split(" ")[0];
				fecha = dia+"-"+mes+"-"+ano;				String Hora=pc.getHora()==null?" ":pc.getHora().toString();;
				String folio=pc.getId_control()==null?" ":pc.getId_control().toString();;
				String Punto_Control=pc.getNombre_control_detalle()==null?" ":pc.getNombre_control_detalle().toString();;
				String guia=pc.getGuia_despacho()==null?" ":pc.getGuia_despacho().toString();;
				String Patente=pc.getPatente()==null?" ":pc.getPatente().toString();;
				String Patente_Carro=pc.getPatente_carro()==null?" ":pc.getPatente_carro().toString();;
				String Chofer=pc.getNombre_chofer()==null?" ":pc.getNombre_chofer().toString();;
				String Proveedor=pc.getNombre_transportista()==null?" ":pc.getNombre_transportista().toString();
				String cod_especie=pc.getId_especie().toString()==null?" ":pc.getId_especie().toString();
				String cod_producto=pc.getCodigo_producto().toString()==null?" ":pc.getCodigo_producto().toString();
				String Producto=pc.getNombre_producto()==null?" ":pc.getNombre_producto().toString();
				String Codigo_Sap=pc.getCodigo_sap()==null?" ":pc.getCodigo_sap().toString();
				String Foto1=pc.getFoto1().toString()==null?" ":pc.getFoto1().toString();
				String Foto2=pc.getFoto2().toString()==null?" ":pc.getFoto2().toString();
				
				table.addCell(new Phrase(fecha, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(Hora, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(folio, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(Punto_Control, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(guia, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(Patente, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(Patente_Carro, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(Chofer, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(Proveedor, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(cod_especie, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(cod_producto, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(Producto, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(Codigo_Sap, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(Foto1, FontFactory.getFont(FontFactory.HELVETICA, 7)));
	            table.addCell(new Phrase(Foto2, FontFactory.getFont(FontFactory.HELVETICA, 7)));
			}
			
			document.add(table);	
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
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "This Servlet Generates PDF Using iText Library";
    }
}