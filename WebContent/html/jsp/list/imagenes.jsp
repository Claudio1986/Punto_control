<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ include file="../common/validateSession.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Imagen: <%=request.getParameter("idFoto")%>.jpg Punto de Control: <%=request.getParameter("carpeta")%></title>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="/punto_control/html/css/jquery-ui-1.7.1.custom.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="/punto_control/html/css/jquery.gzoom.css" type="text/css" media="screen" />
		<script type="text/javascript" src="/punto_control/html/js/zoomJquery/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="/punto_control/html/js/zoomJquery/ui.core.min.js"></script>
		<script type="text/javascript" src="/punto_control/html/js/zoomJquery/ui.slider.min.js"></script>
		<script type="text/javascript" src="/punto_control/html/js/zoomJquery/jquery.mousewheel.js"></script> <!-- optional -->
		<script type="text/javascript" src="/punto_control/html/js/zoomJquery/jquery.gzoom.js"></script>		
		<script type="text/javascript">
			function descargarImagen(){
				var url="/punto_control/imageDownload?";
				var url=url+"idFoto="+"<%=request.getParameter("idFoto")%>";
				var url=url+"&carpeta="+"<%=request.getParameter("carpeta")%>";
				document.location = url;
			}
		</script>
		<style type="text/css">
		/* page styles */
		a:focus {
			outline:none;
		}
		a {
			color: #ff6600;
		}
		body {
			font-family: Verdana, sans-serif;
			text-align: center;
			margin: 0;
			padding: 0;
			background: #fff;
			color: #000;
			font-size: 62.5%;
		}
		#wrapp {
			width: 90%;
			text-align: left;
			font-size: 1.1em;
			margin: 1em auto;
			padding: 0;
			color: #000;
		}
		h1 {
			padding: 1em 0 0.8em 0;
			border-bottom: 1px solid silver;
			margin: 0 0 1em 0;
			font: bold 1.6em Verdana;
			letter-spacing: -1px;
		}
		hr {
			border:0px;
			border-bottom: 1px solid silver;
			margin:0px;
		}
		img {
			border:0px;
		}
		pre {
			font-size:12px;
		}
		</style>
	</head>
	<body>
		<div id="wrapp">
			<h1>Imagen: <%=request.getParameter("idFoto")%>.jpg <html:button property="Buscar Controles" onclick="descargarImagen()">Descargar Imagen</html:button> | Punto de Control: <%=request.getParameter("carpeta")%> </h1>
			<div id="zoom01" class="zoom"> 
				<img src="/punto_control/imageZoomServlet?idFoto=<%=request.getParameter("idFoto")%>&carpeta=<%=request.getParameter("carpeta")%>" alt="" title="Punto Control: <%=request.getParameter("carpeta")%> imagen: <%=request.getParameter("idFoto")%>.jpg" />
			</div>
		</div>

		<script type= "text/javascript">
			/*<![CDATA[*/
			$(function() {
				$("#zoom01").gzoom({
						sW: screen.availWidth-350,
						sH: screen.availHeight-175,
						lW: 1600,
						lH: 900,
						lighbox : false
				});
			});
			/*]]>*/
		</script>
	</body>
</html>
