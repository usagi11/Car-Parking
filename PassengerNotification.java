package notification2;

public class PassengerNotification implements Observer{
	
	public void update(MessageController generator){
		System.out.println("Message from Driver: " + generator.getMessage());
	}
	}

