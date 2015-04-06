package cl.puntocontrol.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cl.puntocontrol.hibernate.dao.DAOPunto_Control;
import cl.puntocontrol.hibernate.domain.Punto_Control;

public class CreateExcelServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			/*Para Posibles Filtros*/
			String nombre_control_detalle 	= request.getParameter("nombre_control_detalle")!=null?request.getParameter("s"):"";
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
			fechaDesde = df.parse(yd+"-"+md+"-"+dd);
			fechaHasta = df.parse(yh+"-"+mh+"-"+dh);
			
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell(0);
			
			row = sheet.createRow(3);
			cell = row.createCell(1);
			cell.setCellValue(nombre_control_detalle);   
        	cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(0);
			cell.setCellValue("Punto De Control:");   
        	cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));

			row = sheet.createRow(4);
			cell = row.createCell(1);
        	cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell.setCellValue(yd+"-"+md+"-"+dd);   
			cell = row.createCell(0);
			cell.setCellValue("Fecha Desde:");   
        	cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));

			row = sheet.createRow(5);
			cell = row.createCell(1);
        	cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell.setCellValue(yh+"-"+mh+"-"+dh);   
			cell = row.createCell(0);
			cell.setCellValue("Fecha Hasta");  
        	cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));

			row = sheet.createRow(11);
			cell = row.createCell(0);
			cell.setCellValue("Fecha");			cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(1);
			cell.setCellValue("Hora");			cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(2);
			cell.setCellValue("N° Folio");		cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(3);
			cell.setCellValue("Punto de Control");		cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(4);
			cell.setCellValue("Guia de Proveedor");		cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(5);
			cell.setCellValue("Patente");		cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(6);
			cell.setCellValue("Carro");			cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(7);
			cell.setCellValue("Chofer");		cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(8);
			cell.setCellValue("Proveedor");			cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(9);
			cell.setCellValue("Codigo Especie");			cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(10);
			cell.setCellValue("Codigo Producto");			cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(11);
			cell.setCellValue("Nombre Producto");			cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(12);
			cell.setCellValue("Codigo SAP");			cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(13);
			cell.setCellValue("Foto1");			cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));
			cell = row.createCell(14);
			cell.setCellValue("Foto2");			cell.setCellStyle(HelperExcelUtil.BoldAndBorderNoPlantilla(wb));

			String [][] excelData = prepareDataToWriteToExcel(nombre_control_detalle,patente,patente_carro,nombre_chofer,rut_transportista,nombre_producto,fechaDesde,fechaHasta);        
	
	        for (int rowNum = 12; rowNum <= excelData.length+11; rowNum++){    
				row = sheet.createRow(rowNum);
       		 	for (int cellNum = 0; cellNum < excelData[0].length ; cellNum++){
       		 		cell = row.createCell(cellNum);
	   			 	if(null==excelData[rowNum-12][cellNum]){
		   				cell.setCellValue(excelData[rowNum-12][cellNum]);}
	                else{
	                	cell.setCellValue(excelData[rowNum-12][cellNum]); 
	                	cell.setCellStyle(HelperExcelUtil.Border(wb));
	                } 
	            }
	        }
			sheet.autoSizeColumn(0,true); 			sheet.autoSizeColumn(1,true); 			sheet.autoSizeColumn(2,true); 			sheet.autoSizeColumn(3,true); 
			sheet.autoSizeColumn(4,true); 			sheet.autoSizeColumn(5,true); 			sheet.autoSizeColumn(6,true); 			sheet.autoSizeColumn(7,true); 
			sheet.autoSizeColumn(8,true); 			sheet.autoSizeColumn(9,true); 			sheet.autoSizeColumn(10,true); 			sheet.autoSizeColumn(11,true); 
			sheet.autoSizeColumn(12,true); 			sheet.autoSizeColumn(13,true); 
			sheet.autoSizeColumn(14,true); 

			ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
			wb.write(outByteStream);
			byte [] outArray = outByteStream.toByteArray();
			response.setContentType("application/ms-excel");
			response.setContentLength(outArray.length);
			response.setHeader("Expires:", "0"); // eliminates browser caching
			response.setHeader("Content-Disposition", "attachment; filename=ReporteControlesPorFecha.xls");
			OutputStream outStream = response.getOutputStream();
			outStream.write(outArray);
			outStream.flush();
		} catch (Exception ex) {
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
	
	protected String[][] prepareDataToWriteToExcel(String nombre_control_detalle,String patente,String patente_carro,String nombre_chofer,String rut_transportista,String nombre_producto,Date fechaDesde,Date fechaHasta) throws Exception{
    	try{
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
    		
    		String [][] excelData = new String [puntos_control.size()+20][20];

			for(int i=0;i<puntos_control.size();i++){
			Punto_Control pc = puntos_control.get(i);
			String fecha = pc.getFecha().toString()==null?" ":pc.getFecha().toString();;
			String ano= fecha.split("-")[0];
			String mes= fecha.split("-")[1];
			String dia= fecha.split("-")[2].split(" ")[0];
			fecha = dia+"-"+mes+"-"+ano;			String Hora=pc.getHora()==null?" ":pc.getHora().toString();;
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
			
			excelData[i][0]=String.valueOf(fecha);
            excelData[i][1]=String.valueOf(Hora);
            excelData[i][2]=String.valueOf(folio);
            excelData[i][3]=String.valueOf(Punto_Control);
            excelData[i][4]=String.valueOf(guia);
            excelData[i][5]=String.valueOf(Patente);
            excelData[i][6]=String.valueOf(Patente_Carro);
            excelData[i][7]=String.valueOf(Chofer);
            excelData[i][8]=String.valueOf(Proveedor);
            excelData[i][9]=String.valueOf(cod_especie);
            excelData[i][10]=String.valueOf(cod_producto);
            excelData[i][11]=String.valueOf(Producto);
            excelData[i][12]=String.valueOf(Codigo_Sap);
            excelData[i][13]=String.valueOf(Foto1);
            excelData[i][14]=String.valueOf(Foto2);
		}
    		return excelData;
    	}
    	catch (Exception e) {
			return null;
		}
    }
}
