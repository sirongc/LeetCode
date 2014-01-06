package second_round;

public class SearchinRotatedSortedArray {
	public static void main(String[] args) {
		int[] A = {3,1};
		int target = 1;
		System.out.println(search(A, target));
	}
	public static int search(int[] A, int target) {
	    if (A == null) return -1;
	    int lo = 0;
	    int hi = A.length - 1;
	    while (lo <= hi) {
	    	int mid = (lo + hi) / 2;
	        if (target == A[mid]) return mid;
	        if (A[mid] >= A[lo]) {
	            if (A[mid] > target && A[lo] <= target) hi = mid - 1;
	            else lo = mid + 1;
	        } else {
	            if (A[mid] < target && A[hi] >= target) lo = mid + 1;
	            else hi = mid - 1;
	        }
	    }
	    return -1; 
	}

}
