<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registracion</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="display-3">REGISTRACION</h1>
	<form method="post" action="registracion">
		<div class="form-group">
			<label for="name"> Nombre </label> 
			<input type="text"
				class="form-control" name="name" required="required">
		</div>
		<div class="form-group">
			<label for="lastName"> Apellido</label> 
			<input type="text"
				name="lastName" class="form-control" required="required">
		</div>
		<div class="form-group">
			<label for="email"> E-mail</label> 
			<input type="email"
				class="form-control" name="email" required="required">
		</div>
		<button type="submit" class="btn btn-primary">Registrarse</button>
		

	</form>

	<%
		String resultado = (String) request.getAttribute("resultado");
		if (resultado != null) {
			if ("OK".equalsIgnoreCase(resultado)) {
	%>
	<h1>FELICITACIONES, REGISTRACION VALIDA</h1>
	<%
		} else {
				Collection<String> errores = (Collection<String>) request.getAttribute("errores");
				String email = request.getParameter("email");
				String lastName = request.getParameter("lastName");
				String firstName = request.getParameter("name");

				// Incluir el formulario para mostrar el contenido de los campos
	%>
	<H2 style="color: brown">HUBO UN ERROR EN LA REGISTRACION:</H2>
	<ul style="color: red">
		<%
			if (errores != null) {
						for (String error : errores) {
		%>
		<li><%=error%></li>
		<%
			}
					}
		%>
	</ul>
	<%
		}
		}
	%>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>