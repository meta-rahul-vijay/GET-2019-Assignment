package question2;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains main 
 * @author Mahendar Singh
 * Dated 08/07/2019
 */
public class MainDriver {
	public static void main(String[] args) {

		Scanner inputObj = new Scanner(System.in);
		EmployeeList listObj = new EmployeeList();

		String moreInput="";
		int choice = 0;
		do{
			System.out.println("Enter Your Choice\n1.Add an Employee\n2.Sort\n3.Display Employee List\n4.Display sorted List\n5.Exit");
			try{
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					do{
						inputObj.nextLine();
						System.out.println("Enter Employee Name :");
						String name = inputObj.nextLine();
						System.out.println("Enter Employee Age");
						int age = inputObj.nextInt();
						System.out.println("Enter Employee Salary :");
						double salary = inputObj.nextDouble();
						listObj.addEmployee(name, age, salary);
						System.out.println("Employee " + name + " added in the list\n");
						System.out.println("Do you want to enter more [yes/no]");
						moreInput=inputObj.next();
					}while(moreInput.equals("yes"));
					break;
				case 2:
					listObj.sortedLinkedListHead=null;
					listObj.sortEmployeeList();
					System.out.println("List Sorted successfully \n");
					break;
				case 3:
					Employee temp=listObj.linkedListHead;
					System.out.println("Employee Name\tEmployee Age\tEmployee Salary");
					while(temp!=null){
						System.out.println(temp.employeeName+"\t"+temp.employeeAge+"\t"+temp.employeeSalary);
						temp=temp.next;
					}
					break;
				case 4:
					Employee tempSorted=listObj.sortedLinkedListHead;
					System.out.println("Employee Name\tEmployee Age\tEmployee Salary");
					while(tempSorted!=null){
						System.out.println(tempSorted.employeeName+"\t"+tempSorted.employeeAge+"\t"+tempSorted.employeeSalary);
						tempSorted=tempSorted.next;
					}
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("\nInvalid Choice  !! Try Again\n");
				}
				inputObj.nextLine();
			}catch(InputMismatchException exception){
				System.out.println("\nWarning , Please Enter only correct data Value \n");
				inputObj.nextLine();
			}
		}while(true);
	}



}
