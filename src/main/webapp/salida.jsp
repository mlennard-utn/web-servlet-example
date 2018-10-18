<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Salida</title>
</head>
<body style="background-color: cyan;">
	
	<%  Usuario user = (Usuario) request.getAttribute("usuario");
		if(user != null ) { %>
	Bienvenido <%= user.getNombre() %>, edad: <%= user.getEdad() %>. Fin, has completado la operacion.
	<% } else { 
		out.println("	No ingresaste ningun nombre!\r\n");
	 } %>	
	
	
</body>
</html>