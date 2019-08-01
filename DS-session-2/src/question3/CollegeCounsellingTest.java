package question3;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.*;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Test class to test the allocation of program to the students
 * @author Mahendar Singh
 * Dated 08/01/2019
 */
public class CollegeCounsellingTest {

	Queue<CounsellingResult> allocationList = new LinkedList<>();

	/**
	 * This method gets the data from the AllocationList sheet and generates the allocation list before every test runs
	 */
	@Before
	public void generateAllocatedList() {
		int row;
		try {
			String[] prefrences = new String[5];
			Workbook workbook = Workbook.getWorkbook(new java.io.File("AllocationList.xls"));
			Sheet sheet = workbook.getSheet(0);
			String studentName;
			String allocatedCourse ;
			for (row = 0; row < sheet.getRows(); row++) 
			{
					Cell cell = sheet.getCell(0, row);
					studentName = cell.getContents();
					cell = sheet.getCell(1, row);
					allocatedCourse = cell.getContents();
					
					allocationList.add(new CounsellingResult(studentName,allocatedCourse));
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testAllocation1() throws Exception
	{
		FileOperation obj = new FileOperation();
		
		Queue<StudentList> queue = obj.studentFileRead("StudentList.xls");
		//obj.makeExcelSheet(queue);
		generateAllocatedList();
		String studentName = allocationList.peek().studentName;
		String allocatedProgram = allocationList.peek().allocatedBranch;
		
		assertEquals("Ajay", studentName);
		assertEquals("CSE", allocatedProgram);
		allocationList.remove();
		
		studentName = allocationList.peek().studentName;
		allocatedProgram = allocationList.peek().allocatedBranch;
		
		assertEquals("Anmol", studentName);
		assertEquals("Mechanical", allocatedProgram);
	}
	
	
}