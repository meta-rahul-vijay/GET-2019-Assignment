package question2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * this class test the ArrayQueue operations
 * @author Mahendar Singh
 * Dated 07/31/2019
 */
public class ArrayQueueTest {
	Queue queue = null;
	@Before
	public void Initialize(){
		queue = new ArrayQueue(5);
	}
	
	@Test
	public void testEnQueue() {
		queue.enQueue(1);
		assertEquals(1,queue.queueSize());
		
		queue.enQueue(2);
		assertEquals(2,queue.queueSize());
		
		
		queue.enQueue(3);
		assertEquals(3,queue.queueSize());
			
	}

	@Test
	public void testDeQueue(){
		
		assertEquals(-1111, queue.deQueue());
		
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		
		assertEquals(1, queue.deQueue());
		assertEquals(2, queue.deQueue());
		
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, queue.isEmpty());
		
		queue.enQueue(1);
		assertEquals(false, queue.isEmpty());

	}

	@Test
	public void testIsFull() {
		
		assertEquals(false, queue.isFull());
		
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		
		assertEquals(false, queue.isFull());
		
		queue.enQueue(5);
		assertEquals(true, queue.isFull());
		
	}

	@Test
	public void testFrontElement() {
		queue.enQueue(1);
		queue.enQueue(2);
		
		assertEquals(1,queue.frontElement());
		
	}

	@Test
	public void testRearElement() {
		queue.enQueue(1);
		queue.enQueue(2);
		assertEquals(2, queue.rearElement());
		
		queue.enQueue(3);
		assertEquals(3, queue.rearElement());
		
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

