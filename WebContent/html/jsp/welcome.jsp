<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.hibernate.property.MapAccessor.MapSetter"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  
<bean:define id="usuario" property="usuario" name="loginForm" type="cl.puntocontrol.hibernate.domain.Usuario"></bean:define>

<%@ include file="common/validateSession.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Punto Control 1.0 - Reporte Controles Realizados Por Fecha</title>
	<link rel="stylesheet" href="/punto_control/html/css/screen.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" href="/punto_control/html/css/jquery-ui-1.8.4.custom.css" type="text/css" media="screen" title="default" />
	<link rel="stylesheet" type="text/css" href="/punto_control/html/css/pro_dropdown_3.css" />

	<script type="text/javascript"  src="/punto_control/html/js/pro_dropdown_3/stuHover.js"></script>
	<script type="text/javascript"  src="/punto_control/html/js/jquery/jquery.js"></script>
	
</head>
<body> 
	<!-- BARRA SUPERIOR -->
	<%@ include file="common/menu_superior.jsp" %>
	<!-- CONTENIDO -->
	<div id="content">
			</br>	</br>	</br>	</br>	</br>	</br>	</br>	</br>	</br>	</br>	</br>	</br>	
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/punto_control/html/images/logo.png" alt="Logo" />
			</br>	</br>	</br>	</br>	</br>	</br>	</br>	</br>	</br>	</br>	</br>	
			</br>	</br>	</br>	</br>	</br>	</br>	
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
