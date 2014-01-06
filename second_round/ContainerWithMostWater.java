package second_round;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] height = {1,2,3,3};
		System.out.println(maxArea(height));
	}
	public static int maxArea(int[] height) {
	    int lo = 0;
	    int hi = height.length - 1;
	    int max = 0;
	    while (lo < hi) {
	        max = Math.max(max, size(height, lo, hi));
	        if (height[lo] < height[hi]) {
	            lo++;
	        } else {
	            hi--;
	        }
	    }
	    return max;
	}
	
	private static int size(int[] height, int lo, int hi) {
		return  Math.min(height[lo], height[hi]) * (hi - lo);
	}

}
