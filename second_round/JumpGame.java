package second_round;

public class JumpGame {
	public static void main(String[] args) {
		int[] A = {3,2,1,0,4};
		System.out.println(canJump(A));
	}
	public static boolean canJump(int[] A) {
	    if (A == null || A.length == 0) return false;
	    int max = 0;
	    for (int i = 0; i < A.length; i++) {
	        if (i > max) return false;
	        max = Math.max(max, i + A[i]);
	    }
	    return true;
	}

}
