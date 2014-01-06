package second_round;

import java.util.ArrayList;

public class NQueens {
	public static void main(String[] args) {
		ArrayList<String[]> boards = solveNQueens(8);
		for (String[] board: boards) {
			for (String line: board) {
				System.out.println(line);
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
	
	public static ArrayList<String[]> solveNQueens(int n) {
	    ArrayList<String[]> res = new ArrayList<String[]>();
	    String[] board = new String[n];
	    generate(res, board, 0, n);
	    return res;
	}

	private static void generate(ArrayList<String[]> res, String[] board, int level, int n) {
	    if (level == n) {
	    	res.add(board.clone());
	    	return;
	    }
	    for (int i = 0; i < n; i++) {
	        String nextLine = putQueen(i, n);
	        board[level] = nextLine;
	        if (isValid(board, level)) generate(res, board, level + 1, n);
	        board[level] = null;
	    }
	}

	private static boolean isValid(String[] board, int lastLine) {	    
	    int qy = 0;
	    for (int i = 0; i < board[lastLine].length(); i++) {
	        if (board[lastLine].charAt(i) == 'Q') qy = i;
	    }

	    for (int i = 0; i < lastLine; i++) {
	        if (board[i].charAt(qy) == 'Q') return false;
	    }

	    int x = lastLine;
	    int y_left = qy;
	    while (x > 0 && y_left > 0) {
	        if (board[--x].charAt(--y_left) == 'Q') return false;
	    }

	    x = lastLine;
	    int y_right = qy;
	    while (x > 0 && y_right < board.length-1) {
	        if (board[--x].charAt(++y_right) == 'Q') return false;
	    }
	    return true;
	}
	          

	private static String putQueen(int q, int length) {
	    StringBuilder line = new StringBuilder();
	    for (int i = 0; i < length; i++) {
	        if (i == q) line.append('Q');
	        else line.append('.');
	    }
	    return line.toString();
	}

}
