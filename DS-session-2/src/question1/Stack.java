package question1;

/**
 * this class implements stack
 * @author Mahendar Singh 
 * Dated 07/31/2019
 */
public class Stack {

	Node top = null;

	/**
	 * this method implements push operation of stack
	 * @param value is the item to be pushed
	 * @return the stack
	 */
	Stack push(String value) {

		Node temp = new Node(value);
		temp.next = top;
		top = temp;
		return this;
	}

	/**
	 * this method implements pop operation of stack
	 * @return the stack
	 */
	Stack pop() {
		if (top == null) {
			System.out.println("underflow condition..");
		} else {
			top = top.next;
		}

		return this;
	}

	/**
	 * @return the top of stack
	 */
	Node peek() {
		return top;
	}

	/**
	 * checks whether stack is empty
	 * @return {boolean} true if stack is empty else false
	 */
	boolean isEmpty() {
		if (top == null)
			return true;
		else
			return false;
	}

}
