package question1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args){
		Scanner inputObj = new Scanner(System.in);
		int left,right,rotateNumber;
		String wantMoreValues="";
		LinkedList list = new LinkedList();
		int choice = 0;
		do{
			System.out.println("Please Enter Your Choice\n1.Add Element in List\n2.Rotate Sub List In List\n3.Display List\n4.add loop in list\n5.detect loop\n6.Exit");
				choice = inputObj.nextInt();
				label:
				switch(choice){
				case 1:
					do{
					System.out.println("Please enter Element Data : ");
					int data = inputObj.nextInt();
					list.addNodeToList(data);
					System.out.println("do you want enter more data [yes/no] : ");
					wantMoreValues=inputObj.next();
					}while("yes".equals(wantMoreValues));
						break;
				case 2:	
					System.out.println("Please enter the left index : ");
					left = inputObj.nextInt();
					System.out.println("Please enter the right index : ");
					right = inputObj.nextInt();
					System.out.println("Please enter the number of rotations : ");
					rotateNumber= inputObj.nextInt();
					list.rotateList(left, right, rotateNumber);
					break;
				case 3:
					System.out.println("--------------------------------------------------------------------------");
					list.printList();
					System.out.println("--------------------------------------------------------------------------");
					break;
				case 4:
					System.out.println("Please enter position at which you want a loop : ");
					int position = inputObj.nextInt();
					list.addLoop(position);
					break;
				case 5:
					boolean hasLoop=list.checkLoop();
					System.out.println(hasLoop);
					break;
				case 6 :
					System.exit(0);
				default:
						System.out.println("Invalid Choice.. pls try again..");
					
				}
		}while(choice!=7);

	}

}
