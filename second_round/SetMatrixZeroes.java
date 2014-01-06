package second_round;

public class SetMatrixZeroes {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,0}
		                 ,{0,2,1}
		                 ,{2,2,2}};
		             
		setZeroes(matrix);
		for (int[] x: matrix) {
			for (int y: x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}
	public static void setZeroes(int[][] matrix) {

	    boolean row0 = false;
	    boolean col0 = false;        
	    
	    for (int i = 0; i < matrix.length; i++) { 
	        for (int j = 0 ; j < matrix[0].length; j++) {
	            if (matrix[i][j] == 0) {
	                matrix[i][0] = 0;
	                matrix[0][j] = 0;
		            if (i == 0) row0 = true;
		            if (j == 0) col0 = true;
	            }
	        }
	    }

	    for (int i = 1; i < matrix.length; i++) { 
	        for (int j = 1 ; j < matrix[0].length; j++) {
	            if (matrix[i][0] == 0 || matrix[0][j] == 0)
	                matrix[i][j] = 0;
	        }
	    }
	    if (row0) 
	        for (int i = 0; i < matrix[0].length; i++)
	            matrix[0][i] = 0;
	    if (col0)
	        for (int i = 0; i < matrix.length; i++)
	            matrix[i][0] = 0;
	}
}
