package question1;

public class MathOperation {

	/**
	 * find the LCM of two numbers
	 * @param firstNumber is the first input number
	 * @param secondNumber is the second input number
	 * @return LCM of two numbers
	 */
	int leastCommonMultiple(int firstNumber, int secondNumber) {

		if (firstNumber < 0 || secondNumber < 0) {
			throw new AssertionError("negative value");
		}
        int common=Math.max(firstNumber, secondNumber);
        return FindLCM(firstNumber, secondNumber, common);

	}

	/**
	 * called by leastCommonMultiple to implement LCM
	 * @param firstNumber is the first input number
	 * @param secondNumber is the second input number
	 * @param common is the common multiple
	 * @return LCM of two numbers
	 */
	int FindLCM(int firstNumber, int secondNumber, int common) {

		if (common % firstNumber == 0 && common % secondNumber == 0)
			return common;

		common++;
		return FindLCM(firstNumber, secondNumber, common);
	}

	/**
	 * find the HCF of two numbers 
	 * @param firstNumber is the first input number
	 * @param secondNumber is the second input number
	 * @return HCF of two numbers
	 */
	int highestCommonFactor(int firstNumber, int secondNumber) {

		if (firstNumber < 0 || secondNumber < 0) {
			throw new AssertionError("negative value");
		}
		if (secondNumber == 0)
			return firstNumber;

		return highestCommonFactor(secondNumber, firstNumber % secondNumber);
	}

}
