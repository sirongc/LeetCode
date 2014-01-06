package second_round;

public class SearchinRotatedSortedArrayII {
	public static void main(String[] args) {
		int[] A = {3,4,5,6,7,1,2,3,3,3};
		System.out.println(search(A, 1));
	}
	public static boolean search(int[] A, int target) {
	    return search(A, 0, A.length-1, target);     
	}

	private static boolean search(int[] A, int lo, int hi, int target) {
	    if (lo > hi) return false;
	    int mid = (lo + hi) / 2;
	    if (A[mid] == target) return true;

	    if (A[mid] > A[lo]) {
	        if (target < A[mid] && target >= A[lo])
	            return search(A, lo, mid-1, target);
	        else
	            return search(A, mid+1, hi, target);
	    } else if (A[mid] < A[lo]) {
	        if (target > A[mid] && target <= A[hi])
	            return search(A, mid+1, hi, target);
	        else
	            return search(A, lo, mid-1, target);
	    }else {
	        if (A[mid] != A[hi])
	            return search(A, mid+1, hi, target);
	        else {
	            if (search(A, lo, mid-1, target)) return true;
	            else return search(A, mid+1, hi, target);
	        }
	    }
	}
}
