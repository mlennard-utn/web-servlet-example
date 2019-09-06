<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registracion</title>
</head>
<body>
	<h2> REGISTRACION </h2>
	<form method="post" action="registracion">
		<label for="name"> Nombre </label>
		<input type="text" name="name" required="required">
		<br>
		<label for="lastName"> Apellido</label>
		<input type="text" name="lastName" required="required">
		<br>
		<label for="email"> E-mail</label>
		<input type="email" name="email" required="required">
		<br>
		<input type="submit" value="Registrarse" ><br><br>
		
	</form>
	
	<% 	String resultado = (String) request.getAttribute("resultado");
		if (resultado != null ) {
			if ("OK".equalsIgnoreCase(resultado)) {
	%>
		<h1>FELICITACIONES, REGISTRACION VALIDA</h1>	
	<% 	} else {
			Collection<String> errores = (Collection<String>) request.getAttribute("errores");
			String email = request.getParameter("email");
			String lastName = request.getParameter("lastName");
			String firstName = request.getParameter("name");
			
			// Incluir el formulario para mostrar el contenido de los campos
			
	%>
		<H2 style="color: brown"> HUBO UN ERROR EN LA REGISTRACION: </H2>
		<ul style="color : red">
	<% 		
		if (errores != null ){	
			for(String error: errores){
	%>
				<li> <%= error %> </li> 
	<% 			
			} 
		}
	%>
		</ul>
	<%	
			}	
		}
	%>
	
	
</body>
</html>