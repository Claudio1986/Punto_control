<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<bean:define id="transportistas" 	property="transportistas" 	name="transportistasForm" 	type="java.util.List"></bean:define>
<bean:define id="usuario" 			property="usuario" 			name="transportistasForm" 	type="cl.puntocontrol.hibernate.domain.Usuario"></bean:define>
<bean:define id="successMessage" 	property="successMessage" 	name="transportistasForm" 		type="java.lang.String"></bean:define>
<bean:define id="errorMessage" 		property="errorMessage" 	name="transportistasForm" 		type="java.lang.String"></bean:define>

<%@ include file="../common/validateSession.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Punto Control 1.0 - Mantenedor Proveedores</title>
	<link rel="stylesheet" href="/punto_control/html/css/screen.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/demo_page.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/jquery-ui-1.8.4.custom.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" type="text/css" href="/punto_control/html/css/pro_dropdown_3.css" />

	<script type="text/javascript"  src="/punto_control/html/js/pro_dropdown_3/stuHover.js"></script>
	<script type="text/javascript" language="javascript" src="/punto_control/html/js/jquery/jquery.js"></script>
	<script type="text/javascript" language="javascript" src="/punto_control/html/js/jquery/jquery.Rut.js"></script>
	<script type="text/javascript">
		var rut_child="";
		
		$(document).ready(function(){
			enlazarCombos($("#rut_transportista"),$("#estado"),"/punto_control/jsonTransportistaEstado");
			$('#rut_transportista_temporal').attr("maxlength", 20);
			$('#nombre_transportista').attr("maxlength", 50);
			$('#sap_transportista').attr("maxlength", 10);
		    $('#prd_codigo_temporal').attr("maxlength", 10);
			
			$('#rut_transportista_temporal').Rut({
				  on_error: function(){ alert('Rut incorrecto'); $('#rut_transportista_temporal').val(""); }
				});
			$('#rut_transportista_temporal').attr('disabled','disabled');
			$('#nuevo').val("false");
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
				        		$('#estado').val(child.estado);
				    			$('#sap_transportista').val(child.sap_transportista);
				    			$('#nombre_transportista').val(child.nombre_transportista);
				    			$('#rut_transportista_temporal').val(child.rut_transportista);
				    			$('#nuevo').val("false");
				    			rut_child=child.rut_transportista;
				    		    $('#rut_transportista_temporal').attr('disabled','disabled');
							}	        		
			            }
			        );
			});
		}
		function confirmDelete() { 
		    if(confirm("¿Esta Seguro De Eliminar Este Proveedor?")) { 
				$('#formFiltros').submit();
		      }
		    else{
		    	return false;
		    }
	
		}
		function confirmEdit() { 
			if($('#sap_transportista').val()==""||$('#nombre_transportista').val()==""||$('#rut_transportista_temporal').val()==""){
				alert("Ingrese datos faltantes");
			}
			else{
				if(confirm("¿Esta Seguro De Agregar/Modificar Este Proveedor?")) { 
			    	$('#formFiltros').attr('action', '/punto_control/transportistas/guardar.do?rut_transportista='+$('#rut_transportista_temporal').val()+'&nuevo='+$('#nuevo').val()); 
					$('#formFiltros').submit();
			      }
			    else{
			    	return false;
			    }
			}
		}
		function clearFormulario(){
			$('#estado').val("0");
			$('#sap_transportista').val("");
			$('#nombre_transportista').val("");
			$('#rut_transportista').val("");
			$('#rut_transportista_temporal').val("");
			$('#nuevo').val("true");
		    $('#rut_transportista_temporal').removeAttr('disabled');
			$('#rut_transportista_temporal').focus();
		}
		function existeRut(){
			var lista = document.getElementById("rut_transportista");
			var r_t= replaceAll($('#rut_transportista_temporal').val(),".","");
			r_t= replaceAll(r_t,"-","");
			if(r_t.length==8){r_t="0"+r_t;}
			var i=0;
		    for (i = 0; i < lista.options.length; i++) {
		           if(r_t.toUpperCase()==lista.options[i].value){
	        		    alert("Rut existente");
		        	    $('#rut_transportista_temporal').val("");
		           }
		    }
		}

		function replaceAll( text, busca, reemplaza ){
		  while (text.toString().indexOf(busca) != -1)
		      text = text.toString().replace(busca,reemplaza);
		  return text;
		}
		
	</script>
</head>
<body> 
	<!-- BARRA SUPERIOR -->
	<%@ include file="../common/menu_superior.jsp" %>
	<!-- CONTENIDO -->
	<div id="content">
		<div id="page-heading"><h1>Mantenedor Proveedores</h1></div>

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
						<div id="dynamic">
							<!-- CONTENIDO TABLA -->
							<%@ include file="../common/messages.jsp" %>
							<html:form action="/transportistas/eliminar" method="post" styleId="formFiltros">
								<input type="hidden" id="nuevo"/>
								<html:hidden property="estado" name="transportistasForm" styleId="estado" />
												
								<table border="0" width="100%" cellpadding="0" cellspacing="0">
								<tr valign="top">
									<td style="width: 300px">
										<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
										<tr><td><br></br><br></br></td></tr>
										<tr>
											<th valign="top">Rut:</th>
											<td>
												<input type="text" id="rut_transportista_temporal" onblur="existeRut()"></input>
											</td>
										</tr>
										<tr>
											<th valign="top">Nombre:</th>
											<td>
												<html:text property="nombre_transportista" name="transportistasForm" styleId="nombre_transportista" >
												</html:text>
											</td>
										</tr>
										<tr>
											<th valign="top">Codigo Sap:</th>
											<td>
												<html:text property="sap_transportista" name="transportistasForm" styleId="sap_transportista" >
												</html:text>
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
													<html:select property="rut_transportista" name="transportistasForm" styleId="rut_transportista" style="width:230px" size="11" >
														<html:optionsCollection property="transportistas" name="transportistasForm" label="nombre_transportista" value="rut_transportista"  />
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
