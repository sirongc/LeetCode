package second_round;

public class ClimbingStairs {
	
    public static void main(String[] args) {
    	System.out.print(climbStairs(38));
    }

	public static int climbStairs(int n) { 
	    if (n == 0) return 0;
	    if (n == 1) return 1;    
	    int n1 = 1;
	    int n2 = 2;
	    int n3 = n2;
	    for (int i = 3; i <= n; i++) {
	    	n3 = n1 + n2;
	    	n1 = n2;
	    	n2 = n3;
	    }
	    return n3;
	}
	
}
