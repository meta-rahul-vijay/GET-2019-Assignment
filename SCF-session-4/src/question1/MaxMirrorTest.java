package question1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
/*
 * test class for maxMirror method
 */
public class MaxMirrorTest {

	private int[] inputArray;
	private int expectedResult;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	public MaxMirrorTest(int expectedResult, int[] inputArray) {    //constructor
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection data() {                           //contains data for testing maxMirror
		return Arrays.asList(new Object[][] {
				{ 3, new int[] { 1, 2, 3, 8, 9, 3, 2, 1 } },
				{ 4, new int[] { 1, 1, 2, 2, 2, 2 } },
				{ 2, new int[] { 1, 1, 2, 2, 3, 3 } },
				{ 5, new int[] { 1, 1, 1, 1, 1 } },
				{ 5, new int[] { 1, 2, 3, 2, 1 } },
				{ 4, new int[] { 7, 7, 7, 7, 6, 7 } },
				});                    
	}

	@Test
	public void maxMirrorTest() {
		assertEquals(expectedResult, arrOperations.maxMirror(inputArray));    //check if actual is equal to expected
	}
}
