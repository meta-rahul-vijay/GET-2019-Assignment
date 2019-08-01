package question1;

import java.util.Scanner;
/**
 * This class provide the UI
 * @author Mahendar Singh 
 * Dated 07/31/2019
 */
public class Driver {

	public static void main(String[] args) {

		Scanner inputObj = new Scanner(System.in);
		EvaluateExpression evaluate=new EvaluateExpression();
		int choice = 0;
		String expression,postfix;
		System.out.println("Enter the expression.. ");
		expression=inputObj.nextLine();
		postfix=evaluate.infixToPostfix(expression);
		System.out.println("postfix expression is : "+postfix);
		System.out.println("Result is : "+evaluate.evaluatePostfix(postfix));
	}
}
