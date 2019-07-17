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
public class SplitTest {

	private int[] inputArray;
	private int expectedResult;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	public SplitTest(int expectedResult, int[] inputArray) {     //constructor
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection data() {                 //contains data for testing fixXY method
		return Arrays.asList(new Object[][] { 
				{ 3, new int[] {1,1,1,2,1}},
				{ -1, new int[] { 2,1,1,2,1} },
				{ 1, new int[] { 10,10 } },
				{ 4, new int[] { 10,10,2,2 } },        //negative case
				{ 2, new int[] {  } },                 //throw empty array error
		});
	}

	@Test
	public void SplitTest() {		assertEquals(expectedResult, arrOperations.split(inputArray));    //check if actual is equal to expected

	}

}
