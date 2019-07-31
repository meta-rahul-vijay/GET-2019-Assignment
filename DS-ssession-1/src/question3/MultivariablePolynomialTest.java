package question3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the methods of MultivariablePolynomial class
 * @author Mahendar
 * Dated 07/30/2019
 */
public class MultivariablePolynomialTest {
	
	List<Term> termList = new ArrayList<>();
	
	/**
	 * This method initializes the term list before any test is executed
	 */
	@Before
	public void initialize()
	{
		List<Variable> variable1 = new ArrayList<>();
		variable1.add(new Variable('x', 2));
		variable1.add(new Variable('y', 1));
		variable1.add(new Variable('z', 1));
		
		List<Variable> variable2 = new ArrayList<>();
		variable2.add(new Variable('x', 3));
		variable2.add(new Variable('y', 2));
		
		Term term1 = new Term(4, variable1);
		Term term2 = new Term(3, variable2);
		
		termList.add(term1);
		termList.add(term2);
	}
	
	//Test method to test visualizePolynomial method
	@Test
	public void testVisualizePolynomial()
	{
		MultivariablePolynomial polynomialObject = new MultivariablePolynomial(termList);
		String polynomialString = polynomialObject.visualiseMultivariablePolynomial();
		String expectedPolynomialString = "4*x^2*y^1*z^1 + 3*x^3*y^2";
		assertEquals(expectedPolynomialString, polynomialString);
	}

	//Test method to test degreeOfPolynomial method
	@Test
	public void testDegreeOfPolynomial()
	{
		MultivariablePolynomial polynomialObject = new MultivariablePolynomial(termList);
		assertEquals(5, polynomialObject.calculatePolynomialDegree());
	}
}