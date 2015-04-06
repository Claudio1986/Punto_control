<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="../common/validateSession.jsp" %>

<bean:define id="productos" 		property="productos" 		name="productosForm" type="java.util.List"></bean:define>
<bean:define id="usuario" 			property="usuario" 			name="productosForm" type="cl.puntocontrol.hibernate.domain.Usuario"></bean:define>
<bean:define id="successMessage" 	property="successMessage" 	name="productosForm" 	type="java.lang.String"></bean:define>
<bean:define id="errorMessage" 		property="errorMessage" 	name="productosForm" 	type="java.lang.String"></bean:define>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Punto Control 1.0 - Mantenedor Productos</title>
	<link rel="stylesheet" href="/punto_control/html/css/screen.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/demo_page.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/jquery-ui-1.8.4.custom.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" type="text/css" href="/punto_control/html/css/pro_dropdown_3.css" />

	<script type="text/javascript"  src="/punto_control/html/js/pro_dropdown_3/stuHover.js"></script>
	<script type="text/javascript"  src="/punto_control/html/js/jquery/jquery.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			enlazarCombos($("#prd_codigo"),$("#codigo_especie"),"/punto_control/jsonProductoEspecie");
			$('#nuevo').val("true");
			$('#prd_descripcion').attr("maxlength", 50);
			$('#prd_codigo_temporal').attr("maxlength", 10);
			$('#prd_codigo_temporal').bind('keypress', function (e) {
		        return !(e.which != 8 && e.which != 0 &&
		                (e.which < 48 || e.which > 57) && e.which != 46);
		    });
		    $('#prd_codigo_temporal').attr('disabled','disabled');

		});
		
		function enlazarCombos(comboSource,comboDest,urlLoad){
			comboSource.bind("change",{},function(){
    			$('#nuevo').val("false");
				var parentId=$(this).val();
				var data={parentId:parentId};
				$.getJSON(urlLoad,data,
			            function(response, textStatus, jqXHR) {
			        		var childs = [];
				        	for(indice=0;indice<response.length;indice++){
				        		var child=response[indice];
				        		$('#prd_codigo_temporal').val(child.prd_codigo);
				    			$('#prd_descripcion').val(child.prd_descripcion);
				    			$('#codigo_especie').val(child.codigo_especie);
				    		    $('#prd_codigo_temporal').attr('disabled','disabled');
							}	        		
			            }
			        );
			});
		}
		function confirmDelete() { 
		    if(confirm("¿Esta Seguro De Eliminar Este Producto?")) { 
				$('#formFiltros').submit();
		      }
		    else{
		    	return false;
		    }
	
		}
		function confirmEdit() { 
			if($('#prd_descripcion').val()==""){
				alert("Ingrese datos faltantes");
			}
			else{
			    if(confirm("¿Esta Seguro De Agregar/Modificar Este Producto?")) { 
			    	$('#formFiltros').attr('action', '/punto_control/productos/guardar.do?prd_codigo_temporal='+$('#prd_codigo_temporal').val()+'&nuevo='+$('#nuevo').val()); 
					$('#formFiltros').submit();
			      }
			    else{
			    	return false;
			    }
			}
		}
		function clearFormulario(){
			$('#nuevo').val("true");
			$('#prd_codigo_temporal').val("");
			$('#prd_descripcion').val("");
			$('#codigo_especie').val("");
		    $('#prd_codigo_temporal').removeAttr('disabled');
			$('#prd_codigo_temporal').focus();
		}
		function checkId(){
			var lista = document.getElementById("prd_codigo");
			var i=0;
		    for (i = 0; i < lista.options.length; i++) {
		           if($('#prd_codigo_temporal').val()==lista.options[i].value){
		        		   alert("Id asignado a otro producto ");
			        	   $('#prd_codigo_temporal').val("");
			        	   $('#prd_codigo_temporal').focus();
		           }
		    }
		}
		function checkDesc(){
			var lista = document.getElementById("prd_codigo");
			var i=0;
		    for (i = 0; i < lista.options.length; i++) {
		    	if($('#nuevo').val()=="true"){
		           if($('#prd_descripcion').val().toUpperCase()==lista.options[i].text.toUpperCase()){
		        		   alert("Descripcion existente");
		        		   $('#prd_descripcion').val("");
			        	   $('#prd_descripcion').focus();
		        	   }
		           }
		    	else{
		    		if(lista.options[i].value!=$('#prd_codigo').val()){
		    			if($('#prd_descripcion').val().toUpperCase()==lista.options[i].text.toUpperCase()){
			        		   alert("Descripcion existente");
			        		   $('#prd_descripcion').val("");
				        	   $('#prd_descripcion').focus();
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
		<div id="page-heading"><h1>Mantenedor Productos</h1></div>

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
							<html:form action="/productos/eliminar" method="post" styleId="formFiltros">
								<input type="hidden" id="nuevo" ></input>
								<table border="0" width="100%" cellpadding="0" cellspacing="0">
							<tr valign="top">
								<td style="width: 300px">
									<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
									<tr><td><br></br><br></br></td></tr>
									<tr>
										<th valign="top">Codigo:</th>
										<td>
											<input type="text" id="prd_codigo_temporal" onblur="checkId()"></input>
										</td>
									</tr>
									<tr>
										<th valign="top">Descripcion:</th>
										<td>
											<html:textarea property="prd_descripcion" name="productosForm" styleId="prd_descripcion" onblur="checkDesc()">
											</html:textarea>
										</td>
									</tr>
									<tr>
										<th valign="top">Especie:</th>
										<td>
											<html:select property="codigo_especie" name="productosForm" styleId="codigo_especie"  >
												<html:optionsCollection property="especies" name="productosForm" label="nombre_especie" value="id_especie" />
											</html:select>
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
												<html:select property="prd_codigo" name="productosForm" styleId="prd_codigo" style="width:230px" size="11">
													<html:optionsCollection property="productos" name="productosForm" label="prd_descripcion" value="prd_codigo" />
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
