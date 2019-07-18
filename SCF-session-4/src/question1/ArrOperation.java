package question1;

import java.util.*;

public class ArrOperation {

	/**
	 * maxMirror find the maximum length of mirror present in array
	 * @param mirrorArray is the input array containing mirror
	 * @return length of largest mirror
	 */
	int maxMirror(int mirrorArray[]) {

		if (mirrorArray.length == 0)
			throw new AssertionError("Array size cannot be zero");

		int maxLength = 0;
		int tempLength = 0;
		int pivot;
		for (int indexI = 0; indexI < mirrorArray.length; indexI++) {
			pivot = indexI;
			tempLength = 0;
			for (int indexJ = mirrorArray.length - 1; indexJ >= indexI; indexJ--) {
				if (mirrorArray[pivot] == mirrorArray[indexJ]) {
					tempLength++;
					pivot++;
				} else if (tempLength > maxLength) {
					maxLength = tempLength;
					tempLength = 0;
					pivot = indexI;
				} else if(pivot!=indexI){
					tempLength = 0;
					pivot = indexI;
					indexJ++;
				}
				if (tempLength > maxLength)
					maxLength = tempLength;
			}

		}

		return maxLength;
	}

	/**
	 * counts the number of clumps in array
	 * @param inputArray is the array containing clumps
	 * @return number of clumps present in inputArray
	 */
	int countClumps(int inputArray[]) {

		if (inputArray.length == 0)
			throw new AssertionError("Array size cannot be zero");

		int count = 0, clumps = 0;
		for (int i = 0; i < inputArray.length - 1; i++) {
			if (inputArray[i] == inputArray[i + 1]) {
				count++;
			} else if (count > 0) {
				clumps++;
				count = 0;
			}
		}
		if (count > 0) {
			clumps++;
		}
		return clumps;
	}

	/**
	 * Support method for fixXY used to count the occurrences of the number X in the array
	 * @param inputArray is the array containing inputs
	 * @param X is the number whose occurrences is to be found
	 * @return number of occurrences of X
	 */
	int countOfX(int[] inputArray, int X) {
		int countX = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == X)
				countX++;
		}
		return countX;
	}

	/**
	 * Support method for fixXY used to count the occurrences of the number Y in the array
	 * @param inputArray is the array containing inputs
	 * @param Y is the number whose occurrences is to be found
	 * @return number of occurrences of Y
	 */
	int countOfY(int[] inputArray, int Y) {
		int countY = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == Y)
				countY++;
		}
		return countY;
	}

	/**
	 * Support method for fixXY used to check whether two X's are adjacent
	 * @param inputArray is the array containing inputs
	 * @param X is the number whose occurrences is to be found
	 * @return {boolean} if adjacent X's are present
	 */
	public boolean checkAdjacencyOfX(int[] inputArray, int X) {
		for (int i = 0; i < inputArray.length - 1; i++) {
			if (inputArray[i] == X && inputArray[i + 1] == X)
				return true;
		}
		return false;
	}

	/**
	 * rearrange inputArray to a fixed array containing Y after every X
	 * @param inputArray is the input array to fix
	 * @param X is the fixed parameter
	 * @param Y is to be placed after X
	 * @return {int[]} fixed array
	 */

	int[] fixXY(int inputArray[], int X, int Y) {
		if (inputArray.length == 0)
			throw new AssertionError("Array size cannot be zero");

		if (countOfX(inputArray, X) != countOfY(inputArray, Y))
			throw new AssertionError("Count of X and Y should be same");

		if (checkAdjacencyOfX(inputArray, X) == true)
			throw new AssertionError("Array should not contain adjacent X");

		ArrayList<Integer> containYIndex = new ArrayList<Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == Y) {
				containYIndex.add(i);
			}
		}
		int temp, YIndex = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == X&&inputArray[i+1]!=Y) {
				temp = inputArray[i + 1];
				inputArray[i + 1] = inputArray[containYIndex.get(YIndex)];
				inputArray[containYIndex.get(YIndex)] = temp;
				YIndex++;
			}
			else if (inputArray[i] == X&&inputArray[i+1] == Y){
				YIndex++;
			}
		}
		return inputArray;
	}

	/**
	 * split the input array so sum of elements on left side is equal to right side elements sum
	 * @param splitArray is array to be split
	 * @return {int} index at which array is split
	 */
	int split(int splitArray[]) {

		if (splitArray.length == 0)
			throw new AssertionError("Array size cannot be zero");
		int sum = 0, leftSum = 0, rightSum = 0;
		for (int i = 0; i < splitArray.length; i++) {
			sum += splitArray[i];
		}
		if (sum % 2 != 0)
			return -1;
		int index;
		for (index = splitArray.length - 1; index > 0; index--) {
			rightSum += splitArray[index];
			leftSum = sum - rightSum;
			if (leftSum == rightSum) {
				return index;
			}
		}
		if (index == 0)
			return -1;
		return -1;
	}

}