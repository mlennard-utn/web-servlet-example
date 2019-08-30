package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registracion")
public class RegistracionServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		
		System.out.println(String.format("Nombre: %s, Apellido: %s, Email: %s", name, lastName, email));
		
		req.setAttribute("resultado", "OK");
		
		RequestDispatcher rd = req.getRequestDispatcher("resultadoRegistracion.jsp");
		rd.forward(req, resp);
		
	}
	
}
