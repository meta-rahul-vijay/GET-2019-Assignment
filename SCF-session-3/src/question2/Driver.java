package question2;

public class Driver {

	public static void main(String[] args) {
		
		MarkSheet m=new MarkSheet();
		m.input();
		System.out.println("Average of grades : "+m.averageOfGrades());
		System.out.println("Maximum of grades : "+m.maxOfGrades());
		System.out.println("Minimum of grades : "+m.minOfGrades());
		System.out.println("Percentage of students passes : "+m.passPercentage());
	}

}
