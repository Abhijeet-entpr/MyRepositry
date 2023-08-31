package BankApp;

import java.sql.SQLException;

public class Application extends TransactionImpl{

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		TransactionImpl ti = new TransactionImpl();
		ti.showBalance();
		ti.deposite(1000);
		

	}

}
