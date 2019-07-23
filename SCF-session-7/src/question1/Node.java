package question1;

/**
 * class used to contain only non zero elements of sparse matrix
 * @author Mahendar
 *
 */
public class Node {
	
	public int row;
	public int col;
	public int value;
	
	public Node(int row,int col, int value){
		this.row=row;
		this.col=col;
		this.value=value;
	}
}
