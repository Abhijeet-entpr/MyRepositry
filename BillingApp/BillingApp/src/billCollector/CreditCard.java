package billCollector;

public class CreditCard implements Payments{
	public void pay(int num) {
		System.out.println("you have paid "+num+" from Credit Card" );
	}
}
