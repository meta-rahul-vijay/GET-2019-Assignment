package question3;
/**
 * objects of this class stores result of allocation of programs
 * @author Mahendar Singh
 * Dated 08/01/2019
 */
public class CounsellingResult {

	String studentName;
	String allocatedBranch;

	/**
	 * constructor for CounsellingResult
	 * @param studentName is the name of student
	 * @param allocatedBranch is the allocated branch
	 */
	CounsellingResult(String studentName, String allocatedBranch) {
		this.studentName = studentName;
		this.allocatedBranch = allocatedBranch;
	}

}
