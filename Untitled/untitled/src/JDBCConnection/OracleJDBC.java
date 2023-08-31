
package JDBCConnection;
import java.sql.*;  
import java.io.*;
class OracleJDBC{  
public static void main(String args[]){  
try{  
//step1 load the driver class  
//	this method attempts to
//    * locate and load the class or interface.  The specified class
//    * loader is used to load the class or interface.  If the parameter
//    * {@code loader} is null, the class is loaded through the bootstrap
//    * class loader.  The class is initialized only if the
//    * {@code initialize} parameter is {@code true} and if it has
//    * not been initialized earlier.
  Class.forName("oracle.jdbc.driver.OracleDriver");
  
  Connection con=DriverManager.getConnection(  
		  "jdbc:oracle:thin:@localhost:1521/orclpdb","system","asdf");  
  		
  		con.setAutoCommit(false);
		    
  		FileInputStream fis = new FileInputStream("C:\\Users\\user\\Downloads\\WhatsApp Image 2023-06-05 at 19.01.18.jpeg");
		  //step3 create the statement object  
		  PreparedStatement stmt=con.prepareStatement("insert into photo values(?,?)"); 
		    stmt.setBinaryStream(1, fis);
		    stmt.setString(2, "Abhi");
		  
		    int n = stmt.executeUpdate();
		  con.commit();
//		    
		  System.out.println("executed "+n);
		   
		    stmt.close();
  //step5 close the connection object  
		con.close();  
  
  
  }catch(Exception e) {
	  System.out.println(e);
  }
}
}
	