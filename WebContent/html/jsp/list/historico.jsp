<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  
<bean:define id="jsonControles" 	property="jsonControles" 	name="puntoControlForm" type="java.lang.String"></bean:define>
<bean:define id="ddHoy" 			property="ddHoy" 			name="puntoControlForm" type="java.lang.String"></bean:define>
<bean:define id="mmHoy" 			property="mmHoy" 			name="puntoControlForm" type="java.lang.String"></bean:define>
<bean:define id="yyHoy" 			property="yyHoy" 			name="puntoControlForm" type="java.lang.String"></bean:define>
<bean:define id="usuario" 			property="usuario" 			name="puntoControlForm" type="cl.puntocontrol.hibernate.domain.Usuario"></bean:define>
<bean:define id="successMessage" 	property="successMessage" 	name="puntoControlForm" 	type="java.lang.String"></bean:define>
<bean:define id="errorMessage" 		property="errorMessage" 	name="puntoControlForm" 	type="java.lang.String"></bean:define>

<%@ include file="../common/validateSession.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Punto Control 1.0 - Reporte Controles Realizados Por Fecha</title>
	<link rel="stylesheet" href="/punto_control/html/css/screen.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/demo_table_jui.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/ColReorder.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/jquery-ui-1.8.4.custom.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" type="text/css" href="/punto_control/html/css/pro_dropdown_3.css" />

	<script type="text/javascript"  src="/punto_control/html/js/pro_dropdown_3/stuHover.js"></script>
	<script type="text/javascript"  src="/punto_control/html/js/jquery/jquery.js"></script>
	<script type="text/javascript"  src="/punto_control/html/js/jquery/jquery.dataTables.js"></script>
	<script type="text/javascript"  src="/punto_control/html/js/jquery/ColReorder.js"></script>
	<script type="text/javascript"  src="/punto_control/html/js/jquery/ZeroClipboard.js"></script>
	
	<script type="text/javascript" charset="utf-8">
	$(document).ready( function () {
		var oTable = $('#example').dataTable( {
			"bJQueryUI": true,
			"aaData":<%=jsonControles%>,
			"iDisplayLength": 3000,
			"bFilter": false,
		    "sScrollY": "400px",
		    "iScrollLoadGap": 50,
		    "aoColumns":[
		                 {sTitle: "Fecha"},
		                 {sTitle: "Hora"},
		                 {sTitle: "Folio"},
		                 {sTitle: "Punto Control"},
		                 {sTitle: "Guia Prov"},
		                 {sTitle: "Patente"},
		                 {sTitle: "Carro"},
		                 {sTitle: "Chofer"},
		                 {sTitle: "Proveedor"},
		                 {sTitle: "Cod Esp"},
		                 {sTitle: "Cod Prod"},
		                 {sTitle: "Nombre Producto"},
		                 {sTitle: "Rut Prov"},
		                 {sTitle: "Foto1"},
		                 {sTitle: "Foto2 "}
		                 ]
		} );
	} );
	
	 
	 
	function submitFormBuscar(){
		$('#formFiltros').submit();
	}
	
	function submitFormExcelPdf(reporte){
		if(reporte=='xls'){ 
			var url="/punto_control/excelServlet?";}
		else{ 
			var url="/punto_control/pdfServlet?";}
		var url=url+"nombre_control_detalle="+$("#nombre_control_detalle").val();
		var url=url+"&dd="+$("#dd").val();
		var url=url+"&md="+$("#md").val();
		var url=url+"&yd="+$("#yd").val();
		var url=url+"&dh="+$("#dh").val();
		var url=url+"&mh="+$("#mh").val();
		var url=url+"&yh="+$("#yh").val();
		document.location = url;
			
	}

	function clearForm(){
		$("#nombre_control_detalle").val("0");
		$("#dd").val("<%=ddHoy%>");
		$("#md").val("<%=mmHoy%>");
		$("#yd").val("<%=yyHoy%>");
		$("#dh").val("<%=ddHoy%>");
		$("#mh").val("<%=mmHoy%>");
		$("#yh").val("<%=yyHoy%>");
	}

	function showImagen(identificador){
		var elem = identificador.split('-');
		var idFoto = elem[0];
		var carpeta = elem[1];
		openFullscreen("/punto_control/html/jsp/list/imagenes.jsp?idFoto="+idFoto+"&carpeta="+carpeta);
	}
	function openFullscreen(url)
	{

	 var height = screen.availHeight;
	 var width = screen.availWidth;

	 var fullscreen = (document.all) ? "no" : "yes";
	 var resizable = "no";
	 var toolbar = "no";
	 var status = "no";
	 var left = 0;
	 var top = 0;

	 //set window properties
	 props = "toolbar=no" +
	 ",fullscreen=" + fullscreen +
	 ",status=no" +
	 ",resizable=no" +
	 ",scrollbars=no" +
	 ",menubar=no" +
	 ",location=no" + ",";

	 dims = "width="+ width +
	 ",height="+ height +
	 ",left="+ left +
	 ",top=" + top;

	 var win = window.open("", name, props + dims);
	 win.resizeTo(width, height);
	 win.location.href = url;
	 win.focus();
	}
	</script>
