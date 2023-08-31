package BankApp;

import java.sql.SQLException;

public interface Transactions {
		
	void withdraw(int Amount) throws SQLException ;
	void deposite(int Amount) throws SQLException ;
	int showBalance() throws SQLException ;
}
