package second_round;

public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] A = {1};
		System.out.println(firstMissingPositive(A));
	}
	public static int firstMissingPositive(int[] A) {
	    if (A == null || A.length == 0) return 1;
	    for (int i = 0; i < A.length; i++) {
	        while (A[i] >= 1 && A[i] <= A.length) {
	            if (A[i] == i + 1 || A[i] == A[A[i] - 1]) break;
	            int temp = A[A[i] - 1];
	            A[A[i] - 1] = A[i];
	            A[i] = temp;
	        }
	    }
	    for (int i = 0; i < A.length; i++) {
	        if (A[i] != i + 1) return i + 1;
	    }
	    return A.length + 1;
	}
}
