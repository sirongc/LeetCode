package second_round;

public class SpiralMatrixII {
	public static void main(String[] args) {
		int[][] matrix = generateMatrix(3);
		for (int[] a: matrix) {
			for (int b: a)
				System.out.print(b + " ");
			System.out.println();
		}
	
	}
	public static int[][] generateMatrix(int n) {
	    int[][] matrix = new int[n][n];
	    int top = 0;
	    int bottom = n - 1;
	    int left = 0;
	    int right = n - 1;
	    int k = 1;
	    while (left < right && top < bottom) {
	        for (int i  = left; i < right; i++)
	            matrix[top][i] = k++;
	        for (int i = top; i < bottom; i++)
	            matrix[i][right] = k++;
	        for (int i = right; i > left; i--)
	            matrix[bottom][i] = k++;
	        for (int i = bottom; i > top; i--)
	            matrix[i][left] = k++;
	        top++;
	        bottom--;
	        left++;
	        right--;
	    }
	    if (n % 2 != 0)
	        matrix[n/2][n/2] = k;
	    return matrix; 
	}
}
