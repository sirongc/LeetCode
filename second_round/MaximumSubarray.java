package second_round;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] A = {-2, 1,-3,4,-1,2,1,-5,4};
		System.out.print(maxSubArray(A));
		
	}
	
	public static int maxSubArray(int[] A) {
	    return maxSubArray(A, 0, A.length-1);
	}

	private static int maxSubArray(int[] A, int lo, int hi) {
	    if (lo > hi) return Integer.MIN_VALUE;
	    int mid = (lo + hi) / 2;
	    int left = maxSubArray(A, lo, mid-1);
	    int right = maxSubArray(A, mid+1, hi);

	    int leftSum = 0;
	    int leftMax = 0;
	    for (int i = mid-1; i >= lo; i--) {
	        leftSum += A[i];
	        if (leftSum > leftMax) leftMax = leftSum;
	    }

	    int rightSum = 0;
	    int rightMax = 0;
	    for (int i = mid + 1; i <= hi; i++) {
	        rightSum += A[i];
	        if (rightSum > rightMax) rightMax = rightSum;
	    }
	    int max = Math.max(Math.max(left, right), leftMax + rightMax + A[mid]);
	    return max;
	}
	
	public int maxSubArray2(int[] A) {    
	    if (A == null) return 0;
	    int max = Integer.MIN_VALUE;
	    int sum = 0;
	    for (int i = 0; i < A.length; i++) {
	        sum += A[i];
	        if (sum > max)
	            max = sum;
	        if (sum < 0)
	            sum = 0;
	    }
	    return max;
	}
}
