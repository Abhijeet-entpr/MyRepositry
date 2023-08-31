package billCollector;

public class Test {
public static void main(String[] args) {
	BillCollector billCollector = new BillCollector(); 
	Payments payments = new CreditCard();	
	billCollector.setPayment(payments);
	payments.pay(2000);
}
	
}
