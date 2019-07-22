package question2;

public final class Poly {

	final int[][] polynomial;    
    //constructor to initialize polynomial with input array
	Poly(int[][] input) {          
		if (input.length == 0)
			throw new AssertionError("input can't be empty");
		polynomial = input;
	}

	//constructor to declare size of polynomial 2D array
	Poly(int size) {
		polynomial = new int[size][2];
	}

	/**
	 * evaluate the value of polynomial at a value
	 * @param value is the constant put in variable
	 * @return result of evaluation
	 */
	int evaluate(float value) {
		int result = 0;
		for (int i = 0; i < polynomial.length; i++) {
			result += polynomial[i][0] * Math.pow(value, polynomial[i][1]);
		}
		return result;
	}

	/**
	 * compute the degree of a polynomial
	 * @return the {int} degree of the polynomial
	 */
	int degree() {
		int degree = 0;
		for (int i = 0; i < polynomial.length; i++) {
			if (degree < polynomial[i][1])
				degree = polynomial[i][1];
		}
		return degree;
	}

	/**
	 * method to get coefficient of existing power in polynomial 
	 * @param power is the input whose coefficient to be found
	 * @return {int} coefficient of x^power 
	 */
	private int getCofficient(int power) {
		for (int i = 0; i < polynomial.length; i++) {
			if (polynomial[i][1] == power) {
				return polynomial[i][0];
			}
		}
		return 0;
	}

	/**
	 * add two polynomial
	 * @param polynomial1 is the first polynomial
	 * @param polynomial2 is the second polynomial
	 * @return {Poly} the addition polynomial
	 */
	static Poly addPoly(Poly polynomial1, Poly polynomial2) {
		int degree = Math.max(polynomial1.degree(), polynomial2.degree());
		Poly addition = new Poly(degree + 1);
		int cofficient = 0;
		for (int i = 0; i <= degree; i++) {

			if (polynomial1.getCofficient(i) != 0
					|| polynomial2.getCofficient(i) != 0) {
				cofficient = polynomial1.getCofficient(i)
						+ polynomial2.getCofficient(i);
				addition.polynomial[i][0] = cofficient;
				addition.polynomial[i][1] = i;
			}
		}
		return addition;
	}

	/**
	 * To check if 2D array contains the given power 
	 * @param givenArray is the polynomial to be checked
	 * @param power is the power of variable to be checked
	 * @return index where the power of variable & its coefficient exists or -1 if doesn't exist
	 */
	private static int returnIndex(int[][] givenArray, int power) {
		int index = -1;
		for (int i = 0; i < givenArray.length; i++) {
			if (givenArray[i][1] == power) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * multiply two polynomial
	 * @param polynomial1 is the first polynomial
	 * @param polynomial2 is the second polynomial
	 * @return {Poly} multiplication polynomial
	 */

	static Poly multiplyPoly(Poly polynomial1, Poly polynomial2) {

		int degree = polynomial1.degree() + polynomial2.degree();
		Poly multi = new Poly(degree + 1);
		int index = 0;
		int coff = 0, power = 0, k = 0;
		for (int i = 0; i < polynomial1.polynomial.length; i++) {
			for (int j = 0; j < polynomial2.polynomial.length; j++) {
				coff = polynomial1.polynomial[i][0]
						* polynomial2.polynomial[j][0];
				power = polynomial1.polynomial[i][1]
						+ polynomial2.polynomial[j][1];

				index = returnIndex(multi.polynomial, power);
				if (index != -1) {
					multi.polynomial[index][0] += coff;
				} else if (coff != 0) {
					multi.polynomial[k][0] = coff;
					multi.polynomial[k][1] = power;
					k++;
				}
			}
		}
		return multi;
	}
}
