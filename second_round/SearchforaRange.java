package second_round;

public class SearchforaRange {
	
	public int[] searchRange(int[] A, int target) {
	    if (A == null) return null;
	    int[] ans = {-1,-1};
	    int lo = search(A, target - 0.5);
	    if (lo >= A.length || A[lo] != target) return ans; 
	    ans[1] = search(A, target + 0.5) - 1;
	    return ans;
	}

	private int search(int[] A, double target) {
	    int lo = 0;
	    int hi = A.length - 1;
	    while (lo <= hi) {
	        int mid = (lo + hi) / 2;
	        if (A[mid] < target) lo = mid + 1;
	        else hi = mid - 1;
	    }
	    return lo;
	}


}
