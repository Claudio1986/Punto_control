<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="../common/validateSession.jsp" %>

<bean:define id="usuarios" 			property="usuarios" 		name="usuariosForm" type="java.util.List"></bean:define>
<bean:define id="usuario" 			property="usuario" 			name="usuariosForm" type="cl.puntocontrol.hibernate.domain.Usuario"></bean:define>
<bean:define id="successMessage" 	property="successMessage" 	name="usuariosForm" type="java.lang.String"></bean:define>
<bean:define id="errorMessage" 		property="errorMessage" 	name="usuariosForm" type="java.lang.String"></bean:define>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Punto Control 1.0 - Mantenedor Usuarios</title>
	<link rel="stylesheet" href="/punto_control/html/css/screen.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/demo_page.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/jquery-ui-1.8.4.custom.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" type="text/css" href="/punto_control/html/css/pro_dropdown_3.css" />

	<script type="text/javascript"  src="/punto_control/html/js/pro_dropdown_3/stuHover.js"></script>
	<script type="text/javascript"  src="/punto_control/html/js/jquery/jquery.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			enlazarCombos($("#nombre"),$("#clave_acceso"),"/punto_control/jsonUsuarioPermisos");
			$('#nombre_temporal').attr("maxlength", 40);
			$('#claveAcceso').attr("maxlength", 5);
			$('#nombre_temporal').val("");
			$('#clave_acceso').val("");
			$("#f3").prop("checked", false);
    		$("#f4").prop("checked", false);
    		$("#f5").prop("checked", false);
    		$("#f8").prop("checked", false);
    		$("#f9").prop("checked", false);
    		$("#f11").prop("checked", false);
    		$("#f17").prop("checked", false);
    		$("#f18").prop("checked", false);
    		$("#f19").prop("checked", false);
    		$("#f20").prop("checked", false);
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
				        		$('#nombre_temporal').val(child.nombre);
				        		$('#clave_acceso').val(child.clave_acceso);
				        		if(child.f3==1){$("#f3").prop("checked", true);}else{$("#f3").prop("checked", false);}
				        		if(child.f4==1){$("#f4").prop("checked", true);}else{$("#f4").prop("checked", false);}
				        		if(child.f5==1){$("#f5").prop("checked", true);}else{$("#f5").prop("checked", false);}
				        		if(child.f8==1){$("#f8").prop("checked", true);}else{$("#f8").prop("checked", false);}
				        		if(child.f9==1){$("#f9").prop("checked", true);}else{$("#f9").prop("checked", false);}
				        		if(child.f11==1){$("#f11").prop("checked", true);}else{$("#f11").prop("checked", false);}
				        		if(child.f17==1){$("#f17").prop("checked", true);}else{$("#f17").prop("checked", false);}
				        		if(child.f18==1){$("#f18").prop("checked", true);}else{$("#f18").prop("checked", false);}
				        		if(child.f19==1){$("#f19").prop("checked", true);}else{$("#f19").prop("checked", false);}
				        		if(child.f20==1){$("#f20").prop("checked", true);}else{$("#f20").prop("checked", false);}
				        		}	        		
			            }
			        );
			});
		}
		function confirmDelete() { 
		    if(confirm("¿Esta Seguro De Eliminar Este Usuario?")) { 
				$('#formFiltros').submit();
		      }
		    else{
		    	return false;
		    }
	
		}
		function confirmEdit() { 
			if($('#nombre_temporal').val()=="" || $('#clave_acceso').val()==""){
				alert("Ingrese datos faltantes");
			}
			else{
			    if(confirm("¿Esta Seguro De Agregar/Modificar Este usuario?")) { 
			    	$('#formFiltros').attr('action', '/punto_control/usuario/guardar.do?nombre='+$('#nombre_temporal').val()); 
					$('#formFiltros').submit();
			      }
			    else{
			    	return false;
			    }
			}
		}
		function clearFormulario(){
			$('#nombre_temporal').val("");
			$('#clave_acceso').val("");
    		$("#f3").prop("checked", false);
    		$("#f4").prop("checked", false);
    		$("#f5").prop("checked", false);
    		$("#f8").prop("checked", false);
    		$("#f9").prop("checked", false);
    		$("#f11").prop("checked", false);
    		$("#f17").prop("checked", false);
    		$("#f18").prop("checked", false);
    		$("#f19").prop("checked", false);
    		$("#f20").prop("checked", false);
			$('#nombre_temporal').focus();
		}
	</script>
</head>
<body> 
	<!-- BARRA SUPERIOR -->
	<%@ include file="../common/menu_superior.jsp" %>
	<!-- CONTENIDO -->
	<div id="content">
		<div id="page-heading"><h1>Mantenedor Usuarios</h1></div>

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
							<html:form action="/usuario/eliminar" method="post" styleId="formFiltros">
							<table border="0" width="100%" cellpadding="0" cellspacing="0">
							<tr valign="top">
								<td style="width: 260px">
									<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
									<tr><td><br></br><br></br><br></br></td></tr>
									<tr>
										<th valign="top">Nombre:</th>
										<td>
											<input type="text" id="nombre_temporal"></input><br/><br/>
										</td>
									</tr>
									<tr>
										<th valign="top">Clave Acceso:</th>
										<td>
											<html:text property="clave_acceso" name="usuariosForm" styleId="clave_acceso" >
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
								<td style="width: 150px">
									<table >
										<tr><th valign="top" align="left">Productos:</th><td><html:checkbox property="f3" name="usuariosForm" styleId="f3" value="1"></html:checkbox></td></tr> 
										<tr><th valign="top" align="left">Modificar:</th><td><html:checkbox property="f4" name="usuariosForm" styleId="f4" value="1"></html:checkbox></td></tr>
										<tr><th valign="top" align="left">Camiones:</th><td><html:checkbox property="f5" name="usuariosForm" styleId="f5" value="1"></html:checkbox></td></tr>
										<tr><th valign="top" align="left">Usuario:</th><td><html:checkbox property="f8" name="usuariosForm" styleId="f8" value="1"></html:checkbox></td></tr>
										<tr><th valign="top" align="left">Parametros:</th><td><html:checkbox property="f9" name="usuariosForm" styleId="f9" value="1"></html:checkbox></td></tr>
										<tr><th valign="top" align="left">Mantencion BD:</th><td><html:checkbox property="f11" name="usuariosForm" styleId="f11" value="1"></html:checkbox></td></tr>
										<tr><th valign="top" align="left">Especies:</th><td><html:checkbox property="f17" name="usuariosForm" styleId="f17" value="1"></html:checkbox></td></tr>
										<tr><th valign="top" align="left">Proveedores:</th><td><html:checkbox property="f18" name="usuariosForm" styleId="f18" value="1"></html:checkbox></td></tr>
										<tr><th valign="top" align="left">Choferes:</th><td><html:checkbox property="f19" name="usuariosForm" styleId="f19" value="1"></html:checkbox></td></tr>
										<tr><th valign="top" align="left">Historial:</th><td><html:checkbox property="f20" name="usuariosForm" styleId="f20" value="1"></html:checkbox></td></tr>
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
												<html:select property="nombre" name="usuariosForm" styleId="nombre" style="width:230px" size="11">
													<html:optionsCollection property="usuarios" name="usuariosForm" label="nombre" value="nombre" />
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
