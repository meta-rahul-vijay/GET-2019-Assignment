package Question1;
import java.util.*;

public class HexCalc {
	/**
	 * support method for hexaToDecimal
	 * @param hexaChar character of hexadecimal string 
	 * @return integer value of character
	 */
	static int charToInt(char hexaChar) {
		if (hexaChar >= '0' && hexaChar <= '9')
			return (int) hexaChar - '0';
		else
			return (int) (hexaChar - 'A') + 10;
	}
	/**
	 * converts hexadecimal number to decimal
	 * @param hexaNumber is number string to be converted
	 * @return decimal value of hexaNumber
	 */
	static int hexToDecimal(String hexaNumber) {
		int power = 1;
		int decimalNumber = 0;
		for (int i = hexaNumber.length() - 1; i >= 0; i--) {
			if (charToInt(hexaNumber.charAt(i)) >= 16) {
				System.out.println("Invalid Input");
				System.exit(0);
			}
			decimalNumber += charToInt(hexaNumber.charAt(i)) * power;
			power = power * 16;
		}

		return decimalNumber;
	}
	/**
	 * support method for decToHexa
	 * @param Number is remainder of number to be converted when divided by 16 
	 * @return character value of Number
	 */
	static char IntToChar(long number) {
		if (number >= 0 && number <= 9)
			return (char) (number + 48);
		else
			return (char) (number - 10 + 65);
	}

	/**
	 * converts decimal number to Hexadecimal
	 * @param decimalNumber number to be converted
	 * @return string of hexadecimal value of decimalNumber
	 */
	static String decToHexa(long decimalNumber) {
		String hexaNumber = "";
		long number = decimalNumber;
		if (decimalNumber == 0) {
			return "0";
		}
		if (decimalNumber < 0) {
			number = Math.abs(decimalNumber);
		}
		while (number > 0) {
			hexaNumber += IntToChar(number % 16);
			number /= 16;
		}
		StringBuffer f = new StringBuffer();
		f.append(hexaNumber);
		if (decimalNumber < 0) {
			f.append('-');
		}
		return f.reverse().toString();
	}

	/**
	 * add two hexadecimal number
	 * @param hexa1 first hexadecimal number
	 * @param hexa2 second hexadecimal number
	 * @return sum of both hexadecimal number
	 */
	static String add(String hexa1, String hexa2) {
		int number1 = hexToDecimal(hexa1);
		int number2 = hexToDecimal(hexa2);
		int number3 = number1 + number2;
		String result = decToHexa(number3);
		return result;
	}

	/**
	 * subtract two hexadecimal number
	 * @param hexa1 first hexadecimal number
	 * @param hexa2 second hexadecimal number
	 * @return subtraction of both hexadecimal number
	 */
	static String subtract(String hexa1, String hexa2) {
		int number1 = hexToDecimal(hexa1);
		int number2 = hexToDecimal(hexa2);
		int number3 = number1 - number2;
		String result = decToHexa(number3);
		return result;
	}

	/**
	 * division of two hexadecimal number
	 * @param hexa1 first hexadecimal number
	 * @param hexa2 second hexadecimal number
	 * @return division of both hexadecimal number
	 */
	static String divide(String hexa1, String hexa2) {
		int number1 = hexToDecimal(hexa1);
		int number2 = hexToDecimal(hexa2);
		int number3 = number1 / number2;
		String result = decToHexa(number3);
		return result;
	}

	/**
	 * multiply two hexadecimal number
	 * @param hexa1 first hexadecimal number
	 * @param hexa2 second hexadecimal number
	 * @return multiplication of both hexadecimal number
	 */
	static String multiply(String hexa1, String hexa2) {
		long number1 = hexToDecimal(hexa1);
		long number2 = hexToDecimal(hexa2);
		long number3 = number1 * number2;
		String result = decToHexa(number3);
		return result;
	}

	/**
	 * compare two hexadecimal number whether they are equal
	 * @param hexa1 first hexadecimal number
	 * @param hexa2 second hexadecimal number
	 * @return whether both number are equal
	 */
	static boolean isEquals(String hexa1, String hexa2) {
		boolean result = false;
		if (hexa1.length() != hexa2.length()) {
			return result;
		}
		int i;
		for (i = 0; i < hexa1.length(); i++) {
			if (hexa1.charAt(i) == hexa2.charAt(i))
				continue;
			else
				break;
		}
		if (i == hexa1.length())
			result = true;
		return result;
	}

	/**
	 * check first number is greater than second
	 * @param hexa1 first hexadecimal number
	 * @param hexa2 second hexadecimal number
	 * @return boolean value whether first number is greater than second or not
	 */
	static boolean isGreater(String hexa1, String hexa2) {
		boolean result = true;
		if (hexa1.length() > hexa2.length()) {
			return result;
		} else if (hexa1.length() < hexa2.length()) {
			result = false;
			return result;
		}
		int i;
		for (i = 0; i < hexa1.length(); i++) {
			if (hexa1.charAt(i) > hexa2.charAt(i)) {
				break;
			} else if (hexa1.charAt(i) == hexa2.charAt(i))
				continue;
			else {
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * check first number is smaller than second
	 * @param hexa1 first hexadecimal number
	 * @param hexa2 second hexadecimal number
	 * @return boolean value whether first number is smaller than second or not
	 */
	static boolean isSmaller(String hexa1, String hexa2) {
		boolean result = true;
		if (hexa1.length() < hexa2.length()) {
			return result;
		} else if (hexa1.length() > hexa2.length()) {
			result = false;
			return result;
		}
		int i;
		for (i = 0; i < hexa1.length(); i++) {
			if (hexa1.charAt(i) < hexa2.charAt(i)) {
				break;
			} else if (hexa1.charAt(i) == hexa2.charAt(i))
				continue;
			else {
				result = false;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String hexa1, hexa2;
		System.out.println("Enter first hexa decimal number.. ");
		hexa1 = in.nextLine();
		hexa1 = hexa1.toUpperCase();
		System.out.println("Enter second hexa decimal number.. ");
		hexa2 = in.nextLine();
		hexa2 = hexa2.toUpperCase();
		System.out.println("Sum of " + hexa1 +" and "+ hexa2 + " is " + add(hexa1, hexa2));
		System.out.println("Subtraction of " + hexa1 +" and "+ hexa2 + " is "+ subtract(hexa1, hexa2));
		System.out.println("Multiplication of " + hexa1 +" and "+ hexa2 + " is "+ multiply(hexa1, hexa2));
		System.out.println("Division of " + hexa1 +" and "+ hexa2 + " is "+ divide(hexa1, hexa2));
		System.out.println(hexa1 + " equal to " + hexa2 + " : "+ isEquals(hexa1, hexa2));
		System.out.println(hexa1 + " greater than " + hexa2 + " : "+ isGreater(hexa1, hexa2));
		System.out.println(hexa1 + " smaller than " + hexa2 + " : "+ isSmaller(hexa1, hexa2));
	}

}

