package JDBCConnection;
import java.sql.SQLException;
import java.util.List;
public class Application extends EmployeeDAOImpl {

	public static void main(String[] args) throws SQLException{
		
		Employee empobj = new Employee();
		empobj.setEmp_id(12);
		empobj.setEmp_name("Iron Man");
		empobj.setEmp_address("Earth");
		
		EmployeeDAOImpl empd = new EmployeeDAOImpl();
		
		//add
		empd.add(empobj);
		
		//getEmployee
		empd.getEmployee(12);
		
		List<Employee> ls = empd.getEmployees();
		for(Employee x : ls) {
			System.out.println(x);
		}
		
		
		
	}

}
