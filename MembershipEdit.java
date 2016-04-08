import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MembershipEdit extends Member{

	private static final long serialVersionUID = 1L;
	Scanner scan = new Scanner(System.in);	
	List<Member> list = new ArrayList<Member>();
	//view member information
	public void viewInfo(Member m) {
		System.out.println(m);
	}
	//change user name
	public void editUserName(Member m){
		System.out.println("Enter your new user name:");
		String new_userName = scan.next();
		m.setUserName(new_userName);
		System.out.println(m);
	}//end of user name change
	
	//change password
	public void editPassword(Member m){
		System.out.println("Enter your old password");
		boolean pass_check = false;
		while(!pass_check){
		String former_pass = scan.next();
		if(!m.getPassword().equals(former_pass)){
			System.out.println("The old password doesn't match, please start re-enter your old password.");
			pass_check = false;
		}
		else{
			System.out.println("Enter new password:");
			String new_password = scan.next();
			m.setPassword(new_password);
			System.out.println(new_password);
			pass_check = true;
		}
	}
	}
	//change status
	public void editStatus(Member m){
		if(m.getStatus() == 1){
			System.out.println("Would you like to change as a \n1.passenger\n2.both");
			int s_change = scan.nextInt();
			if(s_change == 1){
				m.setStatus(2);
			}
			if(s_change == 2){
				m.setStatus(3);
			}
		}
		if(m.getStatus() == 2){
			System.out.println("Would you like to change as a \n1.driber\n2.both");
			int s_change = scan.nextInt();
			if(s_change == 1){
				m.setStatus(1);
			}
			if(s_change == 2){
				m.setStatus(3);
			}
			}
		if(m.getStatus() == 3){
			System.out.println("Would you like to change as a \n1.driber\n2.passenger");
			int s_change = scan.nextInt();
			if(s_change == 1){
				m.setStatus(1);
			}
			if(s_change == 2){
				m.setStatus(2);
			}
			}
		
	}
	
	//change email
	public void editEmail(Member m){
		System.out.println("Enter your new email address");
		String new_email = scan.next();
		m.setEmail(new_email);
	
	}
	//change car type
	public void editCarType(Member m){
		System.out.println("Enter your car type");
		String new_carType = scan.next();
		m.setV_model(new_carType);
		System.out.println("Enter new registration number:");
		String new_registration = scan.next();
		m.setV_register(new_registration);
	
	}
	//change registration number
	public void editRegistrationNumber(Member m){
		System.out.println("Enter new registration number:");
		String new_registration = scan.next();
		m.setV_register(new_registration);
	}
	//change number of people
	public void editRidingNumber(Member m){
		System.out.println("How many people can you ride in your car?");
		int new_number = scan.nextInt();
		m.setNumberOfPassenger(new_number);
	
	}
	
	public void deleteMember(List<Member> list, Member m){
		list.remove(m);
	}
	


	



}
