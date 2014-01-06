package second_round;

import java.util.ArrayList;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		ArrayList<Integer> res = spiralOrder(matrix);
		for (int i: res) System.out.print(i + " ");
	}
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {	
		
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    int m = matrix.length;
	    if (m == 0) return res;
	    if (m == 1) {
	    	for (int x: matrix[0]) res.add(x);
	    	return res;
	    }
	    int n = matrix[0].length;
	    for (int i = 0; i < n / 2; i++) {
	    	generateSpiral(res, matrix, i, i, m - (2 * i), n - (2 * i));
	    }
	        
	    if (n <= m && n % 2 != 0) {
	    	for (int i = 0; i < m - (n/2)*2; i++)
	    	res.add(matrix[n/2+i][n/2]);
	    }
	    
	    return res;    	    
	}

	private static void generateSpiral(ArrayList<Integer> res, int[][] matrix, int x, int y, int m, int n) {
	    for (int i = 0; i < n - 1; i++) {
	    	if (x >= m || y >=n) continue;
	    	res.add(matrix[x][y+i]);
	    }
	        
	    for (int i = 0; i < m - 1; i++) {
	    	if (x >= m || y >=n) continue;
	    	res.add(matrix[x+i][y+n-1]);
	    }
	        
	    for (int i = 0; i < n - 1; i++) {
	    	if (x >= m || y >=n) continue;
	    	res.add(matrix[x+m-1][y+n-1-i]);
	    }
	        
	    for (int i = 0; i < m - 1; i++) {
	    	if (x >= m || y >=n) continue;
	    	res.add(matrix[x+m-1-i][y]);
	    }
	        
	}
}
