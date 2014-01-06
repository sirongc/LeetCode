package second_round;

public class SudokuSolver {
	public void solveSudoku(char[][] board) { 
		if (board == null) return;
		solveSudokuHelper(board);
	}

	public boolean solveSudokuHelper(char[][] board) { 
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            if (board[i][j] == '.') {
	                for (int k = 0; k < board.length; k++) {
	                	board[i][j] = (char)('1' + k);
	                    if (isValid(board, i, j) && solveSudokuHelper(board)) return true;;
	                    board[i][j] = '.';
	                }
	                return false;
	            } 
	        }
	    }
	    return true;
	}

	private boolean isValid(char[][] board, int x, int y) {
	    for (int i = 0; i < board.length; i++) {
	        if (y == i) continue;
	        if (board[x][y] == board[x][i]) return false;
	    }

	    for (int i = 0; i < board.length; i++) {
	        if (x == i) continue;
	        if (board[x][y] == board[i][y]) return false;
	    }

	    int startX = (x / 3) * 3;
	    int startY = (y / 3) * 3;
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (x == startX + i && y == startY + j) continue;
	            if (board[startX + i][startY + j] == board[x][y]) return false;
	        }
	    }
	    return true;
	}
}
