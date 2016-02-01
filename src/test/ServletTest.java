package test;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.crypto.provider.RSACipher;


/**
 * Servlet implementation class ServletTest
 */
public class ServletTest extends HttpServlet    {
	private static final long serialVersionUID = 1L;
	Content con = new Content("dataexchange","kingstar","jdbc:oracle:thin:@127.0.0.1:1521:xe");
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");	
		System.out.println("dopost starts!");
		
		ResultSet rs=null;
		PreparedStatement pre=null;
		
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		HttpSession session= request.getSession();
		session.removeAttribute("mess1");
		session.removeAttribute("mess");
		session.removeAttribute("mess2");
	    Connection conn= con.Startcon();
		String sql = "select * from testser where username='"+username+"'";
		String pass = null;
		try {
			
//			pre = conn.prepareStatement(sql);
//			pre.setString(1, username);
//			rs=pre.executeQuery(sql);
			rs=conn.createStatement().executeQuery(sql);
			while(rs.next()){
				pass = rs.getString("PWD").toString();
				System.out.println(pass);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(pre!=null)
						pre.close();
					if(rs!=null)
						rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		 
		
		if (username ==null || password ==null||username.equals("")||password.equals("")) {
			session.setAttribute("mess", "用户名或密码为空！请从新输入！");
			response.sendRedirect("login.jsp");
			con.Closecon();
		
			
		}
		else if ( password.equals(pass)) {
    	    session.setAttribute("username", username);
   		    session.setAttribute("password", password);
   		    session.removeAttribute("mess");
   		    session.removeAttribute("mess2");
			response.sendRedirect("jsp/home.jsp");
			// request.getRequestDispatcher("index.jsp").forward(request,response);
		} else {
			session.setAttribute("mess", "用户名或密码错误！请从新输入！");
			response.sendRedirect("login.jsp");
			con.Closecon();
			
		}
		
		return;
	
	}


}
