package test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet Filter implementation class TilterTest
 */
public class FilterTest implements Filter {
	protected FilterConfig filterConfig; 
    /**
     * Default constructor. 
     */
    public FilterTest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.filterConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("Fliter is start！");
		
		
		HttpServletRequest serRequest=(HttpServletRequest)request;
		HttpServletResponse serResponse=(HttpServletResponse)response;
		
		serRequest.setCharacterEncoding("UTF-8");
		serResponse.setCharacterEncoding("UTF-8");
		
		String username = (String) serRequest.getSession().getAttribute("username");
		String password =(String) serRequest.getSession().getAttribute("password");
		if(username==null||password==null){
			serRequest.getSession().setAttribute("mess2","未登录请先登录！" );
			
			serResponse.sendRedirect("../login.jsp");
			return;
		}else{
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
	}

}
