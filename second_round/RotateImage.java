package second_round;

public class RotateImage {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},
				          {4,5,6},
				          {7,8,9}};
		rotate(matrix);
		for (int[] y: matrix) {
			for (int x: y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix) {
	    if (matrix == null) return;
	    for (int i = 0; i < matrix.length / 2; i++) 
	        rotate(matrix, i, i, matrix.length-(2 * i));
	}

	private static void rotate(int[][] matrix, int x, int y, int length) {
	    for (int i = 0; i < length - 1; i++) {
	        int temp = matrix[x][y+i];
	        matrix[x][y+i] = matrix[x+length-i-1][y];
	        matrix[x+length-i-1][y] = matrix[x+length-1][y+length-i-1];
	        matrix[x+length-1][y+length-i-1] = matrix[x+i][y+length-1];
	        matrix[x+i][y+length-1] = temp;
	    }
	}


}
