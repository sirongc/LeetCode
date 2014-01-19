package second_round;

import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
	    if (matrix.length == 0) return 0;
	    int[][] H = new int[matrix.length][matrix[0].length];
	    
	    for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix[0].length; j++) {
	            if (matrix[i][j] == '0')
	                H[i][j] = 0;
	            else {
	                H[i][j] = i == 0 ? 1 : H[i-1][j] + 1;
	            }
	        }
	     }
	     
	     int max = 0;
	     for (int i = 0; i < H.length; i++)
	         max = Math.max(max, largestRectangleArea(H[i]));
	     return max;
	}

	public int largestRectangleArea(int[] height) {
	    Stack<Integer> stack = new Stack<Integer>();
	    int[] H = new int[height.length + 1];
	    System.arraycopy(height, 0, H, 0, height.length);
	    int max = 0;
	    for (int i = 0; i < H.length; i++) {
	        if (stack.isEmpty() || H[i] >= H[stack.peek()])
	            stack.push(i);
	        else {
	            int t = stack.pop();
	            max = Math.max(max, (H[t] * (stack.isEmpty() ? i : (i - stack.peek() - 1))));
	            i--;
	        }
	    }
	    return max;
	}
}
