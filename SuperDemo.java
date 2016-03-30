import java.io.*;
import java.util.*;

public class SuperDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		/*try{
			ObjectInputStream os = new ObjectInputStream(new FileInputStream("test.ser"));
		*/
		//ArrayList<Member> memberlist = (ArrayList<Member>)os.readObject();
		//os.close();
		ArrayList<Member> memberlist = new ArrayList<Member>();
		MembershipDemo member = new MembershipDemo();
		Scanner scan = new Scanner(System.in);
		boolean check = false;
		
		
		System.out.println("1.Sign up\n2.Log in");
		int choice = scan.nextInt();
		while(!check){
			if(choice == 1){
				System.out.println("Please enter member type\n1.Driver\n2.Passenger\n3.Both");
				int status = scan.nextInt();
				if(status == 1){
					Member driver = member.driver();
					memberlist.add(driver);
				}
				if(status == 2){
					Member passenger = member.passenger();
					memberlist.add(passenger);
				}
				if(status == 3){
					Member both = member.both();
					memberlist.add(both);
				}
				System.out.println("Enter 1 to continue");
				int count = scan.nextInt();
				if(count == 1){
					check = false;
				}
				else{
					check = true;
				}
			}
			FileOutputStream fs = new FileOutputStream("test.ser");
			ObjectOutputStream os2 = new ObjectOutputStream(fs);
			os2.writeObject(memberlist);
			
			check = true;
			System.out.println(memberlist);
			os2.close();
		}
			if(choice == 2){
				boolean ans = false;
				while(!ans){
					System.out.println("Enter your user name");
					Scanner scan2 = new Scanner(System.in);
					String name = scan2.next();
					System.out.println("Password");
					String pass = scan2.next();
					Member checklist = new Member(name, pass);
					boolean correct = false;
					int repeat = 0;
					while(!correct){
						for(Member list : memberlist){
							if(checklist.contains(list)){
								System.out.println("Successfuly logged in\nYour info is: ");
								System.out.println(memberlist);
								correct = true;
								ans = true;
								repeat = 0;
							}
							else if(!checklist.contains(list)){
								correct = true;
								ans = false;
								repeat = 1;
							}
						}
						if(repeat == 1){
							System.out.println("Wrong user name or password:");
						}
					}
				}
			}/*
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
