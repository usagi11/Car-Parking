import java.io.Serializable;

public class Vehicle implements Serializable

{
	private static final long serialVersionUID = 1L;
    private String CarModel;
    private String CarPlate;
    private int numberOfPassenger;
    //private RidingState state;
    
    public Vehicle(){
    	//state = null;
    }

    public Vehicle(String cm, String cp, int num)
    {
    	CarModel=cm;
    	CarPlate=cp;
    	numberOfPassenger=num;
    }
    public void setCarModel(String cm)
    {
    	CarModel=cm;
    }
    public String getCarModel()
    {
    	return CarModel;
    }
    public void setCarPlate(String cp)
    {
    	CarPlate=cp;
    }
    public String getCarPlate()
    {
    	return CarPlate;
    }
    public void setNumberOfPassenger(int n)
    {
    	numberOfPassenger=n;
    }
    public int getNumberOfPassenger()
    {
    	return numberOfPassenger;
    }
    /*
    public void setState(RidingState s)
    {
    	state=s;
    }
    public RidingState getState()
    {
    	return state;
    }
    */
	
}