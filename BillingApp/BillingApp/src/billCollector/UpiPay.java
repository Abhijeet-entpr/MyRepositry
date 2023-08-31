package billCollector;

public class UpiPay implements Payments{
	public void pay(int num) {
		System.out.println("you have paid "+num+" from UPI" );
	}
}
