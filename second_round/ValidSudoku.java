package second_round;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
	    if (board == null) return false;
	    boolean[][] rows = new boolean[board.length][board.length];
	    boolean[][] cols = new boolean[board.length][board.length];
	    boolean[][] subs = new boolean[board.length][board.length];
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            if (board[i][j] == '.') continue;
	            int c = board[i][j] - '1';
	            if (rows[i][c] || cols[j][c] || subs[(i/3) * 3 + (j/3)][c]) return false;
	            rows[i][c] = true;
	            cols[j][c] = true;
	            subs[(i/3) * 3 + (j/3)][c] = true;
	         }
	    }
	    return true;
	}
}
