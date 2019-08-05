package question2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class PolyTest {


	/**
	 * Test case when input polynomial is empty
	 */
	@Test(expected = AssertionError.class)
	public void polyEmptyArrayTest() {
		new Poly(new int[][] {});
	}


	/**
	 * A positive Test case for evaluate(float x)
	 */
	@Test
	public void floatValueTest() {
		Poly polynomial = new Poly(new int[][] { { 2, 2 }, { 3, 1 }, { 2, 0 },
				{ 4, 1 } });
		double result = polynomial.evaluate(2f);
		assertEquals(24, result, 0.001);
	}

	/**
	 * Test case for degree()
	 */
	@Test
	public void degreeTest() {

		Poly polynomial = new Poly(new int[][] { { 2, 2 }, { 3, 1 }, { 2, 0 } });
		int result = polynomial.degree();
		assertEquals(2, result);
	}

	/**
	 * Test case for addPoly(Poly p1, Poly p2)
	 */
	@Test
	public void addPolynomialTest() {

		Poly polynomial1 = new Poly(new int[][] { { 2, 2 }, { 3, 1 }, { 2, 0 } });
		Poly polynomial2 = new Poly(new int[][] { { 4, 3 }, { 3, 1 } });

		Poly result = Poly.addPoly(polynomial1, polynomial2);
		assertArrayEquals(new int[][] { { 2, 0 }, { 6, 1 }, { 2, 2 }, { 4, 3 } },result.polynomial);

	}

	/**
	 * Test case for multiplyPoly(Poly p1, Poly p2)
	 */
	@Test
	public void multiplyPolynomialTest() {

		Poly polynomial1 = new Poly(new int[][] { { 2, 2 }, { 3, 1 }, { 2, 0 } });
		Poly polynomial2 = new Poly(new int[][] { { 4, 3 }, { 3, 1 } });

		Poly result = Poly.multiplyPoly(polynomial1, polynomial2);
	
		assertArrayEquals(new int[][] { { 8, 5 }, { 14, 3 }, { 12, 4 },{ 9, 2 }, { 6, 1 },{0,0} }, Poly.multiplyPoly(polynomial1, polynomial2).polynomial);
	}

}