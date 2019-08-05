package question3;

import java.util.*;
/**
 * this class implements list of students
 * @author Mahendar Singh
 * Dated 08/01/2019
 */
public class StudentList {

	String studentName;
	String preference[] = new String[5];

	/**
	 * constructor for StudentList
	 * @param parameters contains the name and preferences of student
	 */
	StudentList(ArrayList<String> parameters) {
		this.studentName = parameters.get(0);
		this.preference[0] = parameters.get(1);
		this.preference[1] = parameters.get(2);
		this.preference[2] = parameters.get(3);
		this.preference[3] = parameters.get(4);
		this.preference[4] = parameters.get(5);
	}
}
