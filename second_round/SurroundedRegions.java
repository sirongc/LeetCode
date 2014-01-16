package second_round;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	public static void main(String[] args) {
		char[][] board = {{'X', 'X', 'X', 'X'},{'X', 'O', 'O', 'X'},{'X', 'X', 'O', 'X'},{'X', 'O', 'X', 'X'}};
		solve(board);
		for (char[] a: board) {
			for (char b: a)
				System.out.print(b + " ");
			System.out.println();
		}
	}
	
	public static void solve(char[][] board) {
	    if(board == null || board.length == 0) return;
	    int m = board.length, n = board[0].length;
	    for(int i = 0; i < n; i++) {bfs(0, i, board); bfs(m - 1, i, board);}
	    for(int j = 1; j < m- 1; j++) {bfs(j, 0, board); bfs(j, n - 1, board);}
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            if(board[i][j] == 'O') board[i][j] = 'X';
	            else if(board[i][j] == '+') board[i][j] = 'O';
	}
	public static void bfs(int i, int j, char[][] board){
	    Queue<Integer> q = new LinkedList<Integer>(); 
	    visit(i, j, q, board);
	    while(!q.isEmpty()){
	        int cur = q.poll();
	        int t = cur / board[0].length;
	        int s = cur % board[0].length;
	        visit(t - 1, s, q, board);
	        visit(t, s - 1, q, board);
	        visit(t + 1, s, q, board);
	        visit(t, s + 1, q, board);
	    }
	}
	public static void visit(int i, int j, Queue<Integer> q, char[][] board){
	    int m = board.length, n = board[0].length;
	    if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
	    board[i][j] = '+';
	    q.offer(i * n + j);
	}
	/**
	public static void solve(char[][] board) {
	    if (board.length == 0) return;
	    for (int i = 0; i < board.length; i++) {
	        if (board[i][0] == 'O') bfsReplace(board, i, 0);
	        if (board[i][board[0].length-1] == 'O') bfsReplace(board, i, board[0].length-1);
	    }

	    for (int i = 0; i < board[0].length; i++) {
	        if (board[0][i] == 'O') bfsReplace(board, 0, i);
	        if (board[board.length-1][i] == 'O') bfsReplace(board, board.length-1, i);
	    }

	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            if (board[i][j] == 'O') board[i][j] = 'X';
	            if (board[i][j] == 'I') board[i][j] = 'O';
	        }
	    }
	}

	private static void bfsReplace(char[][] board, int x, int y) {
	    Queue<Integer> queue = new LinkedList<Integer>();
	    int len = board[0].length;
	    queue.add(x * len + y);
	    while (queue.size() != 0) {
	        int cur = queue.poll();
	        x = cur / len; y = cur % len;
	        board[x][y] = 'I';
	        if (x-1 >= 0 && board[x-1][y] =='O')
	            queue.add((x-1) * len + y);
	        if (x+1 < board.length && board[x+1][y] =='O')
	            queue.add((x+1) * len + y);
	        if (y-1 >= 0 && board[x][y-1] =='O')
	            queue.add(x * len + (y-1));
	        if (y+1 < board[0].length && board[x][y+1] =='O')
	            queue.add(x * len + (y+1));
	    }
	}
	
	public static void solve2(char[][] board) {
	    if (board.length == 0) return;
	    boolean[][] isVisited = new boolean[board.length][board[0].length];
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            if (isVisited[i][j]) continue;
	            if (board[i][j] == 'O' && !touchBoard(board, i, j, isVisited)) {
	                capture(board, i, j);
	            }
	        }
	    }
	}
**/
	private static void capture(char[][] board, int x, int y) {
	    board[x][y] = 'X';
	    if (x - 1 >= 0 && board[x - 1][y] == 'O')
	        capture(board, x - 1, y);
	    if (x + 1 < board.length && board[x + 1][y] == 'O')
	        capture(board, x + 1, y);
	    if (y - 1 >= 0 && board[x][y - 1] == 'O')
	        capture(board, x, y - 1);
	    if (y + 1 < board[0].length && board[x][y + 1] == 'O')
	        capture(board, x, y + 1);
	}  

	private static boolean touchBoard(char[][] board, int x, int y, boolean[][] isVisited) {
	    if (x == 0 || x == board.length-1 || y == 0 || y == board[0].length-1) return true;
	    isVisited[x][y] = true;
	    if (x - 1 >= 0 && board[x - 1][y] == 'O' && !isVisited[x - 1][y])
	        if (touchBoard(board, x - 1, y, isVisited)) return true;
	    if (x + 1 < board.length && board[x + 1][y] == 'O' && !isVisited[x + 1][y])
	        if (touchBoard(board, x + 1, y, isVisited)) return true;
	    if (y - 1 >= 0 && board[x][y - 1] == 'O' && !isVisited[x][y - 1])
	        if (touchBoard(board, x, y - 1, isVisited)) return true;
	    if (y + 1 < board[0].length && board[x][y + 1] == 'O' && !isVisited[x][y + 1])
	        if (touchBoard(board, x, y + 1, isVisited)) return true;
	    return false;
	}

}
