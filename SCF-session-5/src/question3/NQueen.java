package question3;

public class NQueen {
	
	int[][] chessBoard;
	public NQueen() {
	
	}
	/**
	 * Checks that the specified position is safe or not for placing Queen
	 * @param board all elements of board are initially initialized to zero
	 * @param row index of row where queen is placed
	 * @param column index of column where queen is placed
	 * @param dimensionOfChessBoard 
	 * @return returns true if specified position is safe or false if specified position is not safe
	 */
	public boolean isSafe(int[][] board,int row,int column,int dimensionOfChessBoard) {
		chessBoard=board;
		//check if Queen is present in same column
		for(int i=0;i<row;i++) {
			if(chessBoard[i][column]==1) {
				return false;
			}
		}
		//check if Queen is present in upper left diagonal
		for(int i=row,j=column;i>=0&&j>=0;i--,j--) {
			if(chessBoard[i][j]==1) {
				return false;
			}
		}
		//check if Queen is present in upper right diagonal
		for(int i=row,j=column;i>=0&&j<dimensionOfChessBoard;i--,j++) {
			if(chessBoard[i][j]==1) {
				return false;
			}
		}
		return true;
	}
	/**
	 * The N Queen is the problem of placing N chess queens on an N×N chess board 
	 * so that no two queens attack each other.
	 * @param board board all elements of board are initially initialized to zero 
	 * @param startRow 
	 * @param dimensionOfChessBoard
	 * @return
	 */
	
	public boolean nQueen(int[][] board,int startRow,int dimensionOfChessBoard) {
		chessBoard=board;
		
		if(startRow>=dimensionOfChessBoard) {
			//print final queens location
			for(int i=0;i<dimensionOfChessBoard;i++){
				for(int j=0;j<dimensionOfChessBoard;j++){
					System.out.print(chessBoard[i][j]+" ");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
			
			return true;
			
		}
		for(int i=0;i<dimensionOfChessBoard;i++) {
			if(isSafe(chessBoard,startRow,i,dimensionOfChessBoard)) {
				chessBoard[startRow][i]=1;
				if(nQueen(chessBoard,startRow+1,dimensionOfChessBoard)) {
					return true;
				}
				chessBoard[startRow][i]=0;
			}
		}
		return false;
	}
	
}