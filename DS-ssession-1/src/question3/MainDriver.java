package question3;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the UI part of the MultivariablePolynomial class
 * @author Mahendar Singh
 * Dated 07/30/2019
 */
public class MainDriver
{

	public static void main(String[] args) {
		
		List<Term> termList = new ArrayList<>();
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
		
		MultivariablePolynomial polynomialObject = new MultivariablePolynomial(termList);
		String polynomialString = polynomialObject.visualiseMultivariablePolynomial();
		System.out.println("Multivariable Polynomial = " + polynomialString);
		System.out.println("Degree = " + polynomialObject.calculatePolynomialDegree());
	}

}