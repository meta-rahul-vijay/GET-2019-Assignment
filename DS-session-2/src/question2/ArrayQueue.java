package question2;

/**
 * This class is for Queue Operation. class have method to add element in queue , Dequeue,  isQueueEmpty etc
 * @author Mahendar Singh
 * Dated 07/31/2019
 */
public class ArrayQueue implements Queue{
	
	private int front ;
	private int rear ;
	private int queueSize;
	private int capacityOfQueue ;
	private int[] queueArray;
	
	/**
	 * constructor for ArrayQueue
	 * @param capacity is max items in queue
	 */
	public ArrayQueue( int capacity){
		this.front = -1;
		this.rear = -1;
		this.queueSize = 0;
		this.capacityOfQueue = capacity;
		this.queueArray = new int[capacity];
	}

	@Override
	public void enQueue(int data) {
		if(isEmpty()){
			front = 0;
			rear = 0;
			queueArray[rear] = data;
			queueSize++;
			
		}else{
			if(!isFull()){
				rear = (rear+1) % capacityOfQueue;
				queueArray[rear] = data;
				queueSize++;
			}else
				System.out.println("Queue is full");
		}
		
	}

	@Override
	public int deQueue() {
		if(isEmpty()){
			return Integer.MIN_VALUE;
		}
		int data = queueArray[front];
		front = (front+1)%capacityOfQueue;
		queueSize--;
		return data;
	}

	@Override
	public boolean isEmpty() {
		if(queueSize == 0)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(queueSize == capacityOfQueue)
			return true;
		return false;
	}

	@Override
	public int frontElement() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		return queueArray[front];
	}

	@Override
	public int rearElement() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		return queueArray[rear];
	}

	@Override
	public int queueSize() {
		return queueSize;
	}
	
	@Override
	public void displayQueue(){
		for(int index = front; ; ){
			if(index == rear){
				System.out.println(queueArray[index] );
				break;
			}
			System.out.print(queueArray[index] + " ");
			index = (index+1) % capacityOfQueue;
		}
	}
}

