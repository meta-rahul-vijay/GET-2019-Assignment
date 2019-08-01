package question2;

/**
 * This Interface have operations for Queue
 * @author Mahendar Singh
 * @date 30/07/2019
 */
interface Queue{
	void enQueue(int data);
	int deQueue();
	boolean isEmpty();
	boolean isFull();
	int frontElement();
	int rearElement();
	int queueSize();
	void displayQueue();

}
