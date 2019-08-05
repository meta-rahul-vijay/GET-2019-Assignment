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
public class FixXYTest {
	
	private int[] inputArray;
	private int x;
	private int y;
	private int expectedResult[];
	private ArrOperation arrOperations;

	@Before
	public void initialize() {    
		arrOperations = new ArrOperation();
	}

	public FixXYTest(int[] expectedResult, int[] inputArray,int x ,int y) {    //constructor
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
		this.x=x;
		this.y=y;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {                //contains data for testing fixXY method
				{new int[] {9,4,5,4,5,9}, new int[] {5,4,9,4,9,5},4,5},
				{new int[] {1,4,5,1}, new int[] {1,4,1,5},4,5},
				{new int[] {1,4,5,1,1,4,5}, new int[] {1,4,1,5,5,4,1},4,5},  
		});
	}

	@Test
	public void FixXYTest() {
		assertArrayEquals(expectedResult, arrOperations.fixXY(inputArray,x,y));    //check if actual is equal to expected
	}

}
