package notification2;
import java.util.ArrayList;
import java.util.Iterator;


public abstract class MessageController {
	public ArrayList observers = new ArrayList();
	public void addObserver(Observer observer){
		observers.add(observer);
	}
	public void removeObserver(Observer observer){
		observers.remove(observer);
	}
	public void notifyObservers(){
		Iterator it = observers.iterator();
		while(it.hasNext()){
			Observer o = (Observer) it.next();
			o.update(this);
		}
	}
	public abstract String getMessage();
	public abstract void execute();
	
	
	

	
	
}
