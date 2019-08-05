package question1;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * This class checks employee collection.
 * @author mahendar Jain
 * Dated 08/03/2019
 */
public class EmployeeCollectionTest {

	EmployeeCollection employeeData = new EmployeeCollection();
	
	/**
	 * check employee addition test with same and different EIds.
	 * @throws CustomException
	 */

	@Test
	public void addEmployeeTest() {
		
		assertTrue(employeeData.addEmployee(3, "aman", "ajmer"));
		assertTrue(employeeData.addEmployee(1, "mahendar", "udaipur"));
		assertTrue(employeeData.addEmployee(2, "rahul", "jaipur"));
		
		assertFalse(employeeData.addEmployee(1, "anmol", "mumbai"));
		
		assertTrue(employeeData.addEmployee(5, "rivak", "jaipur"));
		assertTrue(employeeData.addEmployee(4, "abhishek", "gwalior"));
		
	}
	
	/**
	 * check sort by Employee Id
	 */
	@Test
	public void sortByEIdTest() {
		
		employeeData.sortEId();
		
		EmployeeCollection eIdSorted = new EmployeeCollection();
			
		eIdSorted.addEmployee(1, "mahendar", "udaipur");
		eIdSorted.addEmployee(2, "rahul", "jaipur");
		eIdSorted.addEmployee(3, "aman", "ajmer");
		eIdSorted.addEmployee(4, "abhishek", "gwalior");
		eIdSorted.addEmployee(5, "rivak", "jaipur");	
			
		for(int i = 0, dataLength = employeeData.getEmployee().size(); i < dataLength; i++) {
			assertEquals(eIdSorted.getEmployee().get(i).getEmpId(), employeeData.getEmployee().get(i).getEmpId());
			assertEquals(eIdSorted.getEmployee().get(i).getName(), employeeData.getEmployee().get(i).getName());
			assertEquals(eIdSorted.getEmployee().get(i).getAddress(), employeeData.getEmployee().get(i).getAddress());
		}
		
	}
	
	/**
	 * check sort by Employee name
	 */
	@Test
	public void sortByEName() {
		
		employeeData.sortEName();
		
		EmployeeCollection nameSorted = new EmployeeCollection();
		
		nameSorted.addEmployee(4, "abhishek", "gwalior");
		nameSorted.addEmployee(3, "aman", "ajmer");
		nameSorted.addEmployee(1, "mahendar", "udaipur");
		nameSorted.addEmployee(2, "rahul", "jaipur");
		nameSorted.addEmployee(5, "rivak", "jaipur");	

		for(int i = 0, dataLength = employeeData.getEmployee().size(); i < dataLength; i++) {
			assertEquals(nameSorted.getEmployee().get(i).getEmpId(), employeeData.getEmployee().get(i).getEmpId());
			assertEquals(nameSorted.getEmployee().get(i).getName(), employeeData.getEmployee().get(i).getName());
			assertEquals(nameSorted.getEmployee().get(i).getAddress(), employeeData.getEmployee().get(i).getAddress());
		}
		
	}
	
	
	
	/**
	 * check for error when empId is less than 1.
	 */
	@Test(expected=AssertionError.class)
	public void WrongEmpIdTest() {
			employeeData.addEmployee(0, "aman", "ajmer");
			employeeData.addEmployee(-5, "aman", "ajmer");	
	}
	
	/**
	 * check for error when empName is less wrong.
	 */
	@Test(expected=AssertionError.class)
	public void WrongEmpNameTest() {

			employeeData.addEmployee(1, "   ", "ajmer");

			employeeData.addEmployee(1, null, "ajmer");
	}
	
	/**
	 * check for error when empAddress is less wrong.
	 */
	@Test(expected=AssertionError.class)
	public void WrongEmpAddressTest() {
	
			employeeData.addEmployee(1, "aman", "  ");
			
			employeeData.addEmployee(1, "aman", null);
		
	}

}