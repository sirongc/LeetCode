package second_round;

import java.util.ArrayList;

public class JumpGameII {
	public static void main(String[] args) {
		int[] A = {2,3,1,1,4};
		System.out.println(jump(A));
	}
	public static int jump(int[] A) {
	    if (A == null || A.length == 0) return 0;
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(0);
	    int target = A.length;
	    int step = 0;
	    while (list.size() != 0) {
	        ArrayList<Integer> next = new ArrayList<Integer>();
	        for (int par: list) {
	            for (int i = 1; i <= A[par]; i++) {
	               if (i + par == target) return step;
	               next.add(i + par);
	    
	            }
	        }
	        list = new ArrayList<Integer>(next);
	        step++;
	    }
	    return step;
	}
}
