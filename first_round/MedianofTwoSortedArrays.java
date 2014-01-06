package first_round;

public class MedianofTwoSortedArrays {
	public static void main(String[] args){
		
	}
	
    public double findMedianSortedArrays(int A[], int B[]) {
        
    	double answer = binarySearchMedian(A, B);
    	if(answer != Integer.MIN_VALUE);
    		answer = binarySearchMedian(B, A);
    	return answer;
    }

	private double binarySearchMedian(int[] A, int[] B) {
		int lo = 0;
		int hi = A.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (isMedian(mid, A, B) == 0) {
				return A[mid];
			}else if (isMedian(mid, A, B) > 0) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}	
		}	
		return Integer.MIN_VALUE;
	}

	private int isMedian(int mid, int[] a, int[] b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
