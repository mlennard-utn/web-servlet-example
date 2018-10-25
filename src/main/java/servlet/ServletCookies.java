package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class ServletCookies extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String userID = "admin";
	private final String password = "admin";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		if(user.equals(userID) && pwd.equals(password)){
			Cookie loginCookie = new Cookie("nuestraCookie",user);
			HttpSession session = request.getSession(true);
			
			loginCookie.setValue(URLEncoder.encode(user, "UTF-8"));
			session.setAttribute(Constantes.SESSION_USER_NAME, user);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			response.sendRedirect("LoginSuccess.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Usuario o contrasenia invalidos.</font>");
			rd.include(request, response);
		}

	}

	
	
}
