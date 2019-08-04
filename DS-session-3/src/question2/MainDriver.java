package question2;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is main class for Priority Queue operations
 * @author Mahendar Singh
 * Dated  08/02/2019
 */
public class MainDriver {
	
	public static void main(String[] args){
		
		Scanner inputObj = new Scanner(System.in);
		PriorityQueue queueObj = null;
		try{
			System.out.println("Please Enter the Size of Priority Queue :");
			int size = inputObj.nextInt();
			if(size < 1){
				System.out.println("Please Enter at least size 1 !! Try again");
				main(args);
			}
			queueObj = new ArrayPriorityQueue(size);
		}catch(InputMismatchException e){
			
			System.out.println("Warning : Please enter only integer value !! Try Again");
			inputObj.nextLine();
			main(args);
		}
		int choice = 0;
		do{
			System.out.println("1.Enter Priority In Queue\n2.delete Element from Queue\n3.Most Priority Value\n4.Size of Queue\n5.display Priority Queue\n6.Exit");
			String more="";
			try{
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					do{
						System.out.println("Enter data :");
						queueObj.enQueue(inputObj.nextInt());
						System.out.println("do you want to enqueue more ? [yes/no]");
						more=inputObj.next();
					}while("yes".equals(more));
					
					break;
				case 2:
					if(queueObj.isEmpty()){
						System.out.println("Queue is already Empty");
					}else{
						System.out.println("" + queueObj.deQueue() + " successfully removed");
					}
					break;
				case 3:
					if(queueObj.isEmpty()){
						System.out.println("Queue is Empty");
					}else{
						System.out.println("first element :" + queueObj.firstElement());
					}
					break;
				case 4:
					
					System.out.println("Queue size : " + queueObj.queueSize());
					break;
				case 5:
					if(queueObj.isEmpty()){
						System.out.println("Your Output : Queue is Empty");
					}else{
						System.out.println("Priority queue : ");
						queueObj.displayQueue();
					}
					break;
				case 6:
					break;
					default:
						System.out.println("Invalid Choice");
				}
			}catch(InputMismatchException e){
				System.out.println("Warning : Please enter only integer value !! Try Again");
				inputObj.nextLine();
			}
		}while(choice!=6);
		
		System.out.println("Program Terminated");

	}

}
