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
		String newExpression="";
		for(int i=0;i<expression.length();i++){
			newExpression+=expression.charAt(i);
			if(EvaluateExpression.map.containsKey(Character.toString(expression.charAt(i)))){
				newExpression+=" ";
			}
			if(i<expression.length()-1&&EvaluateExpression.map.containsKey(Character.toString(expression.charAt(i+1)))){
				newExpression+=" ";
			}
		       
		}
		System.out.println(newExpression);
		postfix=evaluate.infixToPostfix(newExpression);
		System.out.println("postfix expression is : "+postfix);
		System.out.println("Result is : "+evaluate.evaluatePostfix(postfix));
	}
}
