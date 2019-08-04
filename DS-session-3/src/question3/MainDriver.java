package question3;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is main class for Priority Queue operations
 * @author Mahendar Singh
 * Dated 08/02/2019
 */
public class MainDriver {
	
	public static void main(String[] args){
		
		Scanner inputObj = new Scanner(System.in);
		PriorityQueue queueObj = null;
		try{
			System.out.println("Enter total balls virat will play");
			int totalPlayBalls = inputObj.nextInt();
			
			System.out.println("Enter total number of bowlers");
			int totalBowler = inputObj.nextInt();
			do{
				queueObj = new PlayerQueue(totalBowler);
				int totalBowlerBalls = 0;
				for(int bowler = 1 ; bowler<=totalBowler; ){
					String name;
					int ball;
					try{
						System.out.println("Enter Bowler[" + bowler + "] Name :");
						inputObj.nextLine();
						name = inputObj.nextLine();
						System.out.println("Enter Balls :");
						ball = inputObj.nextInt();
						totalBowlerBalls += ball;
						if(bowler == totalBowler && totalBowlerBalls < totalPlayBalls){
							System.out.println("Re-enter Data !! Total Balls is less than Virat is going to play balls");
							queueObj = null;
						}
						queueObj.enQueue(new Player(name, ball));
						bowler++;
					}catch(InputMismatchException e){
						System.out.println("Warning : Invalid value !! Try Again");
					}
				}
			}while(queueObj == null);
			
			System.out.println("\nBall\t\tName");
			int rank = 1;
			while(!queueObj.isEmpty() && rank<= totalPlayBalls){
				System.out.println(rank++ + "\t\t" + queueObj.deQueue().bowlerName);
			}
		}catch(InputMismatchException e){
			System.out.println("Warning : Invalid value !! Try Again");
		}
		
		
	}

}
