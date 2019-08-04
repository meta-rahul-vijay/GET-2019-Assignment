package question1;

/**
 * This class defines employee structure.
 * @author Mahendar Singh Dated 08/03/2019
 */
public class Employee {

	private int empId;
	private String name;
	private String address;

	public Employee(int empId, String name, String address) throws AssertionError {
		assert (empId >= 1) : "Employee id shoud be greater than 1";
		if (name.equals(null) || name.trim().equals(""))
			throw new AssertionError("Employee name is wrong");
		if (address.equals(null) || address.trim().equals(""))
			throw new AssertionError("Employee address is wrong");
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	/**
	 * 
	 * @return employee id.
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * 
	 * @return employee name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return employee address.
	 */
	public String getAddress() {
		return address;
	}

}
