package question2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * this class test the ArrayPriorityQueue operations
 * @author Mahendar Singh
 * Dated 08/02/2019
 */
public class PriorityQueueTest {
	PriorityQueue queue = null;
	
	@Before
	public void Initialize(){
		queue = new ArrayPriorityQueue(5);
	}
	
	@Test
	public void testEnQueue() {
		queue.enQueue(1);
		assertEquals(1,queue.queueSize());
		
		queue.enQueue(2);
		assertEquals(2,queue.queueSize());
		
		
		queue.enQueue(3);
	//	assertEquals(4,queue.queueSize()); //Negative Case // Should come 3
			
	}

	@Test
	public void testDeQueue(){
		
		
		
		queue.enQueue(1);
		queue.enQueue(25);
		queue.enQueue(9);
		queue.enQueue(51);
		
		assertEquals(51, queue.deQueue());
		assertEquals(25, queue.deQueue());
		
	//	assertEquals(25, queue.deQueue()); //Negative Case
		
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, queue.isEmpty());
		
		queue.enQueue(1);
		assertEquals(false, queue.isEmpty());

	}

	@Test
	public void testFirstElement() {
		queue.enQueue(1);
		queue.enQueue(2);
		
		assertEquals(2,queue.firstElement());
		
	}
	@Test
	public void testQueueSize() {
		
		assertEquals(0, queue.queueSize());
		
		queue.enQueue(1);
		assertEquals(1, queue.queueSize());
		
		queue.enQueue(1);
		assertEquals(2, queue.queueSize());
		
	}

}

