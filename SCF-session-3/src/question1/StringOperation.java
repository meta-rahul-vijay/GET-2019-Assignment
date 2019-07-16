package question1;
import java.util.*;
public class StringOperation {
	/**
	 * compare two strings
	 * @param stringCompare1 is the first string
	 * @param stringCompare2 is the second string
	 * @return 1 if both strings are equal else 0
	 */
	static int compareStrings(String stringCompare1,String stringCompare2) {
		if (stringCompare1.length() != stringCompare2.length()) {
			return 0;
		}
		int i;
		for (i = 0; i < stringCompare1.length(); i++) {
			if (stringCompare1.charAt(i) == stringCompare2.charAt(i))
				continue;
			else
				break;
		}
		if (i == stringCompare1.length())
			return 1;
		return 0;
	}
	/**
	 * reverse the input string
	 * @param stringToReverse is the input string
	 * @return reversed string
	 */
	static String reverse(String stringToReverse) {
		String reverse="";
		for(int i=stringToReverse.length()-1;i>=0;i--) {
			reverse+=stringToReverse.charAt(i);
		}
		return reverse;
	}
	/**
	 * replace the lower case letters with upper case and vice-versa
	 * @param stringToReplace is the input string
	 * @return replaced string
	 */
	static String replace(String stringToReplace) {
		String replaced="";
		for(int i=0;i<stringToReplace.length();i++) {
			if(stringToReplace.charAt(i)>64&&stringToReplace.charAt(i)<91)      //checking if character is upper case
				replaced+=(char)(stringToReplace.charAt(i)+32);
			else if(stringToReplace.charAt(i)>96&&stringToReplace.charAt(i)<123)    //checking if character is lower case
				replaced+=(char)(stringToReplace.charAt(i)-32);
			else { 
				return "Invalid input..";    //character is not an alphabet
			}
		}
		return replaced;
	}
	/**
	 * Find the largest word in a string
	 * @param inputString is the input string
	 * @return largest word present in the input string
	 */
	static String largestWord(String inputString){
		String largest="",word="";
		for(int i=0;i<inputString.length();i++){
			if(inputString.charAt(i)==' '){
				if(largest.length()<=word.length()) {
					largest=word;
				}
				word="";
				continue;
			}
			word+=inputString.charAt(i);
		}
		if(largest.length()<=word.length()) {    //checking if last word is largest
			largest=word;
		}
		return largest;
	} 
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);    //Scanner for input
		int choice=0;
		String s1="",s2="";
		do {
			System.out.println("Select the preferred choice:\n1.Compare two strings\n2.Reverse string\n3.replace string characters\n4.Return largest word\n5.Exit");
			try {
				choice = in.nextInt();
				in.nextLine();
			} catch (Exception e) {
				System.out.println("Invalid choice.. try again");
			}
			switch (choice) {
			case 1:
				System.out.println("Enter first string : ");
				s1=in.nextLine();
				System.out.println("Enter Second string : ");
				s2=in.nextLine();
				System.out.println(compareStrings(s1,s2));
				break;
			case 2:
				System.out.println("Enter string : ");
				s1=in.nextLine();
				System.out.println(reverse(s1));
				break;
			case 3:
				System.out.println("Enter string : ");
				s1=in.nextLine();
				System.out.println(replace(s1));
				break;

			case 4:
				System.out.println("Enter string : ");
				s1=in.nextLine();
				System.out.println(largestWord(s1));
				break;

			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Wrong input , Try again..");

			}
		} while (true);

	}

}