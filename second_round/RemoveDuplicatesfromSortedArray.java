package second_round;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
	    if (A == null || A.length == 0) return 0;
	    int j = 0;
	    for (int i = 0; i < A.length; i++) {
	        if (A[i] == A[j]) continue;
	        A[++j] = A[i];
	    }
	    return j + 1;  
	}
}
