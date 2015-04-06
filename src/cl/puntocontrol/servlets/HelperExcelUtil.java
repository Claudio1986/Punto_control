package cl.puntocontrol.servlets;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class HelperExcelUtil {

	//negrita en las celdas
	public static CellStyle Bold(Workbook w) throws Exception
	{
		 Font fn = w.createFont();
	     fn.setBoldweight(Font.BOLDWEIGHT_BOLD);
	     CellStyle cellStyle = w.createCellStyle();	    
	     cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
	     cellStyle.setFont(fn);
	     return cellStyle;
	}
	//Negrita alieanada a la izquierda
	public static CellStyle BoldAlignLeft(Workbook w) throws Exception
	{
		 Font fn = w.createFont();
	     fn.setBoldweight(Font.BOLDWEIGHT_BOLD);
	     CellStyle cellStyle = w.createCellStyle();	   	  
	     cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
	     cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setFont(fn);
	     return cellStyle;
	}
	

	// ajusta el ancho de las columnas en funci�n de su contenido
    public static void ajustaColumnas(Sheet hoja, int maxColumn) {
        final int numeroColumnas = maxColumn;
        for (int i = 0; i < numeroColumnas; i++) {
        	hoja.autoSizeColumn(i);
        }
    }
    
    public static CellStyle Border(Workbook w) throws Exception
	{
		 Font fn = w.createFont();
	     CellStyle cellStyle = w.createCellStyle();
	     cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	     cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setFont(fn);
	     return cellStyle;
	}
    
    public static CellStyle BorderALignLeft(Workbook w) throws Exception
	{
		 Font fn = w.createFont();
	     CellStyle cellStyle = w.createCellStyle();
	     cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
	     cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setFont(fn);
	     return cellStyle;
	}
    public static CellStyle BorderColaboradores(Workbook w) throws Exception
	{
    	 /*Con los font en el excel de colaboradores se cae por el error -maximum-number-of-fonts-exceeded*/
	     CellStyle cellStyle = w.createCellStyle();
	     cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	     cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	     return cellStyle;
	}
    
    public static CellStyle BoldAndBorder(Workbook w) throws Exception
	{
		 Font fn = w.createFont();
	     fn.setBoldweight(Font.BOLDWEIGHT_BOLD);
	     CellStyle cellStyle = w.createCellStyle();	   	  
	     cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	     cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setFont(fn);
	     return cellStyle;
	}
    public static CellStyle BoldAndBorderNoPlantilla(Workbook w) throws Exception
	{
		 Font fn = w.createFont();
	     fn.setBoldweight(Font.BOLDWEIGHT_BOLD);
	     CellStyle cellStyle = w.createCellStyle();	
	     cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	     cellStyle.setFillForegroundColor(new HSSFColor.GREY_25_PERCENT().getIndex()); 	    
	     cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	     cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	     cellStyle.setFont(fn);
	     return cellStyle;
	}
	//agregar mas propiedades a medida que se vayan utilizando
}
