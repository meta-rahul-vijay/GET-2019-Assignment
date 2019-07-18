package question1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
/*
 * test class for countClumps method
 */
public class CountClumpsTest {

	private int[] inputArray;
	private int expectedResult;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	public CountClumpsTest(int expectedResult, int[] inputArray) {    //constructor
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection data() {              //contains data for testing countClumps
		return Arrays.asList(new Object[][] {
				{ 2, new int[] {1,2,2,3,4,4}},
				{ 2, new int[] { 1, 1, 2,1,1} },
				{ 1, new int[] { 1, 1, 1,1 } },
		});
	}

	@Test
	public void CountClumpsTest() {
		assertEquals(expectedResult, arrOperations.countClumps(inputArray));     //check if actual is equal to expected
	}
}
