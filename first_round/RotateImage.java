package first_round;

public class RotateImage {
	//123
	//456
	//789
	
	//741
	//852
	//963
	
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4},
		          {5,6,7,8},
		          {9,10,11,12},
		          {13,14,15,16}};
		
		
		rotate(matrix);
		for(int[] a: matrix){
			for(int b: a){
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
	
    public static void rotate(int[][] matrix) {
    	for(int i = 0; i < matrix.length/2; i++){
    		rotate(matrix, i, i, matrix.length - (2 * i));
    	}
    }
	
    public static void rotate(int[][] matrix, int x, int y, int length) {
    	if(length <= 1) return;
    	int[] temp = new int[length - 1];
    	for(int i = 0; i < temp.length; i++){
    		temp[i] = matrix[x][y+1+i];
    	}
    	
    	for(int i = 0; i < temp.length; i++){
    		matrix[x][y+1+i] = matrix[x+length-2-i][y];
    	}
    	
    	for(int i = 0; i < temp.length; i++){
    		matrix[x+length-2-i][y] = matrix[x+length-1][y+length-2-i];
    	}
    	
    	for(int i = 0; i < temp.length; i++){
    		matrix[x+length-1][y+length-2-i] = matrix[x+1+i][y+length-1];
    	}
    	
    	for(int i = 0; i < temp.length; i++){
    		matrix[x+1+i][y+length-1] = temp[i];
    	}
    }
}
