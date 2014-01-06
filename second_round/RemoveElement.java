package second_round;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
	    if (A == null || A.length == 0) return 0;
	    int j = 0;
	    for (int i = 0; i < A.length; i++) {
	        if (A[i] == elem) continue;
	        A[j++] = A[i];
	    }
	    return j++;            
	}
}
