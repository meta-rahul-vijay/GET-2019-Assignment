package question1;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
/**
 * class to test methods of MathOperation class
 * @author Mahendar
 */
public class MathOperationTest {

	MathOperation operationObject=new MathOperation();
	//test leastCommonMultiple for positive cases
	@Test
	public void LCMtest() {
		
		assertEquals(20,operationObject.leastCommonMultiple(4, 5));
		assertEquals(6,operationObject.leastCommonMultiple(1,6));
	}
	
	//test leastCommonMultiple for negative values
	@Test(expected = AssertionError.class)
	public void testNegativeLcm() {
		
		assertEquals( 60, operationObject.leastCommonMultiple(12, -30));
	}
	
	//test highestCommonFactor for positive cases
	@Test
	public void HCFtest() {
		assertEquals(4,operationObject.highestCommonFactor(32, 20));
	}
	
	//test highestCommonFactor for negative values
	@Test(expected = AssertionError.class)
	public void testNegativeHcf() {
		
		assertEquals( 8, operationObject.highestCommonFactor(24, -64));
	}
}