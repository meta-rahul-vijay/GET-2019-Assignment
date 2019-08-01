package question3;
import java.util.*;
/**
 * This class contains method to allocate a program to student
 * @author Mahendar Singh
 * Dated 08/01/2019
 */
public class AllocateBranch {

	/**
	 * method to allocate program to students
	 * @param studentQueue is the queue of students along with preference
	 * @return {Queue} student and their allocated programs
	 */
	public Queue<CounsellingResult> allocateBranch(Queue<StudentList> studentQueue) {

		Queue<CounsellingResult> resultList = new LinkedList<>();
		String studentName, branch;
		for (int i = 0; studentQueue.size() != 1; i++) {
            studentName = studentQueue.peek().studentName;
			for (int j = 0; j < 5; j++) {
				branch = studentQueue.peek().preference[j];
				if (FileOperation.programs.get(branch) > 0) {
					resultList.add(new CounsellingResult(studentName, branch));
					FileOperation.programs.put(branch,FileOperation.programs.get(branch) - 1);
					break;
				} else
					continue;
			}
			studentQueue.remove();
		}
		return resultList;
	}

}
