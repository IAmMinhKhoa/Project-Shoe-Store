package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDAO {
public static Connection con;
	
	public boolean openConnection(){
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String dbUrl ="jdbc:sqlserver://localhost:1433;DatabaseName=QLBH;encrypt=false";
				String username = "sa"; String password= "12345";
				con=DriverManager.getConnection(dbUrl, username, password);
				return true;
		} catch(Exception e)
			{
				System.out.println(e); 
				return false;
			}
		}
	
	public void closeConnection() {
			try {
				if (con!=null)
					con.close();
			} catch (SQLException ex)
			{
				System.out.println(ex); 
			}
	}
}
