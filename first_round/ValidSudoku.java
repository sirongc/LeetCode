package first_round;
import java.util.HashSet;


public class ValidSudoku {
	public static void main(String[] args){
		String[] s = {"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
		char[][] board = change(s);
		System.out.println(passSubSudokuCheck(board));
	}
	
	public static char[][] change(String[] s){
		char[][] board = new char[s.length][s.length];
		for(int i = 0; i < s.length; i++){
			for(int j = 0; j < s.length; j++){
				board[i][j] = s[i].charAt(j);
			}
		}
		return board;
		
	}
    public static boolean isValidSudoku(char[][] board) {
        if(!passRowsCheck(board)) return false;
        if(!passColsCheck(board)) return false;
        if(!passSubSudokuCheck(board)) return false;
    	return true;
    }

	private static boolean passSubSudokuCheck(char[][] board) {
		HashSet<Character> set = new HashSet();
		for(int i = 0; i < board.length; i += 3){
			for(int j = 0; j < board[0].length; j += 3){
				for(int k = i; k < i + 3; k++){
					for(int m = j; m < j + 3; m++){
						if(board[k][m] == '.') continue;
						if(!set.contains(board[k][m])) 
							set.add(board[k][m]);
						else 
							return false;
					}
				}
				set.clear();
			}
		}
		return true;
	}
	

	private static boolean passColsCheck(char[][] board) {
		HashSet<Character> set = new HashSet();
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[j][i] == '.') continue;
				if(!set.contains(board[j][i])) 
					set.add(board[j][i]);
				else 
					return false;
			}
			set.clear();
		}
		return true;
	}

	private static boolean passRowsCheck(char[][] board) {
		HashSet<Character> set = new HashSet();
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == '.') continue;
				if(!set.contains(board[i][j]))
					set.add(board[i][j]);
				else 
					return false;
			}
			set.clear();
		}
		return true;
	}

}
