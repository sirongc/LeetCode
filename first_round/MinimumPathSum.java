package first_round;

public class MinimumPathSum {
	public static void main(String[] args){
		int[][] grid = {{1,2,3},
				        {4,5,6},
				        {1,2,3}};
		
		System.out.println(minPathSum(grid));
	}
	
    public static int minPathSum(int[][] grid) {
    	if(grid.length == 0 || grid == null) return 0;
    	int[][] answer = new int[grid.length][grid[0].length];
    	for(int i = 0; i < grid.length; i++){
    		for(int j = 0; j < grid[0].length; j++){
    			answer[i][j] = -1;
    		}
    	}
    	return helper(grid, 0, 0, answer);
    }
    
    public static int helper(int[][] grid, int x, int y, int[][] answer){
    	if(answer[x][y] != -1) return answer[x][y];
    	
    	if(x == grid.length-1  && y == grid[0].length-1){
    		answer[x][y] = grid[x][y];
    		return grid[x][y];
    	}
    	if(x == grid.length-1){
    		answer[x][y] = grid[x][y] + helper(grid, x, y+1, answer);
    		return answer[x][y];
    	}
    	if(y == grid[0].length-1){
    		answer[x][y] = grid[x][y] + helper(grid, x+1, y, answer);
    		return answer[x][y];
    	}
    	answer[x][y] = grid[x][y] + Math.min(helper(grid, x+1, y, answer), helper(grid, x, y+1, answer));
    	return answer[x][y];
    }

}
