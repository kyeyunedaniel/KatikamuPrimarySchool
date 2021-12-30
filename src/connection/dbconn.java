package connection;
import java.sql.*;

public class dbconn {
	public Connection getConenction() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String username= "root";
		String password= "";
		String url = "jdbc:mysql://localhost/katikamu?useSSL=false";
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
		
	}
		
}
