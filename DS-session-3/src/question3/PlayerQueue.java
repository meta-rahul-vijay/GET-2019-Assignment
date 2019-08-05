package question3;
/**
 * This class is for priority Queue Operations.
 * @author Mahendar Singh
 * Dated 08/02/2019
 */
public class  PlayerQueue  implements PriorityQueue{
	
	private final int FIRST = 1 ;
	private int last ;
	private int noOfBowler ;
	private Player[] queueArray;
	
	/**
	 * constructor for playerQueue
	 * @param capacity is max items in queue
	 */
	public PlayerQueue( int capacity){
		this.last = 0;
		this.noOfBowler = capacity;
		this.queueArray = new Player[capacity + 1];
		this.queueArray[0] = new Player("", Integer.MAX_VALUE);
	}

	@Override
	public void enQueue(Player data) {
		if( last == noOfBowler) {
			System.out.println(" Bowler Limit is Full");
			return;
		}else{
			queueArray[++last] = data;
			int dataIndex = last;
			while(dataIndex / 2 != 0) {
				if( queueArray[dataIndex / 2].balls < queueArray[dataIndex].balls) {
					Player tempPlayer;
					tempPlayer = queueArray[dataIndex / 2];
					queueArray[dataIndex / 2] = queueArray[dataIndex];
					queueArray[dataIndex] = tempPlayer;
					dataIndex = dataIndex / 2;
				}else{
					break;
				}
			}
		}
	}

	@Override
	public Player deQueue() {
		Player popped = null;
		if(isEmpty()){
			return popped;
		}else{
			popped = queueArray[FIRST];
			queueArray[1] =  queueArray[last--];
			int index = 1;
			
			while( (2 * index <= last) && (queueArray[index * 2].balls > queueArray[index].balls || queueArray[index * 2 + 1].balls > queueArray[index].balls)) {	
				if( queueArray[ index * 2].balls > queueArray[ index * 2 + 1].balls) {
					Player temp = queueArray[ index * 2 ];
					queueArray[ index * 2 ] = queueArray[ index ];
					queueArray[index] = temp;
					
					index = index * 2;
				}else{
					Player temp = queueArray[ index * 2 + 1 ];
					queueArray[ index * 2 + 1 ] = queueArray[ index ];
					queueArray[index] = temp;
					index = index * 2 + 1;
				}
			}
		}
		playerRoutine(popped);
		return popped;
	}

	@Override
	public boolean isEmpty() {
		if(last == 0)
			return true;
		return false;
	}
	@Override
	public int queueSize() {
		return last;
	}
	
	private void playerRoutine(Player poppedPlayer){
		poppedPlayer.balls--;
		if(poppedPlayer.balls != 0 ){
			enQueue(poppedPlayer);
		}
	}
}
