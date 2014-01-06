package first_round;
import java.util.Stack;


public class ValidParentheses {
	public static void main(String[] args){
		System.out.println(isValid("["));
	}
	
    public static boolean isValid(String s) {
    	Stack<String> stack = new Stack<String>();
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		if(c == '(' || c =='[' || c =='{'){
    			stack.push(String.valueOf(c));
    		}
    		if(c == ')'){
    			if(stack.size() == 0 || stack.pop().charAt(0) != '(') return false;
    		}
    		if(c == ']'){
    			if(stack.size() == 0 || stack.pop().charAt(0) != '[') return false;
    		}
    		if(c == '}'){
    			if(stack.size() == 0 || stack.pop().charAt(0) != '{') return false;
    		}
    	}
    	if(stack.size() != 0) return false;
    	return true;
    }

}
