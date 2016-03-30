import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MembershipDemo {


	
	private Member member;
	boolean repeat = false;
	
	public Member driver(){
		while(!repeat){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your infomation:");
		System.out.println("First name:");
		String fname = scan.next();
		System.out.println("Last name:");
		String lname = scan.next();
		System.out.println("User name:");
		String uname = scan.next();
		System.out.println("Password");
		String pword = scan.next();
		System.out.println("SJSUID:");
		int id = scan.nextInt();
		System.out.println("Email:");
		String email = scan.next();
		int status = 1;
		System.out.println("Car information:");
		System.out.println("Vechile model");
		String model = scan.next();
		System.out.println("Registration number:");
		String regist = scan.next();
		System.out.println("Expire date:");
		String ex = scan.next();
		System.out.println("How many people can you ride in your car?");
		int number = scan.nextInt();
		System.out.println("Please confirm your info is correct:");
		System.out.println("Name: " + fname + " " + lname + "\n" + "User name: " + uname +
				 "\n" + "SJSU ID: " + id + "\n" + "Email: " + email + "\n" +
				 "Vehicle model: " + model + "\n" + "Regstration number: " + regist + "\n" +
				 "Expire date: " + ex + "\n" + "Number of Passengers which you can take \n" + number + " people");
		System.out.println("Would you like to confirm the info\n1.Yes\n2.No");
		int answer = scan.nextInt();
		if(answer == 1){
			member = new Member(fname, lname, uname, pword, id, email, status, model, regist, ex, number);
			repeat = true;
		}
	    else{
	    	repeat = false;
	    }
	    }
		return member;
	}
	
	public Member passenger(){
		while(!repeat){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your infomation:");
		System.out.println("First name:");
		String fname = scan.next(); 
		System.out.println("Last name:");
		String lname = scan.next();
		System.out.println("User name:");
		String uname = scan.next();
		System.out.println("Password");
		String pword = scan.next();
		System.out.println("SJSUID:");
		int id = scan.nextInt();
		System.out.println("Email:");
		String email = scan.next();
		int status = 2;
		System.out.println("Please confirm your info is correct:");
		System.out.println("Name: " + fname + " " + lname + "\n" + "User name: " + uname +
				 "\n" + "SJSU ID: " + id + "\n" + "Email: " + email);
		System.out.println("Would you like to confirm the info\n1.Yes\n2.No");
		int answer = scan.nextInt();
		if(answer == 1){
			member = new Member(fname, lname, uname, pword, id, email, status);
			repeat = true;
		}
		else{
			repeat = false;
		}
		}
			return member;
		}
	public Member both(){
		while(!repeat){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your infomation:");
		System.out.println("First name:");
		String fname = scan.next();
		System.out.println("Last name:");
		String lname = scan.next();
		System.out.println("User name:");
		String uname = scan.next();
		System.out.println("Password");
		String pword = scan.next();
		System.out.println("SJSUID:");
		int id = scan.nextInt();
		System.out.println("Email:");
		String email = scan.next();
		int status = 3;
		System.out.println("Car information:");
		System.out.println("Vechile model");
		String model = scan.next();
		System.out.println("Registration number:");
		String regist = scan.next();
		System.out.println("Expire date:");
		String ex = scan.next();
		System.out.println("How many people can you ride in your car?");
		int number = scan.nextInt();
		System.out.println("Please confirm your info is correct:");
		System.out.println("Name: " + fname + " " + lname + "\n" + "User name: " + uname +
				 "\n" + "SJSU ID: " + id + "\n" + "Email: " + email + "\n" +
				 "Vehicle model: " + model + "\n" + "Regstration number: " + regist + "\n" +
				 "Expire date: " + ex + "\n" + "Number of Passengers which you can take \n" + number + " people");

		System.out.println("Would you like to confirm the info\n1.Yes\n2.No");
		int answer = scan.nextInt();
		if(answer == 1){
		member = new Member(fname, lname, uname, pword, id, email, status, model, regist, ex, number);
		repeat = true;
		}
		else{
			repeat = false;
		}
		}
		return member;
	}


	
	public void serialize(List<Member> peopleList, String fileName){
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
			out.writeObject(peopleList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void LoginSystem(){
		
	try(ObjectInputStream os = new ObjectInputStream(new FileInputStream("test.ser"))){
		ArrayList<Member> peopleList = (ArrayList<Member>)os.readObject();	
		boolean check = false;
		while(!check){
		System.out.println("Enter user name");
		Scanner scan2 = new Scanner(System.in);
		String name = scan2.next();
		System.out.println("Enter your password");
		String id = scan2.next();
		Member downloadList = new Member(name, id);
		boolean correct = false;
		int repeat = 0;
		
		while(!correct){
		for(Member list: peopleList){
			if(downloadList.contains(list)){
				System.out.println("Successfuly log in!");
				System.out.println("Your info is:");
				System.out.println(list);
				correct = true;
				check = true;
				//member = list;
				repeat = 0;
				System.out.println("Select the memu\n1.View account\n2.edit account or shedule info\n3.go back");
				Scanner scan3 = new Scanner(System.in);
					int menu = scan3.nextInt();
					if(menu == 1){
						member.AccountInfo(list);
					}
				break;
			}
			else if(!downloadList.contains(list)){
				correct = true;
				check = false;
				repeat = 1;
			}
			
			}
		
		}
	if(repeat == 1){
		System.out.println("Wrong name or ID\nPlease start over.");
	}
		}
		
		
	System.out.println("Select the memu\n1.View account\n2.edit account or shedule info\n3.go back");
	Scanner scan2 = new Scanner(System.in);
		int menu = scan2.nextInt();
		if(menu == 1){
			//viewAccountInfo(list);
		}
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
/*
	
	public String (Member m){
		Member member = null;
		if(m.checkStatus() == 1){
			return "Name: " + getFirstName() + " " + getLastName() + "\n" + "User name: " + getUserName()
					+ "\n" + "SJSU ID: " + getId() + "\n" + "Email: " + getEmail() + "\n"
					+ "Vehicle model: " + getV_model() + "\n" + "Regstration number: " + getV_register() + "\n"
					+ "Expire date: " + getR_date() + "\n" + "Number of Passengers which you can take " + getNumberOfPassenger() + " peolple";
		}
		if(m.checkStatus() == 2){
			return member;
		}
		
	}*/


}


