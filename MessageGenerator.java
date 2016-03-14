package notification2;


import java.util.Scanner;

public class MessageGenerator extends MessageController{

	private String message;
	public String getMessage(){
		System.out.println("Enter number which you would like to notify:\n1.Notify the ride\n2.Send message to passenger\n3.Go bakc.");
		Scanner select = new Scanner(System.in);
		int ch = select.nextInt();
		if(ch == 1){
			return message = "Driver choose your ride.";
		}
		if(ch==2){
		System.out.println("Enter your message:");
		Scanner scan = new Scanner(System.in);
		String message = scan.nextLine();
		
		return message;
	}
		return message;
		}
	public void execute(){
		notifyObservers();
		
	}
}
