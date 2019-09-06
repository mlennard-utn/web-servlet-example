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
		<input type="submit" value="Registrarse" >
		
	</form>
</body>
</html>