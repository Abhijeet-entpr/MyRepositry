package JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class BatchUpdation {
	static Connection conn = CallableStatement.getConnection();

	public static void main(String[] args) throws SQLException {
		conn.setAutoCommit(false);
		Statement ps = conn.createStatement();
		
		 String query = "insert into teacher values(25, 'Star Lord', 'Earth')";
		 ps.addBatch(query);
		 String query1 = "insert into teacher values(26, 'Groot', 'Unnkown')";
		 ps.addBatch(query1);
		 String query2 = "insert into teacher values(27, 'Rocket', 'Unknown')";
		 ps.addBatch(query2);
		// TODO Auto-generated method stub
		
		int [] a = ps.executeBatch();
		
		for(int n=0;n<a.length;n++) {
		System.out.println(a[n]);
		}
		conn.commit();
		ps.close();
		
		
		}

}
