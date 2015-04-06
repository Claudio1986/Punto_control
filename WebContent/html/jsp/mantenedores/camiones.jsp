<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="../common/validateSession.jsp" %>

<bean:define id="camiones" 			property="camiones" 		name="camionesForm" type="java.util.List"></bean:define>
<bean:define id="usuario" 			property="usuario" 			name="camionesForm" type="cl.puntocontrol.hibernate.domain.Usuario"></bean:define>
<bean:define id="successMessage" 	property="successMessage" 	name="camionesForm" type="java.lang.String"></bean:define>
<bean:define id="errorMessage" 		property="errorMessage" 	name="camionesForm" type="java.lang.String"></bean:define>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Punto Control 1.0 - Mantenedor Camiones</title>
	<link rel="stylesheet" href="/punto_control/html/css/screen.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/demo_page.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/jquery-ui-1.8.4.custom.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" type="text/css" href="/punto_control/html/css/pro_dropdown_3.css" />

	<script type="text/javascript"  src="/punto_control/html/js/pro_dropdown_3/stuHover.js"></script>
	<script type="text/javascript"  src="/punto_control/html/js/jquery/jquery.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			enlazarCombos($("#cam_patente"),$("#estado"),"/punto_control/jsonCamionesEstado");
			$('#cam_observacion').attr("maxlength", 50);
			$('#cam_patente_temporal').attr("maxlength", 8);
		    $('#cam_patente_temporal').attr('disabled','disabled');
			$('#nuevo').val("true");
		});
		
		function enlazarCombos(comboSource,comboDest,urlLoad){
			comboSource.bind("change",{},function(){
				var parentId=$(this).val();
				var data={parentId:parentId};
				$.getJSON(urlLoad,data,
			            function(response, textStatus, jqXHR) {
			        		var childs = [];
				        	for(indice=0;indice<response.length;indice++){
				        		var child=response[indice];
				        		$('#cam_patente_temporal').val(child.cam_patente);
				        		$('#cam_patente').val(child.cam_patente);
				    			$('#cam_observacion').val(child.cam_observacion);
				    			$('#estado').val(child.estado);
				    		    $('#cam_patente_temporal').attr('disabled','disabled');
				    			$('#nuevo').val("false");
							}	        		
			            }
			        );
			});
		}
		function confirmDelete() { 
		    if(confirm("¿Esta Seguro De Eliminar Este Camion?")) { 
				$('#formFiltros').submit();
		      }
		    else{
		    	return false;
		    }
	
		}
		function confirmEdit() { 
			if($('#cam_observacion').val()=="" || $('#cam_patente_temporal').val()==""){
				alert("Ingrese datos faltantes");
			}
			else{
			    if(confirm("¿Esta Seguro De Agregar/Modificar Este Camion?")) { 
			    	$('#formFiltros').attr('action', '/punto_control/camion/guardar.do?cam_patente='+$('#cam_patente_temporal').val()+'&nuevo='+$('#nuevo').val());
					$('#formFiltros').submit();
			      }
			    else{
			    	return false;
			    }
			}
		}
		function clearFormulario(){
			$('#cam_observacion').val("");
			$('#cam_patente_temporal').val("");
			$('#estado').val("0");
		    $('#cam_patente_temporal').removeAttr('disabled');
			$('#nuevo').val("true");
			$('#cam_patente_temporal').focus();
		}
		function checkPatente(){
			var lista = document.getElementById("cam_patente");
			var i=0;
		    for (i = 0; i < lista.options.length; i++) {
		           if($('#cam_patente_temporal').val().toUpperCase()==lista.options[i].value){
		        		   alert("Patente existente");
			        	   $('#cam_patente_temporal').val("");
			        	   $('#cam_patente_temporal').focus();
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
		<div id="page-heading"><h1>Mantenedor Camiones</h1></div>

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
							<html:form action="/camion/eliminar" method="post" styleId="formFiltros">
							<input type="hidden" id="nuevo" ></input>
							<table border="0" width="100%" cellpadding="0" cellspacing="0">
							<tr valign="top">
								<td style="width: 300px">
									<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
									<tr><td><br></br><br></br></td></tr>
									<tr>
										<th valign="top">Patente:</th>
										<td>
											<input type="text" id="cam_patente_temporal" onblur="checkPatente()"></input><br/><br/>
										</td>
									</tr>
									<tr>
										<th valign="top">Estado:</th>
										<td>
											<html:select property="estado" name="camionesForm" styleId="estado">
												<html:option value="0">Bloqueado</html:option>
												<html:option value="1">No Bloqueado</html:option>
											</html:select>
										</td>
									</tr>
									<tr>
										<th valign="top">Observaciones:</th>
										<td>
											<html:textarea property="cam_observacion" name="camionesForm" styleId="cam_observacion" >
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
												<html:select property="cam_patente" name="camionesForm" styleId="cam_patente" style="width:230px" size="11">
													<html:optionsCollection property="camiones" name="camionesForm" label="cam_patente" value="cam_patente" />
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
