package question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class creates collection of employee data structure.
 * @author Mahendar Singh
 * Dated 08/03/2019
 */
public class EmployeeCollection {

	private List<Employee> employee = new ArrayList<Employee>();
	
	private Map<Integer, Employee> employeeMap = new TreeMap<Integer, Employee>();
	
	/**
	 * This function add employees to collection.
	 * @param empId
	 * @param name
	 * @param address
	 * @return true if employee is added else false.
	 * @throws CustomException
	 */
	public boolean addEmployee(int empId, String name, String address) throws AssertionError {
		boolean flag = false;
		if(!employeeMap.containsKey(empId)) {
		    employee.add(new Employee(empId, name, address));
			employeeMap.put(empId, new Employee(empId, name, address));
			flag = true;
		}
		return flag;
	}

	/**
	 * 
	 * @return collection of employee data.
	 */
	public List<Employee> getEmployee() {
		return employee;
	}
	
	/**
	 * Sorts data by EmpId.
	 */
	public void sortEId() {	    
		Collections.sort(employee, EmployeeSorter.sortByEId);
	}
	
	/**
	 * sorts data by EmpName.
	 */
	public void sortEName() {
		Collections.sort(employee, EmployeeSorter.sortByEname);
	}
	
	
	
}
