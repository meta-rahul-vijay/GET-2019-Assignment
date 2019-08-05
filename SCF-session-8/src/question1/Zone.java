package question1;
import java.util.*;
/**
 * class Zone containing the details of a Zone
 * @author Mahendar
 *
 */
public class Zone {
	
	String category;
	int noOfCages;
	boolean park;
	boolean canteen;
	ArrayList<Cage> cages;
	
	Zone(String category,int noOfCages,String park,String canteen){
		
		cages=new ArrayList<Cage>();
		
		this.category=category;
		this.noOfCages=noOfCages;
		if(park.equals("yes"))
		this.park=true;
		else 
			this.park=false;
		
		if(canteen.equals("yes"))
		this.canteen=true;
		else
			this.canteen=false;
		
		
	}
	
	/**
	 * @return if zone has a park
	 */
	boolean hasPark(){
		return park;
	}
	
	/**
	 * @return if zone has a canteen
	 */
	boolean hasCanteen(){
		return canteen;
	}

}
