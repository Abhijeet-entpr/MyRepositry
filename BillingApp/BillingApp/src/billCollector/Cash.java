package billCollector;

public class Cash implements Payments{
	public void pay(int num) {
		System.out.println("you have paid "+num+" in Cash ");
	}
}
