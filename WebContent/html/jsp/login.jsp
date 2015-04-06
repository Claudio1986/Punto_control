<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Punto Control 1.0</title>
	
	<link rel="stylesheet" href="/punto_control/html/css/screen.css" type="text/css" media="screen" title="default" />
	
</head>
<body> 
 
<div id="login-holder">

	<div id="logo-login">
		<a href="http://www.molinstec.cl"><img src="/punto_control/html/images/shared/logo.png" width="156" height="40" alt="Sistema de control" /></a>
	</div>
	
	<div class="clear"></div>
	
	<div id="loginbox">
	
	<div id="login-inner">
		<html:form action="/login/submit" method="post">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<th>Codigo</th>
				<td><html:text name="loginForm" property="nombre" styleClass="login-inp" /></td>
			</tr>
			<tr>
				<th>Clave</th>
				<td><html:password name="loginForm" property="clave_acceso"  value=""  onfocus="this.value=''" styleClass="login-inp" /></td>
			</tr>
			<tr>
				<th></th>
				<td align="center"><html:submit styleClass="submit-login"></html:submit></td>
			</tr>
			</table>
			
		</html:form>
	</div>
	<div class="clear"></div>
 </div>
</div>
</body>
</html>