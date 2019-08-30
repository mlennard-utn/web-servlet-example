<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado registacion</title>
</head>
<body>

	<% 	String resultado = (String) request.getAttribute("resultado");
		
		if ("OK".equalsIgnoreCase(resultado)) {
	%>
		<h1>FELICITACIONES, REGISTRACION VALIDA</h1>	
			
	<% 	} else {
			
	%>	
		Email invalido: <%= request.getParameter("email") %>
	<% 		
		}	
	%>

</body>
</html>