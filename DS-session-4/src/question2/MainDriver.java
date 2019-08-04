package question2;
import java.util.*;
public class MainDriver {

	public static void main(String[] args) {
	
		Scanner inputObj=new  Scanner(System.in);
		ComputeUnique compute=new ComputeUnique();
		String inputString;
		System.out.println("Enter the string : ");
		inputString=inputObj.nextLine();
		int uniqueChar=compute.computeUnique(inputString);
		System.out.println("Number of unique characters : "+uniqueChar);
	}

}
