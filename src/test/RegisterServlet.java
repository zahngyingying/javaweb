package test;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.Spring;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		Content con = new Content("dataexchange", "kingstar",
				"jdbc:oracle:thin:@127.0.0.1:1521:xe");
		con.Startcon();
		System.out.println("Register is start!");
		PreparedStatement pre=null;
		ResultSet rs=null;

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		HttpSession session = request.getSession();
		session.removeAttribute("mass");
		session.removeAttribute("mess1");
		

		if (username == null || password == null || username.equals("")
				|| password.equals("")) {
			session.setAttribute("mess1", "用户名或密码不能为空请从新填写！");
			response.sendRedirect("register.jsp");
			return;
		} else if(username.indexOf(" ")>-1||password.indexOf(" ")>-1){
			session.setAttribute("mess1", "用户名或密码不能帶有空格请从新填写！");
			response.sendRedirect("register.jsp");
			return;
			
		}
		else {
			
			String sql = "select username from testser";
			try {
				rs = con.con.createStatement().executeQuery(sql);
				while (rs.next()) {
					if (rs.getString("username").toString().equals(username)) {
						session.setAttribute("mess1", "用户名重复！请从新填写！");
						response.sendRedirect("register.jsp");
						return;
					
					} 
				}
				
				System.out.println("not null");
				session.setAttribute("username", username);
				session.setAttribute("username", password);
				
				
//				String insertsql="insert into testser values (?,?)";
//				pre=con.con.prepareStatement(insertsql);
//				pre.setString(1, username);
//				pre.setString(2, password);
//				pre.executeUpdate(insertsql);
				
				String insertsql="insert into testser values ('"+username+"','"+password+"')";
				con.con.createStatement().executeUpdate(insertsql);
				con.con.commit();
				session.removeAttribute("mess");
				session.removeAttribute("mess1");
				response.sendRedirect("login.jsp");
				
				
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
			
				con.Closecon();
			
				
			}
			
		}
		
	
	}

}
