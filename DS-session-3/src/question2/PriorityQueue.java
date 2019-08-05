package question2;

/**
 * This Interface can be used to implement Priority Queue.
 */
public interface PriorityQueue{
	void enQueue(int data);
	int deQueue();
	boolean isEmpty();
	int firstElement();
	int queueSize();
	void displayQueue();

}