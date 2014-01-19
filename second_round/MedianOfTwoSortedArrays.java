package second_round;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		int[] B = {6,7,8,9};
		System.out.println(findMedianSortedArrays(A, B));
	}
    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if ((m + n) % 2 == 0) {
        	double v1 = findKth(A, B, (m+n)/2);
        	double v2 = findKth(A, B, (m+n)/2 + 1);
        	return (v1 + v2) / 2;
        }
        return findKth(A, B, (m+n)/2+1);
    }
    
	private static int findKth(int A[] , int B[], int k) {
	    int loA = 0;
	    int loB = 0;
	    int hiA = A.length-1;
	    int hiB = B.length-1;
	    while (loA <= hiA && loB <= hiB) {
	        int midA = (loA + hiA) / 2;
	        int midB = (loB + hiB) / 2;
	        if (A[midA] <= B[midB]) {
	            if (k <= midA - loA + midB - loB + 1)
	                hiB = midB - 1;
	            else {  
	                k -= midA - loA + 1;
	                loA = midA + 1;        
	            }
	        }
	        else {
	            if (k <= midA - loA + midB - loB + 1)
	                hiA = midA - 1;
	            else {
	                k -= midB - loB + 1;
	                loB = midB + 1;
	            }
	        }
	    }
	        if (loA <= hiA)
	            return A[loA + k - 1];
	        else
	            return B[loB + k - 1];
	}
}
