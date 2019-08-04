package question3;

/**
 * Interface of a priority queue
 * @author Mahendar Singh
 * Dated 08/02/2019
 */
interface PriorityQueue{
	
	void enQueue(Player data);
	Player deQueue();
	boolean isEmpty();
	int queueSize();

}