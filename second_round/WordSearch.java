package second_round;

public class WordSearch {
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ADEE";
		System.out.println(exist(board, word));
	}
	
	public static boolean exist(char[][] board, String word) {
	    if (word.length() == 0) return false;
	    boolean[][] isUsed = new boolean[board.length][board[0].length];
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            if (board[i][j] == word.charAt(0)) {
	            	isUsed[i][j] = true;
	                if (exist(board, "" + board[i][j], 1, word, i, j, isUsed)) return true;
	                isUsed[i][j] = false;
	            }
	        }
	    }
	    return false;   
	}

	private static boolean exist(char[][] board, String S, int step, String word, int x, int y, boolean[][] isUsed) {
	    if (S.equals(word)) return true;
	    if (step >= word.length()) return false;
	    if (x > 0 && !isUsed[x-1][y] && board[x-1][y] == word.charAt(step)) {
	        isUsed[x-1][y] = true;
	        if (exist(board, S + word.charAt(step), step + 1, word, x - 1, y, isUsed)) return true;
	        isUsed[x-1][y] = false;
	    }

	    if (x < board.length - 1 && !isUsed[x+1][y] && board[x+1][y] == word.charAt(step)) {
	        isUsed[x+1][y] = true;
	        if (exist(board, S + word.charAt(step), step + 1, word, x + 1, y, isUsed)) return true;
	        isUsed[x+1][y] = false;
	    }

	    if (y > 0 && !isUsed[x][y-1] && board[x][y-1] == word.charAt(step)) {
	        isUsed[x][y-1] = true;
	        if (exist(board, S + word.charAt(step), step + 1, word, x, y - 1, isUsed)) return true;
	        isUsed[x][y-1] = false;
	    }

	    if (y < board[0].length - 1 && !isUsed[x][y+1] && board[x][y+1] == word.charAt(step)) {
	        isUsed[x][y+1] = true;
	        if (exist(board, S + word.charAt(step), step + 1, word, x, y + 1, isUsed)) return true;
	        isUsed[x][y+1] = false;
	    }
	    return false;
	}
	    
}
