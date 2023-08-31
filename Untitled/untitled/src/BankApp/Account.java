package BankApp;
import JDBCConnection.CallableStatement;
public class Account {

	int Balance;
	int Amount;
	int TransactionId;
	
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	
	
	
	public int getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}
	@Override
	public String toString() {
		return "Account [Balance=" + Balance + ", Amount=" + Amount + "]";
	}
	
	
}
