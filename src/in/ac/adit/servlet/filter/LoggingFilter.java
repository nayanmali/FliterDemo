package in.ac.adit.servlet.filter;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class LoggingFilter implements Filter {

	private String username = null;	
	RequestDispatcher rd = null;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		username = request.getParameter("username");

		if (username.contains("'")) {
			request.setAttribute("MESSAGE", "We are Watching You");
			System.out.println(InetAddress.getLocalHost()+" Wants To Hack Your Login");
			request.setAttribute("MESSAGE", "WE ARE WATCHING YOU");
		}
		
		chain.doFilter(request, response);

	}

}
