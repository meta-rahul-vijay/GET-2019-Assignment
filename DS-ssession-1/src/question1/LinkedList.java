package question1;
import java.util.*;
/**
 * this class implements linked list and performs some operations on it
 * @author Mahendar Singh
 */
import question1.Node;
public class LinkedList {

	Node head=null;
	
	/**
	 * add node to a linked list
	 * @param value is the item to be added in list
	 * @return the linked list
	 */
    LinkedList addNodeToList(int value){
    	if(head==null){
    		head=new Node(value);
    		return this;
    	}
    	Node temp=head;
    	while(temp.next!=null){
    		temp=temp.next;
    	}
    	temp.next=new Node(value);
    	return this;
    }
    
    /**
     * @return the size of linked list
     */
    int sizeOfList(){
    	Node temp=head;
    	int count=0;
    	while(temp!=null){
    		count++;
    		temp=temp.next;
    	}
    	return count;
    }
    
    
    /**
     * rotate a sublist in linked list
     * @param left is the left index of sublist
     * @param right is the right index of sublist
     * @param number is the number of elements to be rotated
     * @return the rotated list
     */
    LinkedList rotateList(int left,int right,int number){
    	
    	assert(left>=1 && right<this.sizeOfList()):" choose correct right or left ";
    	
    	int count=1;
    	number=number%(right-left+1);
    	if(number==0)
    		return this;
    	Node temp=head;
    	Node leftPre=null;
    	Node leftNode=null;
    	Node middle=null;
    	Node rightNode=null;
    	Node rightPost=null;
    	while(count<=right){
    		if(count+1==left)
    			leftPre=temp;
    		if(count==left)
    			leftNode=temp;
    		if(count==left+number-1)
    			middle=temp;
    		if(count==right){
    			rightNode=temp;
    			rightPost=temp.next;
    		}
    		temp=temp.next;
    		count++;
    	}
    	
    	
    	rightNode.next=leftNode;
    	if(leftPre==null)
    		head=middle.next;
    	else
    		leftPre.next=middle.next;
    	middle.next=rightPost;
    	
    	return this;
    	                                                                                                     
    }
    
    /**
     * Add a loop in linked list
     * @param position is the position at which loop is to be added
     * @return the linked list containing loop
     */
    LinkedList addLoop(int position){
    	
    	assert(position>1&&position<this.sizeOfList()):"position should be in range of list.."; 
    	
    	int count=0;
    	Node temp=head;
    	Node loopNode=null;
    	while(temp.next!=null){
    		if(count==position){
    			loopNode=temp;
    		}
    		temp=temp.next;
    		count++;
    	}
    	temp.next=loopNode;
    	return this;
    }
    
    /**
     * check if list contains a loop
     * @return true if loop present else false
     */
    boolean checkLoop(){
    	 Node slow = head, fast = head; 
         while (slow != null && fast != null && fast.next != null) { 
             slow = slow.next; 
             fast = fast.next.next; 
   
             // If slow and fast meet at same point then loop is present 
             if (slow == fast) {  
                 return true; 
             } 
         } 
         return false; 
    }
    
    /**
     * print the linked list
     */
    void printList() 
    { 
        Node temp = head; 
        while(temp != null) 
        { 
            System.out.print(temp.value+" -> "); 
            temp = temp.next; 
        } 
        System.out.println(); 
    } 
    
    /**
     * return the value of node at index 
     * @param index is position of which we want the value
     * @return the value of node at index 
     */
    int get(int index){
    	Node temp=head;
    	int count=0;
    	while(count<index){
    		temp=temp.next;
    		count++;
    	}
    	return temp.value;
    }
}
