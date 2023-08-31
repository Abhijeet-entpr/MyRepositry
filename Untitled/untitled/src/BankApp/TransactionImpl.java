package BankApp;
import java.sql.*;

import JDBCConnection.CallableStatement;
public class TransactionImpl implements Transactions {
	
	static Connection conn = CallableStatement.getConnection();
	
	@Override
	public void withdraw(int Amount) throws SQLException {
		// TODO Auto-generated method stub
		Account acc = new Account();
		acc.Balance = acc.Balance - Amount;
		String query = "insert into Bank values(?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(2, Amount);
		ps.executeUpdate();
		
	}

	@Override
	public void deposite(int Amount) throws SQLException {
		// TODO Auto-generated method stub
		Account acc = new Account();
		acc.Balance = acc.Balance + Amount;
		String query = "insert into Bank values(?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, Amount);
		ps.executeUpdate();
		
		
	}

	@Override
	public int showBalance() throws SQLException {
		Account acc = new Account();
		String query = "update Bank set [balance=?] where deposite=1000";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(3, acc.getBalance());
		ps.executeUpdate();
		return acc.getBalance();
	}
	

}
