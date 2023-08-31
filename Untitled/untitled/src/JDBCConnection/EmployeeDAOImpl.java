package JDBCConnection;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl extends Employee implements EmployeeDAO {

	static Connection conn = CallableStatement.getConnection();

	
	
	
	@Override
	public int add(Employee emp) throws SQLException {
		String query = "insert into teacher (emp_id,emp_name,emp_address) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, emp.getEmp_id());
		ps.setString(2, emp.getEmp_name());
		ps.setString(3, emp.getEmp_address());
		int n = ps.executeUpdate();
		return n;
	}

	@Override
	public void delete(int id) throws SQLException {
		String query = "delete from teacher where emp_id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	@Override
	public Employee getEmployee(int id) throws SQLException {
		String query = "select * from teacher where emp_id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		Employee emp = new Employee();
		ResultSet rs = ps.executeQuery();
		boolean b = false;
		
		while(rs.next()) {
			b=true;
			emp.setEmp_id(rs.getInt("emp_id"));
			emp.setEmp_name(rs.getString("emp_name"));
			emp.setEmp_address(rs.getString("emp_address"));
		}
		if(b==true) {
			return  emp;
		}
		else {
		return null;
		}
	}

	@Override
	public List<Employee> getEmployees() throws SQLException {
	 List<Employee> ls = new ArrayList<Employee>();
	 String query = "Select * from teacher ";
	 PreparedStatement ps = conn.prepareStatement(query);
	
	 ResultSet rs = ps.executeQuery();
	 while(rs.next()) {
		 Employee emp = new Employee();
		 emp.setEmp_id(rs.getInt("emp_id"));
		 emp.setEmp_address(rs.getString("emp_address"));
		 emp.setEmp_name(rs.getString("emp_name"));
		 ls.add(emp);
	 }
		return ls;
	}

	@Override
	public void update(Employee emp) throws SQLException {
		 String query
         = "update employee set emp_name=?, "
           + " emp_address= ? where emp_id = ?";
     PreparedStatement ps
         = conn.prepareStatement(query);
     ps.setInt(1, emp.getEmp_id());
     ps.setString(2, emp.getEmp_name());
     ps.setString(3, emp.getEmp_address());
     ps.executeUpdate();
		
	}
	
	

}
