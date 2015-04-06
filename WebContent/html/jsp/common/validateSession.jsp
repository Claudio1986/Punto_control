<%if(session.getAttribute("userName")==null || session.getAttribute("password")==null){
	session.invalidate();%>
	<jsp:forward page="/login.do"></jsp:forward>
<%}%> 