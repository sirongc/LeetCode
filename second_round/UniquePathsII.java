package second_round;

public class UniquePathsII {
	public static void main(String[] args) {
		int[][] obstacleGrid = {{0,1}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] map = new int[obstacleGrid.length][obstacleGrid[0].length];
	    return uniquePaths(obstacleGrid.length-1, obstacleGrid[0].length-1, obstacleGrid, map);
	}

	private static int uniquePaths(int x, int y, int[][] obstacleGrid, int[][] map) {
		if (x < 0 || y < 0) return 0;
		if (map[x][y] != 0) return map[x][y];
		if (obstacleGrid[x][y] == 1) return 0;
	    if (x == 0 && y == 0) return 1;
	    if (x == 0) {
	    	if (obstacleGrid[x][y-1] != 1)
	    		return uniquePaths(x, y-1, obstacleGrid, map);
	    	else 
	    		return 0;
	    }
	    if (y == 0){
	    	if (obstacleGrid[x-1][y] != 1)
	    		return uniquePaths(x-1, y, obstacleGrid, map);
	    	else
	    		return 0;
	    }

	    if (obstacleGrid[x][y-1] != 1) map[x][y-1] = uniquePaths(x, y-1, obstacleGrid, map);
	    if (obstacleGrid[x-1][y] != 1) map[x-1][y] = uniquePaths(x-1, y, obstacleGrid, map);
	    return map[x][y-1] + map[x-1][y];
	}
}
