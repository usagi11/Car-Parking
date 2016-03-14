package notification2;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		MessageController generator = new MessageGenerator();
		Observer observer1 = new PassengerNotification();
		
		
		generator.addObserver(observer1);//this is going to Passenger's account
		generator.execute();//execute message
	}

}