</head>
<body> 

	<!-- BARRA SUPERIOR -->
	<%@ include file="../common/menu_superior.jsp" %>
	<!-- CONTENIDO -->
	<div id="content">
		<div id="page-heading"><h1>Reporte Controles Realizados Por Fecha</h1></div>
		<table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
			<tr>
				<th rowspan="3" class="sized"><img src="/punto_control/html/images/shared/side_shadowleft.jpg" width="20" height="300" alt="" /></th>
				<th class="topleft"></th>
				<td id="tbl-border-top">&nbsp;</td>
				<th class="topright"></th>
				<th rowspan="3" class="sized"><img src="/punto_control/html/images/shared/side_shadowright.jpg" width="20" height="300" alt="" /></th>
			</tr>
			<tr>
				<td id="tbl-border-left"></td>
				<td>
					<div id="content-table-inner">
						<!-- CONTENIDO TABLA -->
						<%@ include file="../common/messages.jsp" %>
						<div id="dynamic">
							<html:form action="puntocontrol/buscar" method="post" styleId="formFiltros">
								<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
									<tr>
										<th valign="top">&nbsp;Punto Control:</th>
										<td>
											<html:select property="nombre_control_detalle" name="puntoControlForm" styleId="nombre_control_detalle">
												<html:option value="0">Todos</html:option>
												<html:option value="1">ESCUADRON</html:option>
												<html:option value="2">CONTULMO</html:option>
												<html:option value="3">SANTAJUANA</html:option>
											</html:select>
										</td>
										<th valign="top">&nbsp;&nbsp;Fecha Desde:</th>
										<td>
											<html:select property="dd" name="puntoControlForm" styleId="dd">
												<%for(int i=1;i<=31;i++){ %>
													<html:option value="<%=String.valueOf(i)%>"><%=String.valueOf(i)%></html:option>
												<%} %>
											</html:select>
											<html:select property="md" name="puntoControlForm" styleId="md">
												<html:option value="1">Ene</html:option>
												<html:option value="2">Feb</html:option>
												<html:option value="3">Mar</html:option>
												<html:option value="4">Abr</html:option>
												<html:option value="5">May</html:option>
												<html:option value="6">Jun</html:option>
												<html:option value="7">Jul</html:option>
												<html:option value="8">Ago</html:option>
												<html:option value="9">Sep</html:option>
												<html:option value="10">Oct</html:option>
												<html:option value="11">Nov</html:option>
												<html:option value="12">Dic</html:option>
											</html:select>
											<html:select  property="yd" name="puntoControlForm" styleId="yd">
												<%for(int i=2005;i<=2015;i++){ %>
													<html:option value="<%=String.valueOf(i)%>"><%=String.valueOf(i)%></html:option>
												<%} %>
											</html:select>
										</td>
										<td>&nbsp;&nbsp;
											<html:button property="Buscar Controles" onclick="submitFormBuscar()">Buscar Controles</html:button>
										</td>
										<td>&nbsp;&nbsp;
											<html:button property="ExportarExcel" onclick="submitFormExcelPdf('xls')">Exportar Excel</html:button>
										</td>
									</tr>
									<tr>
										<th valign="top"></th>
										<td>
										</td>
										<th valign="top">&nbsp;&nbsp;Fecha Hasta:</th>
										<td>
											<html:select property="dh" name="puntoControlForm" styleId="dh">
												<%for(int i=1;i<=31;i++){ %>
													<html:option value="<%=String.valueOf(i)%>"><%=String.valueOf(i)%></html:option>
												<%} %>
											</html:select>
											<html:select property="mh" name="puntoControlForm" styleId="mh">
												<html:option value="1">Ene</html:option>
												<html:option value="2">Feb</html:option>
												<html:option value="3">Mar</html:option>
												<html:option value="4">Abr</html:option>
												<html:option value="5">May</html:option>
												<html:option value="6">Jun</html:option>
												<html:option value="7">Jul</html:option>
												<html:option value="8">Ago</html:option>
												<html:option value="9">Sep</html:option>
												<html:option value="10">Oct</html:option>
												<html:option value="11">Nov</html:option>
												<html:option value="12">Dic</html:option>
											</html:select>
											<html:select property="yh" name="puntoControlForm" styleId="yh">
												<%for(int i=2005;i<=2015;i++){ %>
													<html:option value="<%=String.valueOf(i)%>"><%=String.valueOf(i) %></html:option>
												<%} %>
											</html:select>
										</td>
										<td>&nbsp;&nbsp;
											<html:button property="Limpiar Campos" onclick="clearForm()">Limpiar Campos</html:button>
										</td>
										<td>&nbsp;&nbsp;
											<html:button property="ExportarPDF" onclick="submitFormExcelPdf('pdf')">Exportar PDF</html:button><br/>
										</td>
									</tr>
								</table>
							</html:form>
							<br/>
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
							</table>
						</div>
					</div>
				</td>
				<td id="tbl-border-right"></td>
			</tr>
			<tr>
				<th class="sized bottomleft"></th>
				<td id="tbl-border-bottom">&nbsp;</td>
				<th class="sized bottomright"></th>
			</tr>
		</table>
	</div>
	<!-- PIE DE PAGINA -->
	<div id="footer">
		<div id="footer-left">
				www.molinstec.cl. Todos los derechos reservados. 
				</br>
				Antofagasta// Santiago // Concepción // Puerto Montt // 600 364 7000 |  email: consultas@molinstec.cl 
		</div>
		<div class="clear">&nbsp;</div>
	</div>
</body>
</html>
