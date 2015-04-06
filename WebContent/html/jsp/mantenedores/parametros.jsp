<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="../common/validateSession.jsp" %>

<bean:define id="usuario" 			property="usuario" 			name="parametrosForm" type="cl.puntocontrol.hibernate.domain.Usuario"></bean:define>
<bean:define id="successMessage" 	property="successMessage" 	name="parametrosForm" type="java.lang.String"></bean:define>
<bean:define id="errorMessage" 		property="errorMessage" 	name="parametrosForm" type="java.lang.String"></bean:define>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Punto Control 1.0 - Mantenedor Parametros</title>
	<link rel="stylesheet" href="/punto_control/html/css/screen.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/demo_page.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/jquery-ui-1.8.4.custom.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" type="text/css" href="/punto_control/html/css/pro_dropdown_3.css" />

	<script type="text/javascript"  src="/punto_control/html/js/pro_dropdown_3/stuHover.js"></script>
	<script type="text/javascript"  src="/punto_control/html/js/jquery/jquery.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			$('#rut').attr("maxlength", 15);
			$('#ciudad').attr("maxlength", 50);
			$('#fono').attr("maxlength", 20);
			$('#giro').attr("maxlength", 50);
			$('#direccion').attr("maxlength", 50);
			$('#razon_social').attr("maxlength", 50);
		});
		
		function confirmEdit() { 
			if($('#rut').val()=="" || $('#fono').val()==""|| $('#ciudad').val()==""|| $('#giro').val()==""|| $('#direccion').val()==""|| $('#razon_social').val()==""){
				alert("Ingrese datos faltantes");
			}
			else{
			    if(confirm("¿Esta Seguro De Realizar La Modificacion?")) { 
			    	$('#formFiltros').attr('action', '/punto_control/parametros/guardar.do?rut='+$('#rut').val()); 
					$('#formFiltros').submit();
			      }
			    else{
			    	return false;
			    }
			}
		}
	</script>
</head>
<body> 
	<!-- BARRA SUPERIOR -->
	<%@ include file="../common/menu_superior.jsp" %>
	<!-- CONTENIDO -->
	<div id="content">
		<div id="page-heading"><h1>Datos de la empresa</h1></div>

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
							<%@ include file="../common/messages.jsp" %>
							<html:form action="/parametros/guardar" method="post" styleId="formFiltros">
							<table border="0" width="100%" cellpadding="0" cellspacing="0">
							<tr valign="top">
								<td style="width: 280px">
									<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
									<tr>
										<th valign="top">Razon Social:</th>
										<td>
											<html:textarea property="razon_social" name="parametrosForm" styleId="razon_social"></html:textarea> 
										</td>
										<th valign="top">&nbsp;Rut:</th>
										<td>
											<html:text property="rut" name="parametrosForm" styleId="rut"></html:text> 
										</td>
									</tr>
									<tr>
										<th valign="top">Giro:</th>
										<td>
											<html:textarea property="giro" name="parametrosForm" styleId="giro"></html:textarea> 
										</td>
										<th valign="top">&nbsp;Fono:</th>
										<td>
											<html:text property="fono" name="parametrosForm" styleId="fono"></html:text> 
										</td>
									</tr>
									<tr>
										<th valign="top">Direccion:</th>
										<td>
											<html:textarea property="direccion" name="parametrosForm" styleId="direccion" ></html:textarea> 
										</td>
										<th valign="top">&nbsp;Ciudad:</th>
										<td>
											<html:text property="ciudad" name="parametrosForm" styleId="ciudad"></html:text> 
										</td>
									</tr>
									
									<tr>
										<td>
											<html:button property="Guardar" 	onclick="confirmEdit()">Guardar</html:button>
										</td>
									</tr>
									</table>
								</td>
							</tr>
							</table>
							</html:form>
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
