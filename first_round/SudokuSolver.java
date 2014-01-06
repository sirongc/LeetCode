package first_round;
import java.util.HashSet;


public class SudokuSolver {
	public static void main(String[] args){
		char[][] A={{'5','3','.','.','7','.','.','.','.'},
				    {'6','.','.','1','9','5','.','.','.'},
				    {'.','9','8','.','.','.','.','6','.'},
				    {'8','.','.','.','6','.','.','.','3'},
				    {'4','.','.','8','.','3','.','.','1'},
				    {'7','.','.','.','2','.','.','.','6'},
				    {'.','6','.','.','.','.','2','8','.'},
				    {'.','.','.','4','1','9','.','.','5'},
				    {'.','.','.','.','8','.','.','7','9'}};
		
		solveSudoku(A);
	}
	
    public static void solveSudoku(char[][] board) {
    	
    	while(notSolved(board)){
    		label:
    		for(int i = 0; i < board.length; i++){
    			for(int j = 0; j < board[0].length; j++){
    				if(board[i][j] == '.'){
    					char answer = isUnique(board, i, j);
    					if(answer != '.'){
    						board[i][j] = answer;
    						break label;
    					}
    				}
    			}
    		}
    	}
    }
    
    private static boolean notSolved(char[][] board) {
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == '.') return true;
			}
		}
		return false;
	}

	public static char isUnique(char[][] board, int x, int y) {
    	HashSet<Character> set = new HashSet<Character>();
    	for(int i = 0; i < board.length; i++) {
    		if(board[i][x] != '.' && !set.contains(board[i][x])) {
    			set.add(board[i][x]);
    		}
    	}
    	
    	for(int i = 0; i < board[0].length; i++) {
    		if(board[y][i] != '.' && !set.contains(board[y][i])) {
    			set.add(board[y][i]);
    		}
    	}
    	
    	int sublength = (int)Math.sqrt(board.length);
    	int origx = (x / sublength) * sublength;
    	int origy = (y / sublength) * sublength;
    	for(int i = 0; i < sublength; i++){
    		for(int j = 0; j < sublength; j++){
    			char temp = board[origy + j][origx + i];
    			if(temp != '.' && !set.contains(temp)){
    				set.add(temp);
    			}
    		}
    	}
    	
    	if(set.size() == board.length - 1){
    		for(int i = 1; i <= board.length; i++){
    			if(!set.contains((char)('0' + i)))
    				return (char)('0' + i);
    		}
    	}
    	return '.';
    }

}
