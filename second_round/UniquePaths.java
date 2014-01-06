package second_round;

public class UniquePaths {
	public static void main(String[] args) {
		System.out.println(uniquePaths(100,100));
	}
	public static int uniquePaths(int m, int n) {
		int[][] map = new int[m][n];
		return uniquePaths(m, n, map);
	}
	
	public static int uniquePaths(int m, int n, int[][] map) {
		if (map[m-1][n-1] != 0) return map[m-1][n-1];
	    
		if (m == 1 && n == 1) return 1;  
		if (m == 1) return uniquePaths(m, n-1, map);
	    if (n == 1) return uniquePaths(m-1, n, map);
	    map[m-2][n-1] = uniquePaths(m-1,n, map);
	    map[m-1][n-2] = uniquePaths(m, n-1, map);
	    return map[m-2][n-1] + map[m-1][n-2];
	}

}
