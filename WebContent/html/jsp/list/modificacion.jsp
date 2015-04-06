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
	<title>Punto Control 1.0 - Modificacion</title>
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
		    "aoColumns":[{sTitle: "Fecha"},
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
		                 {sTitle: "Acciones"}]
		} );
		
		$("#patente_carro").attr("maxlength", 6);
		$("#guia_despacho").attr("maxlength", 50);
		$("#obs").attr("maxlength", 200);
		$("#obs_mod").attr("maxlength", 200);
	    $('#nombre_control_detalle_mod').attr('disabled','disabled');
	    $('#fecha_string').attr('disabled','disabled');
	    $('#hora').attr('disabled','disabled');
	    $('#foto1').attr('disabled','disabled');
	    $('#foto2').attr('disabled','disabled');
	    $('#usuario_').attr('disabled','disabled');
	    $('#rut_transportista_temporal').attr('disabled','disabled');

		$('#foto1').bind('keypress', function (e) {
	        return !(e.which != 8 && e.which != 0 &&
	                (e.which < 48 || e.which > 57) && e.which != 46);
	    });
		$('#foto2').bind('keypress', function (e) {
	        return !(e.which != 8 && e.which != 0 &&
	                (e.which<48||e.which>57) && e.which != 46);
	    });
		$('#guia_despacho').bind('keypress', function (e) {
	        return !(e.which != 8 && e.which != 0 &&
	                (e.which<48||e.which>57) && e.which != 46);
	    });
		
	} );
	
	function submitFormBuscar(){
		$('#formFiltros').submit();
	}
	
	function submitGuardar() { 
		if($("#id_control").val()>0){
			if($('#obs_mod').val()=="" || $('#obs_mod').val()==" "){
				alert("Ingrese Observacion Modificacion");
			}
			else{
			    if(confirm("¿Esta Seguro De Modificar Este Registro?")) { 
			    	$('#id-form-short').attr('action', '/punto_control/puntocontrol/modificacion/modificar.do'); 
					$('#id-form-short').submit();
			      }
			    else{
			    	return false;
			    }
			}
		}
		else{
			alert("Seleccione un registro");
		}
	}
	
	function submitPDF() {
		if($("#id_control").val()>0){
			var url="/punto_control/pdfServletTicket?";
			var url=url+"id_control="+$("#id_control").val();
			document.location = url;
		}
		else{
			alert("Seleccione un registro");
		}
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

	function verFoto1(val){
		var idFoto1 = $("#foto1").val();
		if(idFoto1>0){
			var carpeta1 = $("#nombre_control_detalle_mod").val();
			openFullscreen("/punto_control/html/jsp/list/imagenes.jsp?idFoto="+idFoto1+"&carpeta="+carpeta1);
		}
		else{
			alert("Seleccione un registro");
		}
	}
	function verFoto2(val){
		var idFoto2 = $("#foto2").val();
		if(idFoto2>0){
			var carpeta2 = $("#nombre_control_detalle_mod").val();
			openFullscreen("/punto_control/html/jsp/list/imagenes.jsp?idFoto="+idFoto2+"&carpeta="+carpeta2);
			}
		else{
			alert("Seleccione un registro");
		}
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
	function modificarSubmitForm(id){
		var urlLoad = "/punto_control/jsonModificarControl";
		var parentId=id;
		var data={parentId:parentId};
		$.getJSON(urlLoad,data,
	            function(response, textStatus, jqXHR) {
	        		var childs = [];
		        	for(indice=0;indice<response.length;indice++){
		        		var child=response[indice];
		        		$("#id_control").val(id);
		        		$("#nombre_control_detalle_mod").val(child.nombre_control_detalle_mod);
		        		check(child.patente,child.patente,"patente");
		        		check(child.rut_chofer,child.nombre_chofer,"rut_chofer");
		        		check(child.id_especie,child.nombre_especie,"id_especie");
		        		check(child.rut_transportista,child.nombre_transportista,"rut_transportista");
		        		check(child.codigo_producto,child.nombre_producto,"codigo_producto");
		        		changeTransportista();
		        		changeChofer();
		        		changeEspecie();
		        		changeProducto();
		        		$("#patente_carro").val(child.patente_carro);
		        		$("#guia_despacho").val(child.guia_despacho);
		        		$("#fecha_string").val(child.fecha);
		        		$("#hora").val(child.hora);
		        		$("#foto1").val(child.foto1);
		        		$("#foto2").val(child.foto2);
		        		$("#obs").val(child.obs);
		        		$("#obs_mod").val(child.obs_mod);
		        		$("#usuario_").val(child.usuario_);
		        	}        		
	            }
	        );
	}
	function check(value,label,control){
		var lista = document.getElementById(control);
		var nuevo_ = true; 	var i=0;
	    for (i = 0; i < lista.options.length; i++) {
	           if(value==lista.options[i].value){nuevo_=false;}}
	    if(nuevo_==false){$('#'+control+'').val(value);}
	    else{$('#'+control+'').append('<option value="'+value+'" selected="selected">'+label+'</option>');}
	}
	function changeTransportista(){
		$("#rut_transportista_temporal").val($("#rut_transportista").val());
		$("#nombre_transportista").val($("#rut_transportista").find("option:selected").text());
	}
	function changeChofer(){
		$("#nombre_chofer").val($("#rut_chofer").find("option:selected").text());
	}
	function changeEspecie(){
		$("#nombre_especie").val($("#id_especie").find("option:selected").text());
	}
	function changeProducto(){
		$("#nombre_producto").val($("#codigo_producto").find("option:selected").text());
	}
	</script>
</head>
<body> 
	<!-- BARRA SUPERIOR -->
	<%@ include file="../common/menu_superior.jsp" %>
	<!-- CONTENIDO -->
	<div id="content">
		<div id="page-heading"><h1>Modificacion</h1></div>
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
							<html:form action="puntocontrol/modificacion/buscar" method="post" styleId="formFiltros">
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
									</tr>
								</table>
							</html:form>
							<br/>
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="example" >
								<thead>
								</thead>
								<tbody>
								</tbody>
							</table>
							<br></br>
							<html:form action="puntocontrol/modificacion/modificar" method="post" styleId="id-form-short" >
							<table cellpadding="0" cellspacing="0" border="0" id="campos">
							<tr>
								<th valign="top"></th><td style="width: 240px;">
								<html:hidden property="id_control" styleId="id_control" name="puntoControlForm" />
								<html:hidden property="nombre_chofer" styleId="nombre_chofer" name="puntoControlForm" />
								<html:hidden property="nombre_producto" styleId="nombre_producto" name="puntoControlForm" />
								<html:hidden property="nombre_especie" styleId="nombre_especie" name="puntoControlForm" />
								<html:hidden property="nombre_transportista" styleId="nombre_transportista" name="puntoControlForm" /></td>
							</tr>
							<tr>
								<th valign="top">Patente:</th>
								<td>
								<html:select property="patente" name="puntoControlForm" styleId="patente" style="width:120px">
									<html:optionsCollection property="camiones" name="puntoControlForm" label="cam_patente" value="cam_patente" />
								</html:select>&nbsp;&nbsp;</td>
								<th valign="top">Carro:</th>
								<td><html:text property="patente_carro" name="puntoControlForm" styleId="patente_carro"></html:text></td>
							</tr>
							<tr>
								<th valign="top">Pto Control:</th>
								<td><html:text property="nombre_control_detalle_mod" name="puntoControlForm" styleId="nombre_control_detalle_mod" ></html:text></td>
								<th valign="top">Guia despacho:</th>
								<td><html:text property="guia_despacho" name="puntoControlForm" styleId="guia_despacho"></html:text></td>
							</tr>
							<tr>
								<th valign="top">Chofer:</th>
								<td>
								<html:select onchange="changeChofer()" property="rut_chofer" name="puntoControlForm" styleId="rut_chofer" style="width:220px">
									<html:optionsCollection property="choferes" name="puntoControlForm" label="nombre_chofer" value="rut_chofer" />
								</html:select>&nbsp;&nbsp;</td>
								<th valign="top">Proveedor:</th>
								<td>
								<html:select onchange="changeTransportista()" property="rut_transportista" name="puntoControlForm" styleId="rut_transportista" style="width:220px">
									<html:optionsCollection property="tranportistas" name="puntoControlForm" label="nombre_transportista" value="rut_transportista" />
								</html:select>&nbsp;&nbsp;</td>
								</tr>
							<tr>
								<th valign="top">Especie:</th>
								<td>
								<html:select onchange="changeEspecie()" property="id_especie" name="puntoControlForm" styleId="id_especie" style="width:220px">
									<html:optionsCollection property="especies" name="puntoControlForm" label="nombre_especie" value="id_especie" />
								</html:select>&nbsp;&nbsp;</td>
								<th valign="top">Producto:</th>
								<td>
								<html:select onchange="changeProducto()" property="codigo_producto" name="puntoControlForm" styleId="codigo_producto" style="width:220px">
									<html:optionsCollection property="productos" name="puntoControlForm" label="prd_descripcion" value="prd_codigo" />
								</html:select>&nbsp;&nbsp;</td>
							</tr>
							<tr>
								<th valign="top">Fecha:</th>
								<td><html:text property="fecha_string" name="puntoControlForm" styleId="fecha_string" size="9"></html:text></td>
								<th valign="top">Hora:</th>
								<td><html:text property="hora" name="puntoControlForm" styleId="hora" size="9"></html:text></td>
							</tr>
							<tr>
								<th valign="top">Foto1:</th>
								<td><html:text property="foto1" name="puntoControlForm" styleId="foto1"></html:text></td>
								<th valign="top">Foto2:</th>
								<td><html:text property="foto2" name="puntoControlForm" styleId="foto2"></html:text></td>
							</tr>
							<tr>
								<th valign="top">Rut Proveedor:</th>
								<td><html:text property="rut_transportista_temporal" name="puntoControlForm" styleId="rut_transportista_temporal"></html:text></td>
								<th valign="top">Usuario Modificacion:</th>
								<td><html:text property="usuario_" name="puntoControlForm" styleId="usuario_"></html:text></td>
							</tr>
							<tr>
								<th valign="top">Obs:</th>
								<td><html:textarea property="obs" name="puntoControlForm" styleId="obs"></html:textarea></td>
								<th valign="top">Obs Mod:</th>
								<td><html:textarea property="obs_mod" name="puntoControlForm" styleId="obs_mod"></html:textarea></td>
							</tr>
							</table>
							<html:button value="Modificar" onclick="submitGuardar()" property="Modificar"></html:button>
							<html:button value="Exportar Ticket" onclick="submitPDF()" property="Exportar Ticket"></html:button>

							<html:button value="Ver Foto 1" onclick="verFoto1()" property="Ver Foto 1"></html:button>
							<html:button value="Ver Foto 2" onclick="verFoto2()" property="Ver Foto 2"></html:button>
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
