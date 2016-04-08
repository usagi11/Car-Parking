import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Demo2 {

	public static void main(String[] args){


	try(ObjectInputStream os = new ObjectInputStream(new FileInputStream("test.ser"))){
		List<Member> peopleList = (ArrayList<Member>)os.readObject();
		System.out.println(peopleList);
		Scanner scan = new Scanner(System.in);
		boolean check = false;

		MembershipDemo member = new MembershipDemo();
		System.out.println("1.Sign up\n2.Log in");
		int choice = scan.nextInt();
		
		if(choice == 1){
			while(!check){
				System.out.println("Please enter member type:\n1.Driver\n2.Passenger\n3.Both");
				int status = scan.nextInt();
			if(status == 1){
				Member driver = member.driver();
				peopleList.add(driver);
			}
			if(status == 2){
				Member passenger = member.passenger();
				peopleList.add(passenger);
			}
			else{
				Member both = member.both();
				peopleList.add(both);
			}
			/*
			System.out.println("Enter 1 to continue");
			int cont = scan.nextInt();
				if(cont == 1){
					check = false;
				}
				else{
					check = true;
				}
				*/
			
		member.serialize(peopleList, "test.ser");
		System.out.println(peopleList);
		}
		}
//-----------------------------------------------------------------------------------------------//
		
	if(choice == 2){
		Member person = member.LoginSystem();
		member.MaintainMembership(person);
		
		//member.LoginSystem();
		//individual.LoginSystem();
		System.out.println(person);
		//System.out.println(peopleList);
		member.serialize(peopleList, "test.ser");
		
	}		
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	
		}
}

	

	
		
	



