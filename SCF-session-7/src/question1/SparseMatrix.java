package question1;

import java.util.ArrayList;
/**
 * This class have Operations method of matrix by using them we can find symmetric,Transpose and can add another matrix and can multiply.
 * @author Mahendar
 * @date 22/07/2019
 */
public final class SparseMatrix {
	private final int row;
	private final int col;
	final ArrayList<Node> sparseTriplet;

	/**
	 * constructor to initialize optimized triplet
	 * @param sparseMatrix is the input sparse matrix
	 */
	public SparseMatrix(int sparseMatrix[][]) {
		sparseTriplet = new ArrayList<Node>();
		SparseMatrix matrixObj = null;
		row = sparseMatrix.length;
		col = sparseMatrix[0].length;
		for (int indexOne = 0; indexOne < row; indexOne++) {
			for (int indexTwo = 0; indexTwo < col;) {
				try {

					int value = sparseMatrix[indexOne][indexTwo];
					if (value != 0) {
						Node node = new Node(indexOne, indexTwo, value);
						sparseTriplet.add(node);
					}
					indexTwo++;
				} catch (Exception e) {
					System.out
							.println("--------------------------------------------------------");
					System.out
							.println("Warning : Please enter only integer value !! Try Again");
					System.out
							.println("--------------------------------------------------------");
				}
			}
		}
	}


    /**
     * convert ArrayList to an 2D array
     * @param list is the input list to be converted
     * @return the array representation of list
     */
	public int[][] convertListToArray(ArrayList<Node> list) {
		int length = list.size();
		int array[][] = new int[length][3];
		for (int i = 0; i < length; i++) {
			array[i][0] = list.get(i).row;
			array[i][1] = list.get(i).col;
			array[i][2] = list.get(i).value;
		}
		return array;
	}

	/**
	 * find the transpose of matrix
	 * @return the transpose matrix triplet containing non zero values only
	 */
	public int[][] transposeMatrix() {

		ArrayList<Node> transposeMatrix = new ArrayList<Node>();
		for (int i = 0; i < sparseTriplet.size(); i++) {
			Node node = new Node(sparseTriplet.get(i).col,
					sparseTriplet.get(i).row, sparseTriplet.get(i).value);
			transposeMatrix.add(node);
		}

		return convertListToArray(transposeMatrix);

	}

	/**
	 * convert 2D array to ArrayList
	 * @param array is the input array
	 * @return the List representation
	 */
	public ArrayList<Node> convertArrayToList(int[][] array) {
		ArrayList<Node> list = new ArrayList<Node>();
		for (int i = 0; i < array.length; i++) {
			Node node = new Node(array[i][0], array[i][1], array[i][2]);
			list.add(node);
		}
		return list;
	}

	/**
	 * check if the matrix is symmetric
	 * @return {boolean} true if matrix is symmetric else false
	 */
	public boolean symmetricMatrix() {
		if (row != col) {
			return false;
		}
		ArrayList<Node> transposedMatrix = convertArrayToList(transposeMatrix());

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (valueAtRowCol(i, j, sparseTriplet) != valueAtRowCol(i, j, transposedMatrix)) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * add two sparse matrices
	 * @param ObjTwo is the second matrix to be added
	 * @return 2D array containing non zero elements of sum
	 */
	public int[][] addMatrices(SparseMatrix ObjTwo) {

		ArrayList<Node> addList = new ArrayList<Node>();

		if (this.row != ObjTwo.row || this.col != ObjTwo.col) {
			System.out
					.println("Matrices Can't add because row and column not similar");
		} else {

			for (int indexRow = 0; indexRow < this.row; indexRow++) {
				for (int indexCol = 0; indexCol < this.col; indexCol++) {
					int value = valueAtRowCol(indexRow, indexCol,
							this.sparseTriplet)
							+ valueAtRowCol(indexRow, indexCol,
									ObjTwo.sparseTriplet);
					if (value != 0) {
						Node node = new Node(indexRow, indexCol, value);
						addList.add(node);
					} else {
						continue;
					}
				}
			}

		}
		return convertListToArray(addList);
	}

	/**
	 * multiply two sparse matrices
	 * @param Obj1 is the first input matrix
	 * @param Obj2 is the second input matrix
	 * @return 2D array containing non zero elements of multiplication
	 */
	public int[][] multiplyMatrix(SparseMatrix Obj1, SparseMatrix Obj2) {
		ArrayList<Node> multiplyList = new ArrayList<Node>();
		if (Obj1.col != Obj2.row) {
			System.out
					.println("Matrices can't multiply because column of first matrix and row of 2nd matrix is not same");
		} else {

			for (int i = 0; i < Obj1.row; i++) {
				for (int q = 0; q < Obj2.col; q++) {
					int sum = 0;
					for (int j = 0; j < Obj1.col; j++) {
						sum += Obj1.valueAtRowCol(i, j, Obj1.sparseTriplet)
								* Obj2.valueAtRowCol(j, q, Obj2.sparseTriplet);
					}

					Node node = new Node(i, q, sum);
					if (node.value != 0)
						multiplyList.add(node);
				}
			}
		}

		return convertListToArray(multiplyList);

	}

	public int valueAtRowCol(int row, int col, ArrayList<Node> matrixList) {
		int value = 0;
		int sizeOfList = matrixList.size();
		for (int i = 0; i < sizeOfList; i++) {
			if (matrixList.get(i).row == row && matrixList.get(i).col == col) {
				value = matrixList.get(i).value;
			}
		}
		return value;
	}

}
