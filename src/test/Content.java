package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Content {
    Connection con=null;
	private  String name;
	private String password;
	private String url;
	public Content(String name, String password, String url) {
		super();
		this.name = name;
		this.password = password;
		this.url = url;
	}
	public Connection Startcon(){
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			con=DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(con);
		
		 System.out.println("开始连接数据库");
		 return con;
		
	}
	public void Closecon( ){		
			try {
				if(con!=null)
				{con.close();
				System.out.println("数据库连接已关闭！");}
				else System.out.println("数据库未连接或已关闭");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
