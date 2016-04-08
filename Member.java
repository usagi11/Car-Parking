import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable{

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int id;
	private String email;
	private int status;
	private Vehicle vehicle;
	private String v_model;
	private String v_register;
	private int numberOfPassenger;
	//private MemberSchedule schedule;
	
	//default constructor
	public Member(){};

	
	//passenger 
	public Member(String firstName, String lastName, String userName, String password, int id, String email, int status){
		this.firstName = firstName;
		this.lastName= lastName;
		this.userName = userName;
		this.password = password;
		this.id = id;
		this.email = email;
		this.status = status;
	}
	//driver or both
	public Member(String firstName, String lastName, String userName, String password, int id, String email,int status, Vehicle vehicle){
		this(firstName, lastName, userName, password, id, email, status);
		this.vehicle = vehicle;

	}

	public Member(String userName, String password){
		this.userName = userName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getV_model() {
		return v_model;
	}


	public void setV_model(String v_model) {
		this.v_model = v_model;
	}


	public String getV_register() {
		return v_register;
	}


	public void setV_register(String v_register) {
		this.v_register = v_register;
	}


	public int getNumberOfPassenger() {
		return numberOfPassenger;
	}


	public void setNumberOfPassenger(int numberOfPassenger) {
		this.numberOfPassenger = numberOfPassenger;
	}
	public boolean contains(Member list) {
		Member other = (Member) list;
		if(this.userName.equals(other.userName)
				&& this.password.equals(other.password)){
			return true;
		}else
		return false;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	 public int checkStatus()
	 {
		 return status;
	 }
	 public void changeStatus(int n)
	 {
		 this.status=n;
	 }

	public String toString(){
		if(getStatus() == 1){
			return "=========Personal info======================" +
					"\nName: " + getFirstName() + " " + getLastName() + "\n" + "User name: " + getUserName() +
					 "\n" + "SJSU ID: " + getId() + "\n" + "Email: " + getEmail() + "\n" +
					 "========Car info======================" +
					 "\nVehicle model: " + vehicle.getCarModel() + "\n" + "Regstration number: " + vehicle.getCarPlate() + 
					 "\n" + "Number of Passengers which you can take \n" + vehicle.getNumberOfPassenger()+ " people\n";
		}
		if(getStatus() == 2){
			return "=========Personal info======================" +
					"\nName: " + getFirstName() + " " + getLastName() + "\n" + "User name: " + getUserName() +
					 "\n" + "SJSU ID: " + getId() + "\n" + "Email: " + getEmail()+ "\n";
		}
		if(getStatus() == 3){
			return "=========Personal info======================" +
					"\nName: " + getFirstName() + " " + getLastName() + "\n" + "User name: " + getUserName() +
					 "\n" + "SJSU ID: " + getId() + "\n" + "Email: " + getEmail() + "\n" +
					 "========Car info======================" +
					 "Vehicle model: " + vehicle.getCarModel() + "\n" + "Regstration number: " + vehicle.getCarPlate() + "\n" + "Number of Passengers which you can take \n" +
					 vehicle.getNumberOfPassenger()+ " people\n";
		}

		return null;
	}

}
