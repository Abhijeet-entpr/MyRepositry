package billCollector;

public class NetBanking implements Payments{
	public void pay(int num) {
		System.out.println("you have paid "+num+" from NetBanking" );
	}
}
