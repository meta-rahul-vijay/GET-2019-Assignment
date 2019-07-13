package Question2;

import java.util.*;

public class JobSchedular {
	/**
	 * calculate completion time
	 * @param input is 2D array containing arrival and burst time
	 * @param numberOfProcess total number of processes
	 * @return array containing completion time
	 */
	static int[] calculateCompletionTime(int input[][], int numberOfProcess) {
		int startTime[] = new int[numberOfProcess];
		int completionTime[] = new int[numberOfProcess];
		startTime[0] = input[0][0];      //time at which process start executing
		completionTime[0] = input[0][1];
		for (int i = 1; i < numberOfProcess; i++) {
			if (completionTime[i - 1] > input[i][0]) {
				startTime[i] = completionTime[i - 1];
				completionTime[i] = startTime[i] + input[i][1];

			} else {
				startTime[i] = input[i][0];
				completionTime[i] = startTime[i] + input[i][1];
			}
		}
		return completionTime;
	}

	/**
	 * calculate turn Around time
	 * @param completionTime array containing completion time of each process
	 * @param input is 2D array containing arrival and burst time
	 * @param numberOfProcess total number of processes
	 * @return array containing turn Around time
	 */
	static int[] calculateTurnAroundTime(int completionTime[], int input[][],int numberOfProcess) {
		int turnAroundTime[] = new int[numberOfProcess];
		for (int i = 0; i < numberOfProcess; i++) {
			turnAroundTime[i] = completionTime[i] - input[i][0];
		}
		return turnAroundTime;
	}
	/**
	 * calculate waiting time
	 * @param TATime array containing turn around time of each process 
	 * @param input input is 2D array containing arrival and burst time
	 * @param numberOfProcess total number of processes
	 * @return
	 */
	static int[] calculateWaitTime(int TATime[], int input[][], int numberOfProcess) {
		int WaitTime[] = new int[numberOfProcess];
		for (int i = 0; i < numberOfProcess; i++) {
			WaitTime[i] = TATime[i] - input[i][1];
		}
		return WaitTime;
	}

	/**
	 * calculate average of waiting time of all processes
	 * @param WaitTime array containing waiting time of each process 
	 * @param numberOfProcess total number of processes
	 * @return average of waiting time
	 */
	static double averageOfWaitTime(int WaitTime[], int numberOfProcess) {
		double sum = 0;
		for (int i = 0; i < numberOfProcess; i++) {
			sum = sum + WaitTime[i];
		}
		return sum / numberOfProcess;
	}
	/**
	 * calculate max of waiting time of all processes
	 * @param WaitTime array containing waiting time of each process 
	 * @param numberOfProcess total number of processes
	 * @return max of waiting time array
	 */
	static int maxOfWTime(int WaitTime[], int numberOfProcess) {
		int max = WaitTime[0];
		for (int i = 1; i < numberOfProcess; i++) {
			if (WaitTime[i] > max)
				max = WaitTime[i];
		}
		return max;
	}
    /**
     * Sorts the input given by user in ascending order of process arrival time
     * @param input input is 2D array containing arrival and burst time
     */
	public static void sortByArrival(int input[][]) 
	    { 
	        // Using built-in sort function Arrays.sort 
	        Arrays.sort(input, new Comparator<int[]>() {
	          @Override              
	          // Compare values according to input[0]
	          public int compare(final int[] value1, final int[] value2) { 
	            if (value1[0] > value2[0]) 
	                return 1; 
	            else
	                return -1; 
	          }
	        });
	    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);    //scanner class for input
		System.out.println("Enter the number of processes..");
		int numberOfProcess = in.nextInt();
		int completionTime[] = new int[numberOfProcess];
		int turnAroundTime[] = new int[numberOfProcess];
		int waitTime[] = new int[numberOfProcess];
		double avgWait;
		int maxWait;
		int input[][] = new int[numberOfProcess][numberOfProcess];
		for (int i = 0; i < numberOfProcess; i++) {    //taking inputs
			System.out.println("Enter arrival time of " + (i+1) + " process ");
			input[i][0] = in.nextInt();
			System.out.println("Enter burst time of " + (i+1) + " process ");
			input[i][1] = in.nextInt();
		}
		sortByArrival(input);    //sort the input array by arrival time
		completionTime = calculateCompletionTime(input, numberOfProcess);
		turnAroundTime = calculateTurnAroundTime(completionTime, input, numberOfProcess);
		waitTime = calculateWaitTime(turnAroundTime, input, numberOfProcess);
		System.out.println("Arrival time\t Burst time\t CompletionTime\t TurnAroundTime\t WaitingTime");
		for (int i = 0; i < numberOfProcess; i++) {
			System.out.println(input[i][0] + "\t\t " + input[i][1] + "\t\t " + completionTime[i] + "\t\t " + turnAroundTime[i] + "\t\t "+ waitTime[i]);
		}
		avgWait = averageOfWaitTime(waitTime, numberOfProcess);
		maxWait = maxOfWTime(waitTime, numberOfProcess);
		System.out.println("Average of waiting time : " + avgWait);
		System.out.println("maximum of waiting time : " + maxWait);

	}

}

