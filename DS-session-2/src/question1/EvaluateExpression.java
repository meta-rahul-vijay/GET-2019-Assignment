package question1;

import java.util.*;

/**
 * This class contains the method for expression evaluation
 * @author Mahendar Singh 
 * Dated 07/31/2019
 */
public class EvaluateExpression {

	Stack operators, operands;
	
	/*
	 * map contains the precedence of operators
	 */
	static HashMap<String, Integer> map = new HashMap<>();
	static {
		map.put("(", 0);
		map.put("!", 7);
		map.put("*", 6);
		map.put("/", 6);
		map.put("+", 5);
		map.put("-", 5);
		map.put(">", 4);
		map.put(">=", 4);
		map.put("<", 4);
		map.put("<=", 4);
		map.put("&&", 3);
		map.put("||", 2);
	}

	/**
	 * this method converts infix notation to postfix notation
	 * @param expression is the infix expression
	 * @return {String} the postfix notation of expression
	 */
	public String infixToPostfix(String expression) {

		operators = new Stack();
		String postfix = "";
		String splittedString[] = expression.split(" ");

		for (int i = 0; i < splittedString.length; i++) {
			if ("(".equals(splittedString[i])) {
				operators.push(splittedString[i]);
			} else if (map.containsKey(splittedString[i])) {
				while (!operators.isEmpty() && map.get(splittedString[i]) < map.get(operators.top.value)) {
					postfix += operators.top.value + " ";
					operators.pop();
				}
				operators.push(splittedString[i]);
			} else if (")".equals(splittedString[i])) {
				while (!("(".equals(operators.top.value))) {
					postfix += operators.top.value + " ";
					operators.pop();
				}
				operators.pop();
			} else {
				postfix += splittedString[i] + " ";
			}

		}
		while (!operators.isEmpty()) {
			postfix += operators.top.value + " ";
			operators.pop();
		}
		return postfix;
	}

	/**
	 * this method evaluate operator on operands
	 * @param operand1 is the first operand
	 * @param operand2 is the second operand
	 * @param operator is the operation to perform on operands
	 * @return {int} the result of evaluation
	 */
	int evaluate(int operand1, int operand2, String operator) {

		switch (operator) {

		case "+":
			return operand1 + operand2;
		case "-":
			return operand1 - operand2;
		case "*":
			return operand1 * operand2;
		case "/":
			return operand1 / operand2;
		}
		return 0;

	}

	/**
	 * this method evaluates a postfix expression
	 * @param postfix is the postfix notation of expression
	 * @return {String} the result of evaluation of postfix notation
	 */
	public String evaluatePostfix(String postfix) {

		operands = new Stack();
		int result;
		int operand1, operand2;
		String splittedString[] = postfix.split(" ");
		for (int i = 0; i < splittedString.length; i++) {
			if (map.containsKey(splittedString[i])) {

				operand1 = Integer.parseInt(operands.top.value);
				operands.pop();
				operand2 = Integer.parseInt(operands.top.value);
				operands.pop();
				operands.push(Integer.toString((evaluate(operand2, operand1,splittedString[i]))));
			} else {
				operands.push(splittedString[i]);
			}
		}
		return operands.top.value;
	}

}
