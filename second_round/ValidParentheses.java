package second_round;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
	    if (s == null) return false;
	    Stack<Character> stack = new Stack<Character>();
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == '(') stack.push('(');
	        if (s.charAt(i) == '{') stack.push('{');
	        if (s.charAt(i) == '[') stack.push('[');
	        if (s.charAt(i) == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
	        if (s.charAt(i) == '}' && (stack.isEmpty() || stack.pop() != '{')) return false; 
	        if (s.charAt(i) == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
	    }
	    return stack.isEmpty();  
	}
}
