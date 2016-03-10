package cp;





import java.util.Scanner;
import java.io.*;

/**
 * @author lauren
 *
 */
public class Membership
{
	private Member member;
	private MemberType memberType;
	public Member driverSignup()
	{
		  System.out.println("First name: ");
		  Scanner inFN=new Scanner(System.in);
		  String fname=inFN.next();
		  System.out.println("Last name: ");
		  Scanner inLN=new Scanner(System.in);
		  String lname=inLN.next();
		  System.out.println("User name: ");
		  Scanner uN = new Scanner(System.in);
		  String un = uN.next();
		  System.out.println("Email: ");
		  Scanner inEmail=new Scanner(System.in);
		  String email=inEmail.next();
		  System.out.println("Password: ");
		  Scanner pass=new Scanner(System.in);
		  String pw=pass.next();
		  System.out.println("SJSU ID: ");
		  Scanner inID=new Scanner(System.in);
		  String id=inID.next();
		  System.out.println("address: ");
		  Scanner inAddr=new Scanner(System.in);
		  String addr=inID.next();
		  Member driver=new Member(fname,lname,un, email,pw,id,memberType.Driver);//0 represents driver status;
		  System.out.println("Following info is correct?");
		  System.out.println("First Name: " + fname + " Last Name: " + lname + " User Name: " + un
					 + " email: " + email + " Address: " + addr + " Password: " + pw 
					 + " SJSU ID: " + id);
		  member=driver;
		  return driver;
	}
	public Member passengerSignup()
	{
		  System.out.println("First name: ");
		  Scanner inFN=new Scanner(System.in);
		  String fname=inFN.next();
		  System.out.println("Last name: ");
		  Scanner inLN=new Scanner(System.in);
		  String lname=inLN.next();
		  Scanner uN = new Scanner(System.in);
		  System.out.println("User name: ");
		  String un = uN.next();
		  System.out.println("Email: ");
		  Scanner inEmail=new Scanner(System.in);
		  String email=inEmail.next();
		  System.out.println("Password: ");
		  Scanner pass=new Scanner(System.in);
		  String pw=pass.next();
		  System.out.println("SJSU ID: ");
		  Scanner inID=new Scanner(System.in);
		  String id=inID.next();
		  System.out.println("address: ");
		  Scanner inAddr=new Scanner(System.in);
		  String addr=inID.next();
		  Member passenger=new Member(fname,lname,un,email,pw,id, memberType.Passenger);//1 represents Passenger status;
		  member=passenger;
		  return passenger;
	}
	public String viewMembership(Member m)
	{
		String fname=m.getFirstName();
		String lname=m.getLastName();
		String email=m.getEmail();
		String id=m.getsjsuID();
		return "name:  "+fname+" "+lname+"\n"+"Email:  "+email+"\n"+"SJSU ID:  "+id+"\n";
	}
	public void editMembership(Member m) throws IOException
	{
		boolean finish=false;
     	while(!finish)
     	{
     		System.out.println("Choose one to edit: [E]mail, [P]assword, [G]o back");
		  	Scanner command=new Scanner(System.in);
		  	String cmd=command.next();
		  	if(cmd.toUpperCase().equals("E")) 
	 		  {
		  		System.out.println("Type in new email: ");
		  		Scanner in=new Scanner(System.in);
				String email=in.next();
				m.setEmailAddress(email);
	 		  }
		  	if(cmd.toUpperCase().equals("P")) 
	 		  {
		  		System.out.println("Type in new Password: ");
		  		Scanner in=new Scanner(System.in);
				String password=in.next();
				m.setPassword(password);
	 		  }
		  	if(cmd.toUpperCase().equals("G")) 
	 		  {
		  		 finish=true;
	 		  }
     	}
	}
	public Member login(String un, String password) throws FileNotFoundException
	{
		Scanner txtscan = new Scanner(new File("database.txt"));
		String fn="";
    	String ln="";
    	String email="";
    	String sjsuid="";
    	String memType="";
    	String pickuplocation="";
    	String arrivetime="";
    	String departuretime="";
		while(txtscan.hasNextLine()){
		    String str = txtscan.nextLine();
		    if(str.indexOf(un) != -1){
		        String pw=txtscan.nextLine();
		        if(pw.indexOf(password)!= -1)
		        {
		        	fn=txtscan.nextLine();
		        	ln=txtscan.nextLine();
		        	email=txtscan.nextLine();
		        	sjsuid=txtscan.nextLine();
		        	memType=txtscan.nextLine();
		        	//address=txtscan.nextLine();
		        	pickuplocation=txtscan.nextLine();
		        	arrivetime=txtscan.nextLine();
		        	departuretime=txtscan.nextLine();
		        }
		        else
		        {
		        	System.out.println("Password Incorrect!");
		        }
		        
		    }
		}
	    
	    
			Member member=new Member(fn, ln, un,
		            email, password, sjsuid, memberType.Passenger);
	  
		
		
	    
		return member;
	}
	public void quitTheSystemAfterSignUp(String filename) throws FileNotFoundException
	{
		 PrintWriter out=new PrintWriter(filename);
		 String username=member.getusername();
		 out.println(username);
		 String pw=member.getPassword();
		 out.println(pw);
		 String fn=member.getFirstName();
		 out.println(fn);
		 String ln=member.getLastName();
		 out.println(ln);
		 String email=member.getEmail();
		 out.println(email);
		 String ID=member.getsjsuID();
		 out.println(ID);
		 if(memberType.Passenger != null)
		 {
			 out.println("passenger");
		 }
		 else if(memberType.Driver !=null)
		 {
			 out.println("driver");
		 }
		// String address=member.getAddress();
		// out.println(address);
		 String pickuplocation=member.getMemberschedule().getPickUpLocation().toString();
		 out.println(pickuplocation);
		 String arrivaltime=member.getMemberschedule().getArrivalTime().toString();
		 out.println(arrivaltime);
		 String departuretime=member.getMemberschedule().getDepartureTime().toString();
		 out.println(departuretime);
		
		 
		 out.close();
		 
	}
}
	
