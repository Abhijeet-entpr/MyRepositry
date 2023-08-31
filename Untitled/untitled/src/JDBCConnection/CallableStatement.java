package JDBCConnection;

import java.sql.*;
public class CallableStatement {
	
	

	private static Connection conn ;
	
	static {
		 String driver = "oracle.jdbc.driver.OracleDriver";
		 String user = "system";
		 String password = "asdf";
		 String connectionURL = "jdbc:oracle:thin:@localhost:1521/orclpdb";
		
		try {
			Class.forName(driver);
			
			 conn = DriverManager.getConnection(connectionURL,user,password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}


	public static Connection getConnection() {
		
		return conn;
	}


	

}
