package question3;

import java.util.Queue;

/**
 * This is the main class
 * @author Mahendar Singh
 * Dated 08/01/2019
 */

public class MainDriver {

	public static void main(String[] args) {
		FileOperation operation = new FileOperation();
		AllocateBranch allocate = new AllocateBranch();
		Queue<StudentList> studentQueue = null;
		try {
			studentQueue = operation.studentFileRead("StudentList.xls");
			operation.programFileRead("StudentList.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Queue<CounsellingResult> resultQueue = allocate.allocateBranch(studentQueue);
		
		operation.makeExcelSheet(resultQueue);
		System.out.println("Excel sheet created successfully..");
//		for (int i = 0; resultQueue.size() != 0; i++) {
//			System.out.println(resultQueue.peek().studentName + " "+ resultQueue.peek().allocatedBranch);
//			resultQueue.remove();
//			
//		}

	}

}
