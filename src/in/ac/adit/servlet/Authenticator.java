package in.ac.adit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticator
 */
public class Authenticator extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username = null;
	private String password = null;
	private RequestDispatcher rd = null;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		username = request.getParameter("username");
		password = request.getParameter("password");

		if (request.getAttribute("MESSAGE") != null) {
			rd = request.getRequestDispatcher("index.jsp");
		} else {
			if (username.equals(password)) {
				request.setAttribute("USERNAME", username);
				rd = request.getRequestDispatcher("home.jsp");
			} else {
				request.setAttribute("MESSAGE", "Invalid Username / Password");
				rd = request.getRequestDispatcher("index.jsp");
			}
		}
		rd.forward(request, response);

	}
}
