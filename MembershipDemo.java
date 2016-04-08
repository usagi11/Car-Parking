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
		System.out.println("++++Car information++++");
		System.out.println("Vechile model");
		String model = scan.next();
		System.out.println("Registration number:");
		String regist = scan.next();
		System.out.println("How many people can you ride in your car?");
		int number = scan.nextInt();
		Vehicle vehicle = new Vehicle(model, regist, number);
		System.out.println("Please confirm your info is correct:");
		System.out.println("Name: " + fname + " " + lname + "\n" + "User name: " + uname +
				 "\n" + "SJSU ID: " + id + "\n" + "Email: " + email + "\n" +
				 "Vehicle model: " + model + "\n" + "Regstration number: " + regist + "\n" +
				  "Number of Passengers which you can take \n" + number + " people");
		System.out.println("Would you like to confirm the info\n1.Yes\n2.No");
			int answer = scan.nextInt();
			if(answer == 1){
				member = new Member(fname, lname, uname, pword, id, email, status, vehicle);
				repeat = true;
			}
			else{
				repeat = false;
				//break;
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
		System.out.println("How many people can you ride in your car?");
		int number = scan.nextInt();
		Vehicle vehicle = new Vehicle(model, regist, number);
		System.out.println("Please confirm your info is correct:");
		System.out.println("Name: " + fname + " " + lname + "\n" + "User name: " + uname +
				 "\n" + "SJSU ID: " + id + "\n" + "Email: " + email + "\n" +
				 "Vehicle model: " + model + "\n" + "Regstration number: " + regist + "\n" +
				 "Number of Passengers which you can take \n" + number + " people");

		System.out.println("Would you like to confirm the info\n1.Yes\n2.No");
		int answer = scan.nextInt();
		if(answer == 1){
		member = new Member(fname, lname, uname, pword, id, email, status, vehicle);
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


	public Member LoginSystem(){
		
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
		
		//user name and password check
		while(!correct){
		for(Member list: peopleList){
			if(downloadList.contains(list)){
				System.out.println("Successfuly log in!\n");
				correct = true;
				check = true;
				repeat = 0;
				return list;
				//break;
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
				return null;
			}
	
	public void MaintainMembership(Member person){
		
		MembershipEdit m = new MembershipEdit();
	
		boolean done=false;
		 boolean finish1=false;
	    while(!done)
	    {
	    	System.out.println("Select the memu\n1.View Account\n2.Edit account\n3.Edit ride schedule\n4.Log out");
			Scanner scan3 = new Scanner(System.in);
			int menu = scan3.nextInt();
			if(menu == 1){
				m.viewInfo(person);
			}
			if(menu == 2){
				boolean repeat = false;
				
					if(person.getStatus() == 1 || person.getStatus() == 3){
						while(!repeat){
							System.out.println("Select the item\n1.user name\n2.password\n3.member type\n4.Email"
							   + "\n5.Car type\n6.Registration number\n7.riding number\n8.Go back\n");
							int d_change = scan3.nextInt();
							switch(d_change){
							case 1:
								m.editUserName(person);
								break;
							case 2:
								m.editPassword(person);
								break;
							case 3:
								m.editStatus(person);
								break;
							case 4:
								m.editEmail(person);
								break;
							case 5:
								m.editCarType(person);
								break;
							case 6:
								m.editRegistrationNumber(person);
								break;
							case 7:
								m.editRidingNumber(person);
								break;
							case 8:
								break;
							}//end of switch statement	
								System.out.println("Would you like to continue to edit your info?\n1.Yes\n2.No\n");
									int go_back = scan3.nextInt();
									if(go_back == 1){
										repeat = false;
									}
									if(go_back == 2){
										repeat = true;
									}
						//end of while loop
						}
					}//end of editing driver and both
				else{
					boolean repeat2 = false;
					while(!repeat2){
						System.out.println("Select the item\n1.user name\n2.password"
										+"\n3.member type\n4.Email\n5.Go back\n");
						
						int d_change = scan3.nextInt();
						switch(d_change){
						case 1:
							m.editUserName(person);
							break;
						case 2:
							m.editPassword(person);
							break;
						case 3:
							m.editStatus(person);
							break;
						case 4:
							m.editEmail(person);
							break;
						case 5:
							break;
						}// end of switch statement
							System.out.println("Would you like to continue to edit your info?\n1.Yes\n2.No\n");
							int go_back = scan3.nextInt();
							if(go_back == 1){
								repeat2 = false;
							}
							if(go_back == 2){
								repeat2 = true;
							}
					}//end of repeat2
				}
				}//end of menu 2
			if(menu == 3){
				//.......
			}
			if(menu ==4)
			{
				done=true;
			}
	    }
	}
}//end of class clause		

