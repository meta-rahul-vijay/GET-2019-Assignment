package Question1;

public interface GenericCalc {
	/**
	 * support method for baseToDecimal
	 * @param baseChar character of base b string 
	 * @return integer value of character
	 */
	int charToInt(char baseChar) ;
	
	/**
	 * converts base b number to decimal
	 * @param baseNumber is number string to be converted
	 * @return decimal value of baseNumber
	 */
	 int baseToDecimal(String baseNumber) ;
	
	 /**
	 * support method for decToBase
	 * @param Number is remainder of number to be converted when divided by base b 
	 * @return character value of Number
	 */
	char IntToChar(long number) ;

	/**
	 * converts decimal number to any base number
	 * @param decimalNumber number to be converted
	 * @return string of base number value of decimalNumber
	 */
	 String decToBase(long decimalNumber) ;

	/**
	 * add two numbers of base b
	 * @param baseNumber1 first base b number
	 * @param baseNumber2 second base b number
	 * @return sum of both number
	 */
	 String add(String baseNumber1, String baseNumber2);

	/**
	 * subtract two numbers of base b
	 * @param baseNumber1 first base b number
	 * @param baseNumber2 second base b number
	 * @return subtraction of both number
	 */
	String subtract(String baseNumber1, String baseNumber2) ;
	
	/**
	 * division of two numbers of base b
	 * @param baseNumber1 first base b number
	 * @param baseNumber2 second base b number
	 * @return division of both number
	 */
	String divide(String baseNumber1, String baseNumber2); 

	/**
	 * multiply two numbers of base b
	 * @param baseNumber1 first base b number
	 * @param baseNumber2 second base b number
	 * @return multiplication of number
	 */
	String multiply(String baseNumber1, String baseNumber2);
	
	/**
	 * compare two numbers of base b whether they are equal
	 * @param baseNumber1 first base b number
	 * @param baseNumber second base b number
	 * @return whether both number are equal
	 */
	boolean isEquals(String baseNumber1, String baseNumber2) ;

	/**
	 * check first number is greater than second
	 * @param baseNumber1 first base b number
	 * @param baseNumber2 second base b number
	 * @return boolean value whether first number is greater than second or not
	 */
	 boolean isGreater(String baseNumber1, String baseNumber2)

	/**
	 * check first number is smaller than second
	 * @param baseNumber1 first base b number
	 * @param baseNumber second base b number
	 * @return boolean value whether first number is smaller than second or not
	 */
	 boolean isSmaller(String baseNumber1, String baseNumber2) ;
	}

}
