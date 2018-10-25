package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestLoggingFilter implements Filter {

	
	
	@Override
	public void destroy() {
		System.out.println("RequestLoggingFilter has been destroyed");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String remoteAddress = request.getRemoteAddr();
		String requestURI = ((HttpServletRequest)request).getRequestURI();
		
		System.out.println(String.format("IP: %s llama: %s", remoteAddress, requestURI ));
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("RequestLoggingFilter has been init");
	}

}
