package first_round;
import java.util.Stack;


public class LongestValidParentheses {
	public static void main(String[] args){
		System.out.println(longestValidParentheses("(()"));
	}
	
    public static int longestValidParentheses(String s) {
    	if(s.length() == 0 || s == null) return 0;
    	int max = 0;
    	int start = 0;
    	while(s.charAt(start) != '(' && start < s.length()-1){
    		start++;
    	}
    	for(int i = start; i < s.length(); i++){
    		if(s.charAt(i) != '(') 
    			continue;
    		
    		int[] valid = getMaxValid(i, s);
    		max = Math.max(valid[0], max);
    		i += valid[0];
    		
    		if(max >= s.length()-i) 
    			return max;
    	}
    	
    	return max;
    }

	private static int[] getMaxValid(int i, String s) {
		int validLength = 0;
		int maxRun= 0;
		
		for(int j = i+1; j < s.length(); j++){
			maxRun++;
			if(isValid(i, j, s)){
				validLength = Math.max(validLength, j-i+1);
			}	
		}
		int[] ans = {validLength, maxRun};
		return ans;
	}

	private static boolean isValid(int i, int j, String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int k = i; k <= j; k++){
			if(s.charAt(k) == '('){
				stack.push('(');
			}else{
				if(stack.size() == 0) return false;
				else stack.pop();
			}
		}
		if(stack.size() == 0) return true;
		return false;
	}
}
