package second_round;

public class Searcha2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1}};
		System.out.println(searchMatrix(matrix, 0));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
	    int i = 0;
	    int j = matrix[0].length - 1;
	    while (i < matrix.length && j >= 0) {
	        if (matrix[i][j] == target) return true;
	        else if (matrix[i][j] > target) j--;
	        else i++;
	    }   
	    while (i < matrix.length) {
	    	if (matrix[i][0] == target) return true;
	    	if (matrix[i][0] > target) return false;
	    	else i++;
	    }
	    while (j >= 0) {
	    	if (matrix[0][j] == target) return true;
	    	if (matrix[0][j] < target) return false;
	    	else j--;
	    }
	    
	    return false;
	}
}
