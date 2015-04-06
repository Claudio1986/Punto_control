<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  
<bean:define id="especies" 			property="especies" 		name="especiesForm" type="java.util.List"></bean:define>
<bean:define id="usuario" 			property="usuario" 			name="especiesForm" type="cl.puntocontrol.hibernate.domain.Usuario"></bean:define>
<bean:define id="successMessage" 	property="successMessage" 	name="especiesForm" type="java.lang.String"></bean:define>
<bean:define id="errorMessage" 		property="errorMessage" 	name="especiesForm" type="java.lang.String"></bean:define>

<%@ include file="../common/validateSession.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Punto Control 1.0 - Mantenedor Especies</title>
	<link rel="stylesheet" href="/punto_control/html/css/screen.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/demo_page.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/jquery-ui-1.8.4.custom.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" type="text/css" href="/punto_control/html/css/pro_dropdown_3.css" />

	<script type="text/javascript"  src="/punto_control/html/js/pro_dropdown_3/stuHover.js"></script>
	<script type="text/javascript"  src="/punto_control/html/js/jquery/jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#nuevo').val("true");
			$('#nombre_especie').attr("maxlength", 50);
			$('#id_especie_temporal').attr("maxlength", 10);
			$('#id_especie_temporal').bind('keypress', function (e) {
		        return !(e.which != 8 && e.which != 0 &&
		                (e.which < 48 || e.which > 57) && e.which != 46);
		    });
		    $('#id_especie_temporal').attr('disabled','disabled');
		});
		
		function confirmDelete() { 
		    if(confirm("¿Esta Seguro De Eliminar Esta Especie?")) { 
				$('#formFiltros').submit();
		      }
		    else{
		    	return false;
		    }
	
		}
		function confirmEdit() { 
			if($('#nombre_especie').val()==""){
				alert("Ingrese datos faltantes");
			}
			else{
			    if(confirm("¿Esta Seguro De Agregar/Modificar Esta Especie?")) { 
			    	$('#formFiltros').attr('action', '/punto_control/especies/guardar.do?id_especie_temporal='+$('#id_especie_temporal').val()+'&nuevo='+$('#nuevo').val()); 
					$('#formFiltros').submit();
			      }
			    else{
			    	return false;
			    }
			}
		}
		function changeEspecie(){
			$('#nuevo').val("false");
		  	$('#id_especie_temporal').val($("#id_especie").val());
		  	$('#nombre_especie').val($("#id_especie option:selected").text());
		    $('#id_especie_temporal').attr('disabled','disabled');
		}
		function clearFormulario(){
			$('#nuevo').val("true");
			$('#id_especie').val("0");
			$('#id_especie_temporal').val("");
			$('#nombre_especie').val("");
		    $('#id_especie_temporal').removeAttr('disabled');
			$('#id_especie_temporal').focus();
		}
		
		function checkId(){
			var lista = document.getElementById("id_especie");
			var i=0;
		    for (i = 0; i < lista.options.length; i++) {
		           if($('#id_especie_temporal').val()==lista.options[i].value){
		        		   alert("Id asignado a otra especie ");
			        	   $('#id_especie_temporal').val("");
			        	   $('#id_especie_temporal').focus();
		           }
		    }
		}
		function checkNombre(){
			var lista = document.getElementById("id_especie");
			var i=0;
		    for (i = 0; i < lista.options.length; i++) {
		    	if($('#nuevo').val()=="true"){
		           if($('#nombre_especie').val().toUpperCase()==lista.options[i].text.toUpperCase()){
	        		   alert("Nombre existente");
	        		   		$('#nombre_especie').val("");
		        	   }
		           }
		    	else{
		    		if(lista.options[i].value!=$('#id_especie').val()){
		    			 if($('#nombre_especie').val().toUpperCase()==lista.options[i].text.toUpperCase()){
			        		   alert("Nombre existente");
			        		   		$('#nombre_especie').val("");
				        	   }
		    		}
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
		<div id="page-heading"><h1>Mantenedor Especies</h1></div>

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
						<html:form action="/especies/eliminar" method="post" styleId="formFiltros">
							<input type="hidden" id="nuevo" ></input>
							<table border="0" width="100%" cellpadding="0" cellspacing="0">
							<tr valign="top">
								<td style="width: 300px">
									<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
									<tr><td><br></br><br></br></td></tr>
									<tr>
										<th valign="top">Codigo:</th>
										<td>
											<input type="text" id="id_especie_temporal" onblur="checkId()" >
											</input>
										</td>
									</tr>
									<tr>
										<th valign="top">Nombre:</th>
										<td>
											<html:textarea property="nombre_especie" name="especiesForm" styleId="nombre_especie" onblur="checkNombre()">
											</html:textarea>
										</td>
									</tr>
									<tr>
										<td>
											<html:button property="Nuevo" 		onclick="clearFormulario()">Nuevo</html:button>
										</td>
										<td>
											<html:button property="Guardar" 	onclick="confirmEdit()">Guardar</html:button>
										</td>
									</tr>
								</table>
								</td>
								<td>
								<div id="related-activities">
									<div id="related-act-bottom">
										<div id="related-activities">
										<div id="related-act-top">
											<img src="/punto_control/html/images/forms/header_related_act.png" width="271" height="43" alt="" />
										</div>
										<div id="related-act-bottom">
											<div id="related-act-inner">
												<html:select property="id_especie" name="especiesForm" styleId="id_especie" style="width:230px" size="11" onchange="changeEspecie()">
													<html:optionsCollection property="especies" name="especiesForm" label="nombre_especie" value="id_especie" />
												</html:select>
												<html:button property="Eliminar" 	onclick="confirmDelete()">Eliminar</html:button>
												<div class="clear"></div>
											</div>
											<div class="clear"></div>
										</div>
										</div>
										<div class="clear"></div>
									</div>
								</div>
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
