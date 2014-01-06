package second_round;

public class LongestValidParentheses {
	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()"));
	}
	public static int longestValidParentheses(String s) {
		if (s == null) return 0;
	    int left = 0;
	    int right = 0;
	    int max = 0;
	    for (int i = 0; i < s.length(); i ++) {
	    	
	        if (s.charAt(i) == ')') {
	            if (right < left) {
	            	right++;
	            	if (left == right) max = Math.max(max, 2 * left);
	            }
	            else {
	                max = Math.max(max, 2 * left);
	                left = 0;
	                right = 0;
	            }
	        } else left++;
	    }
	    
	    left = 0;
	    right = 0;
	    for (int i = s.length()-1; i >=0; i--) {
	    	if (s.charAt(i) == '(') {
	    		if (right > left) left++;
	    		else {
	    			max = Math.max(max, 2 * right);
	    			left = 0;
	    			right = 0;
	    		}
	    	} else right++;
	    }
	    return max;
	}
}
