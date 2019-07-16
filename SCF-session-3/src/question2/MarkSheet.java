package question2;
import java.util.*;
public class MarkSheet {
	Scanner in=new Scanner(System.in);
	private int numberOfStudents;
	double gradeArray[];
	
	/**
	 * taking input in MarkSheet object
	 */
	void input() {
		double grad;
		System.out.println("Enter number of students : ");
		numberOfStudents=in.nextInt();
		gradeArray=new double[numberOfStudents];
		again :
		for(int i=0;i<numberOfStudents;i++) {
			
			System.out.println("Enter grade for "+(i+1)+" student ");
			grad=in.nextDouble();
			if(grad>=0&&grad<=100)
				gradeArray[i]=Math.round(grad * 100.0) / 100.0;    //for rounding off up to 2 decimal point
			else {
				System.out.println("grade out of limit.. try again");
				i--;
				continue again;
			}
		}
	}
	/**
	 * find the average of grades of n students
	 * @return average of grades
	 */
	double averageOfGrades() {
		
		double sum=0;
		double avg=0;
		for(int i=0;i<numberOfStudents;i++) {
			sum+=gradeArray[i];
		}
		avg=sum/numberOfStudents;
		return Math.round(avg * 100.0) / 100.0;    //for rounding off up to 2 decimal point
	}
	
	/**
	 * find the maximum value in grades of n students
	 * @return maximum value in grades
	 */
	double maxOfGrades() {
		
		double max=0;
		for(int i=0;i<numberOfStudents;i++) {
			if(max<gradeArray[i])
				max=gradeArray[i];
		}
		return max;
	}
	
	/**
	 * find the minimum value in grades of n students
	 * @return minimum value in grades
	 */
	double minOfGrades() {
		
		double min=100;
		for(int i=0;i<numberOfStudents;i++) {
			if(min>gradeArray[i])
				min=gradeArray[i];
		}
		return min;
	}
	
	/**
	 * find the percentage of passing students
	 * @return percentage of student passed
	 */
	double passPercentage() {
		
		double passPercentage=0;
		int count=0;
		for(int i=0;i<numberOfStudents;i++) {
			if(gradeArray[i]>40)
				count++;
		}
		passPercentage=(count*100)/numberOfStudents;
		return Math.round(passPercentage * 100.0) / 100.0;     //for rounding off up to 2 decimal point
	}


}
