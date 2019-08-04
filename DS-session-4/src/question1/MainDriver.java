package question1;
import java.util.*;
public class MainDriver {

	public static void main(String[] args) {
		Scanner inputObj = new Scanner(System.in);
		EmployeeCollection employee=new EmployeeCollection();
		int empId;
		String name,address;
		boolean add;
		int choice = 0;
		do{
			System.out.println("1.Add employee\n2.Sort by ID\n3.Sort by name\n4.Display employee list\n5.Exit");
			String more="";
			try{
				choice = inputObj.nextInt();
				System.out.println("-------------------------------------------------------------------------------");
				switch(choice){
				case 1:
					do{
						System.out.println("Enter Employee ID :");
						empId=inputObj.nextInt();
						System.out.println("Enter Employee name :");
						name=inputObj.next();
						System.out.println("Enter Employee address :");
						address=inputObj.next();
						add=employee.addEmployee(empId, name, address);
						if(add==false){
							System.out.println("Employee ID exists already , try again");
							break;
						}
						System.out.println("do you want to enqueue more ? [yes/no]");
						more=inputObj.next();
					}while("yes".equals(more));
					break;
				case 2:
					employee.sortEId();
					System.out.println("Sorted by ID successfully");
					break;
				case 3:
					employee.sortEName();
					System.out.println("Sorted by name successfully");
					break;
				case 4:
					List<Employee> empoyeeList=employee.getEmployee();
					System.out.println("Employee ID\tEmployee Name\tEmployee address");
					for(int i=0;i<empoyeeList.size();i++) {
						System.out.println(empoyeeList.get(i).getEmpId()+"\t\t"+empoyeeList.get(i).getName()+"\t\t"+empoyeeList.get(i).getAddress());
					}
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice");
				}
				System.out.println("-------------------------------------------------------------------------------");
			}catch(InputMismatchException e){
				
				System.out.println("Warning : Please enter correct type !! Try Again");
				System.out.println("-------------------------------------------------------------------------------");
				inputObj.nextLine();
			}
		}while(true);


	}

}
