package question2;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
/**
 * @description class to test methods of Search class
 * @author Mahendar
 */
public class SearchTest {

	Search searchObject = new Search();
    //test searchByLinear for positive cases
	@Test
	public void LinearTest() {
		int input1[] = { 2, 3, 5, 8, 15, 21, 29 };
		assertEquals(6, searchObject.searchByLinear(input1, 29));
		int input2[] = { 2, 3, 5, 8, 15, 21, 29 };
		assertEquals(0, searchObject.searchByLinear(input2, 2));
		int input3[] = { 2, 3, 5, 8, 15, 21, 29 };
		assertEquals(-1, searchObject.searchByLinear(input3, 1));
	}

    //test searchByLinear for empty array
	@Test(expected = AssertionError.class)
	public void linearEmptyArrayTest() {
		assertEquals(-1, searchObject.searchByLinear(new int[] {}, 0));
	}

	//test searchElementByBinarySearch for positive cases
	@Test
	public void binaryTest() {
		int input1[] = { 2, 3, 5, 8, 15, 21, 29 };
		assertEquals(0, searchObject.searchElementByBinarySearch(input1, 2));
		int input2[] = { 2, 3, 5, 8, 15, 21, 29 };
		assertEquals(5, searchObject.searchElementByBinarySearch(input2, 21));
		int input3[] = { 2, 3, 5, 8, 15, 21, 29,45 };
		assertEquals(-1, searchObject.searchElementByBinarySearch(input3, 30));
	}

	//test searchElementByBinarySearch for empty array
	@Test(expected = AssertionError.class)
	public void binaryEmptyArrayTest() {
		assertEquals(-1,
				searchObject.searchElementByBinarySearch(new int[] {}, 0));
	}

}