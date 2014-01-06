package second_round;

public class RemoveDuplicatesfromSortedArrayII {
	public static void main(String[] args) {
		int[] A = {1,1,1,2,2,2,2,3,3,3,3};
		System.out.print(removeDuplicates(A));
	}
	public static int removeDuplicates(int[] A) {
	    if (A.length < 2) return A.length;
	    int cur = 1;
	    for (int i = 2; i < A.length; i++) {
	        if (A[i] == A[cur] && A[i] == A[cur-1]) continue;
	        A[++cur] = A[i];
	    }
	    return cur + 1;
	}
}
