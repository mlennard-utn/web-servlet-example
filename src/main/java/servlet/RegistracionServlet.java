package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Registration;
import servicio.RegistrationService;

@WebServlet("/registracion")
public class RegistracionServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		Collection<String> errores = new ArrayList<>();
		
		Registration registration = new Registration();
		registration.setEmail(email);
		registration.setFirstName(name);
		registration.setLastName(lastName);
		
		RegistrationService service = new RegistrationService();
		
		if (service.hasNotEmptyFields(registration)) {
			if(!service.isValidRegistration(registration)) {
				errores.add("El email debe comenzar con la misma letra del nombre y contener el apellido.");
			} 
			if(!service.isValidRegistrationDomain(registration)) {
				errores.add("Los dominios de correo valido son gmail.com, hotmail.com y yahoo.com");
			}
		} else {
			errores.add("Todos los campos de la registracion son requeridos");
		}
		
		if(errores.isEmpty()) {
			req.setAttribute("resultado", "OK");
		} else {
			req.setAttribute("resultado", "NOK");
			req.setAttribute("errores", errores);
			
			RequestDispatcher rd = req.getRequestDispatcher("registracion.jsp");
			rd.forward(req, resp);
			return;
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher("resultadoRegistracion.jsp");
		rd.forward(req, resp);
		
	}
	
}
