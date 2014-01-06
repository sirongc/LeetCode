package second_round;

public class UniqueBinarySearchTrees {
	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
	public static int numTrees(int n) {
	    if (n == 0) return 0; 
	    if (n == 1) return 1;
	    int sum = 0;
	    for (int i = 1; i <= n; i++) {
	    	int left = numTrees(i-1);
	    	int right = numTrees(n-i);
	    	if (left == 0)
	    		sum += right;
	    	else if (right == 0)
	    		sum += left;
	    	else
	    		sum += left * right;
	    }
	    return sum;      	    
	}

}
