package first_round;


public class UniquePath {
	public static void main(String[] args){
		System.out.println(uniquePaths(100,100));
	}
	
	public static int uniquePaths2(int m, int n) {
	    int[] steps = new int[n];
	    steps[n - 1] = 1;
	    for(int i = 0; i < m + n - 2; i++) {
	        for(int j = 0; j < n; j++) {
	            if(j + 1 < n)
	                steps[j] = steps[j] + steps[j + 1];
	        }
	    }

	    return steps[0];
	}
	
	
    public static int uniquePaths(int m, int n, int[][] map) {
    	if(m == 1 && n == 1){
    		return 1;
    	}
    	if(m < 1 || n < 1){
    		return 0;
    	}
    	if(map[m-1][n] == 0){
    		map[m-1][n] = uniquePaths(m-1, n, map);
    	}
    	if(map[m][n-1] == 0){
    		map[m][n-1] = uniquePaths(m, n-1, map);
    	}
    	
    	return map[m-1][n] + map[m][n-1];  

    }
    
	
    public static int uniquePaths(int m, int n) {
    	int[][] map = new int[m+1][n+1];
    	return uniquePaths(m, n, map);
    }

}
