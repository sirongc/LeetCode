package second_round;

public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
	    if (grid.length == 0 || grid == null) return 0;
	    int[][] mins = new int[grid.length][grid[0].length];
	    return minPathSum(grid, grid.length-1, grid[0].length-1, mins);
	}

	private int minPathSum(int[][] grid, int x, int y, int[][] mins) {
		if (mins[x][y] != 0) return mins[x][y];
	    if (x == 0 && y == 0) return grid[x][y];
	    if (x == 0) return grid[x][y] + minPathSum(grid, x, y-1, mins);
	    if (y == 0) return grid[x][y] + minPathSum(grid, x-1, y, mins);
	    mins[x][y-1] = minPathSum(grid, x, y-1, mins);
	    mins[x-1][y] = minPathSum(grid, x-1, y, mins);
	    return grid[x][y] + Math.min(mins[x][y-1], mins[x-1][y]);
	}

}
