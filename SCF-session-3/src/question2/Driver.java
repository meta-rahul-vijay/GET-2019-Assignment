package question2;

public class Driver {

	public static void main(String[] args) {
		
		MarkSheet marksheetObject=new MarkSheet();
		marksheetObject.input();
		System.out.println("Average of grades : "+marksheetObject.averageOfGrades());
		System.out.println("Maximum of grades : "+marksheetObject.maxOfGrades());
		System.out.println("Minimum of grades : "+marksheetObject.minOfGrades());
		System.out.println("Percentage of students passes : "+marksheetObject.passPercentage());
	}

}
