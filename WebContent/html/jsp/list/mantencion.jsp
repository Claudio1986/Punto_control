<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  
<bean:define id="jsonControles" 	property="jsonControles" 	name="puntoControlForm" type="java.lang.String"></bean:define>
<bean:define id="usuario" 			property="usuario" 			name="puntoControlForm" type="cl.puntocontrol.hibernate.domain.Usuario"></bean:define>
<bean:define id="successMessage" 	property="successMessage" 	name="puntoControlForm" 	type="java.lang.String"></bean:define>
<bean:define id="errorMessage" 		property="errorMessage" 	name="puntoControlForm" 	type="java.lang.String"></bean:define>

<%@ include file="../common/validateSession.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Punto Control 1.0 - Mantencion BD</title>
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
		$('#example').dataTable( {
			"bJQueryUI": true,
			"sPaginationType": "full_numbers",
			"aaData":<%=jsonControles%>,
			"iDisplayLength": 50,
			"bFilter": false,
			"bScrollInfinite": false,
		    "bScrollCollapse": true,
		    "sScrollY": "400px",
		    "iScrollLoadGap": 50
		} );
	} );

	function submitFormBuscar(){
		$('#formFiltros').submit();
	}
	function eliminarSubmitForm(folio){
		if(confirm("¿Esta Seguro De Eliminar Este Registro?")) { 
			$('#formFiltros').attr('action', '/punto_control/puntocontrol/mantencion/eliminar.do?id_control='+folio); 
			$('#formFiltros').submit();
	      }
	    else{
	    	return false;
	    }
    	
	}
	</script>
</head>
<body> 
	<!-- BARRA SUPERIOR -->
	<%@ include file="../common/menu_superior.jsp" %>
	<!-- CONTENIDO -->
	<div id="content">
		<div id="page-heading"><h1>Mantencion BD</h1></div>

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
							<html:form action="/puntocontrol/mantencion/buscar" method="post" styleId="formFiltros">
								<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
									<tr>		
										<th valign="top">&nbsp;Folio:</th>
										<td>
											<html:text property="id_control" name="puntoControlForm" styleId="id_control">
											</html:text>
										</td>	
									</tr>
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
									</tr>
									<tr>
										<td>&nbsp;&nbsp;
											<html:button property="Buscar Controles" onclick="submitFormBuscar()">Buscar</html:button>
										</td>
									</tr>
								</table>
							</html:form>
							<br/>
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
								<thead>
									<tr>
										<th>Fecha</th>
										<th>Hora</th>
										<th>N° Folio</th>
										<th>Punto de Control</th>
										<th>Guia de Proveedor</th>
										<th>Patente</th>
										<th>Carro</th>
										<th>Chofer</th>
										<th>Proveedor</th>
										<th>Codigo Especie</th>
										<th>Codigo Producto</th>
										<th>Nombre Producto</th>
										<th>Codigo SAP</th>
										<th>Accion</th>
									</tr>
								</thead>
								<tbody>
								
								</tbody>
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
