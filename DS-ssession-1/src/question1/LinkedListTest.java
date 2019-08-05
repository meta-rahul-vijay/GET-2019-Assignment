package question1;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * test class for linked list operations
 * @author Mahendar Singh
 *
 */
public class LinkedListTest {

	/*
	 * positive test for rotate method
	 */
	@Test
	public void rotateTest(){
		LinkedList list=new LinkedList();
		list.addNodeToList(1);
		list.addNodeToList(2);
		list.addNodeToList(3);
		list.addNodeToList(4);
		list.addNodeToList(5);
		list.addNodeToList(6);
		list.addNodeToList(7);
		
		LinkedList rotatedList=new LinkedList();
		rotatedList.addNodeToList(1);
		rotatedList.addNodeToList(4);
		rotatedList.addNodeToList(5);
		rotatedList.addNodeToList(6);
		rotatedList.addNodeToList(2);
		rotatedList.addNodeToList(3);
		rotatedList.addNodeToList(7);
		
		list.rotateList(2, 6, 2);
		for(int i=0;i<list.sizeOfList();i++){
			
			assertEquals(rotatedList.get(i),list.get(i));
		}
	}

	/*
	 * negative test for rotate method
	 */
	@Test(expected=AssertionError.class)
	public void rotateNegativeTest(){
		LinkedList list1=new LinkedList();
		list1.addNodeToList(1);
		list1.addNodeToList(2);
		list1.addNodeToList(3);
		list1.addNodeToList(4);
		list1.addNodeToList(5);
		list1.addNodeToList(6);
		list1.addNodeToList(7);
		
		LinkedList rotatedList=new LinkedList();
		rotatedList.addNodeToList(1);
		rotatedList.addNodeToList(4);
		rotatedList.addNodeToList(5);
		rotatedList.addNodeToList(6);
		rotatedList.addNodeToList(2);
		rotatedList.addNodeToList(3);
		rotatedList.addNodeToList(7);
		
		list1.rotateList(2, 9, 2);
		for(int i=0;i<list1.sizeOfList();i++){
			
			assertEquals(rotatedList.get(i),list1.get(i));
		}
	}
	
	/*
	 * test for checkLoop method
	 */
	@Test
	public void checkLoopTest(){
		LinkedList list=new LinkedList();
		list.addNodeToList(1);
		list.addNodeToList(2);
		list.addNodeToList(3);
		list.addNodeToList(4);
		list.addNodeToList(5);
		list.addNodeToList(6);
		list.addNodeToList(7);
		list.addLoop(2);
		assertTrue(list.checkLoop());
	}
}
