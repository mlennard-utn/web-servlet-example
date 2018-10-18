package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;

public class ServletRedirect extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("nombre");
		Integer age = Integer.valueOf(req.getParameter("edad"));
		
		Usuario usuario = new Usuario();
		usuario.setEdad(age);
		usuario.setNombre(user);
		
		req.setAttribute("usuario",usuario);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/salida.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// set response headers
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/entrada.jsp");
		rd.forward(request, response);
		
		
		// Creacion Formulario HTML via PrintWriter
//		PrintWriter writer = response.getWriter();
//		writer.append("<!DOCTYPE html>\r\n")
//			  .append("<html>\r\n")
//			  .append("		<head>\r\n")
//			  .append("			<title>Formulario ingreso del nombre</title>\r\n")
//			  .append("		</head>\r\n")
//			  .append("		<body>\r\n")
//			  .append("			<form action=\"bienvenido\" method=\"POST\">\r\n")
//			  .append("				Ingrese su nombre: \r\n")
//			  .append("				<input type=\"text\" name=\"user\" />\r\n")
//			  .append("				<input type=\"submit\" value=\"Submit\" />\r\n")
//			  .append("			</form>\r\n")
//			  .append("		</body>\r\n")
//			  .append("</html>\r\n");
	}
	
}
