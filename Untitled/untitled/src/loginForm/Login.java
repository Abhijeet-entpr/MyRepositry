package loginForm;
import java.sql.*;
import java.util.*;
import JDBCConnection.CallableStatement;
public class Login {
	static Connection conn = CallableStatement.getConnection();
	
	public static void main(String[] args) throws SQLException {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter name :");
	String name1 = sc.nextLine();
	System.out.println("Enter passcode :");
	String address = sc.next();
	Statement ps= conn.createStatement();
	String query = "select emp_name,emp_address from teacher where emp_id=13";
	
	
	ResultSet rs = ps.executeQuery(query);
	
	while(rs.next()) {
	String name =	rs.getString("emp_name");
	String add = rs.getString("emp_address");
	if(name.equals(name1) && add.equals(address)) {
		System.out.println("Login succesfully");
	}
	else {
		System.out.println("error correct credentials is");
		System.out.println(name+" ,"+ add);
	}
	
	}

	

	}
	
}
