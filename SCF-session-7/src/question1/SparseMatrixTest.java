package question1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
/**
 * class to test methods of SparseMatrix
 * @author Mahendar
 *
 */
public class SparseMatrixTest {

	@Test
	public void transposeTest() {
		SparseMatrix inputMatrix1 = new SparseMatrix(new int[][] { { 0, 1, 0 }, { 1, 0, 4 }, { 0, 3, 0 } });
		assertArrayEquals(new int[][] { { 1, 0, 1 }, { 0, 1, 1 }, { 2, 1, 4 }, { 1, 2, 3 } }, inputMatrix1.transposeMatrix());
		SparseMatrix inputMatrix2 = new SparseMatrix(new int[][] { { 0, 1, 0 }, { 2, 0, 0 }, { 0, 3, 0 } });
		assertArrayEquals(new int[][] { { 1, 0, 1 }, { 0, 1, 2 }, { 1, 2, 3 } }, inputMatrix2.transposeMatrix());
	}

	@Test
	public void symmetricTest() {
		SparseMatrix inputMatrix = new SparseMatrix(new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } });
		assertEquals(true, inputMatrix.symmetricMatrix());
		SparseMatrix inputMatrix1 = new SparseMatrix(new int[][] { { 0, 1, 0 }, { 2, 0, 0 }, { 0, 3, 0 } });
		assertEquals(false, inputMatrix1.symmetricMatrix());
	}

	@Test
	public void addTest() {
		SparseMatrix inputMatrix1 = new SparseMatrix(new int[][] { { 0, 1, 0 }, { 1, 0, 4 }, { 0, 3, 0 } });
		SparseMatrix inputMatrix2 = new SparseMatrix(new int[][] { { 0, 1, 0 }, { 2, 0, 0 }, { 0, 3, 0 } });
		assertArrayEquals(new int[][] { { 0, 1, 2 }, { 1, 0, 3 }, { 1, 2, 4 }, { 2, 1, 6 } }, inputMatrix1.addMatrices(inputMatrix2));
	}

	@Test
	public void multiplyTest() {
		SparseMatrix inputMatrix1 = new SparseMatrix(new int[][] { { 0, 1, 0 }, { 1, 0, 4 }, { 0, 3, 0 } });
		SparseMatrix inputMatrix2 = new SparseMatrix(new int[][] { { 0, 1, 0 }, { 2, 0, 0 }, { 0, 3, 0 } });
		assertArrayEquals(new int[][] { { 0, 0, 2 }, { 1, 1, 13 }, { 2, 0, 6 } }, inputMatrix1.multiplyMatrix(inputMatrix1, inputMatrix2));
	}

}
