package question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationNegativeTest {

	ArrOperation operation = new ArrOperation();

	@Test(expected = AssertionError.class)
	public void negitiveMaxMirror() {

		int input[] = {};                  //array is empty error
		operation.maxMirror(input);

	}

	@Test(expected = AssertionError.class)
	public void negitiveSplitTest() {
		int input[] = {};
		operation.split(input);

	}

	@Test(expected = AssertionError.class)
	public void negitiveCountClumps() {
		int input[] = {};
		operation.countClumps(input);

	}

	@Test(expected = AssertionError.class)
	public void negitiveFixXY() {
		operation.fixXY(new int[] {}, 4, 5);
		operation.fixXY(new int[] { 1, 4, 1, 5, 5, 4, 5}, 4, 5);     //throw unequal X and Y error
		operation.fixXY(new int[] { 1, 4, 4, 5, 5, 1, 1 }, 4, 5);    //throw two adjacent X error

	}

}
