package second_round;

import java.util.Stack;

public class LargestRectangleinHistogram {
	public static void main(String[] args) {
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
	}
	
	public static int largestRectangleArea(int[] height) {
	    Stack<Integer> stack = new Stack<Integer>();
	    int[] H = new int[height.length + 1];
	    System.arraycopy(height, 0, H, 0, height.length);
	    int max = 0;
	    for (int i = 0; i < H.length; i++) {
	        if (stack.isEmpty() || H[i] >= H[stack.peek()])
	            stack.push(i);
	        else {
	            int t = stack.pop();
	            max = Math.max(max, H[t] * (stack.isEmpty() ? i : (i-stack.peek()-1)));
	            i--;
	        }
	    }
	    return max;
	}
}
