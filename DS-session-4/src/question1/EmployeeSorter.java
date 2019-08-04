package question1;

import java.util.Comparator;

/**
 * This class override Compartor to sort employee collection.
 * @author Mahendar Singh
 * Dated 08/03/2019
 */
public class EmployeeSorter {

	/**
	 * Sorts employee list by eId
	 */
	public static Comparator<Employee> sortByEId = new Comparator<Employee>() {
		public int compare(Employee emp1, Employee emp2) {

			return (emp1.getEmpId() < emp2.getEmpId()) ? -1 :                     
	              (emp1.getEmpId() == emp2.getEmpId() ? 0 : 1);      
		}
	};
	
	/**
	 * Sorts employee list by eName
	 */
	public static Comparator<Employee> sortByEname = new Comparator<Employee>() {
		public int compare(Employee emp1, Employee emp2) {

			return emp1.getName().compareToIgnoreCase(emp2.getName());    
		}
	};
	
}