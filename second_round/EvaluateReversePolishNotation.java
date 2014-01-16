package second_round;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));
	}
	public static int evalRPN(String[] tokens) {
	    Stack<Integer> stack = new Stack<Integer>();
	    for (int i = 0; i < tokens.length; i++) {
	        if (isNumber(tokens[i])) stack.add(Integer.parseInt(tokens[i]));
	        else {
	            int a = stack.pop();
	            int b = stack.pop();
	            int c = compute(tokens[i], a, b);
	            stack.push(c);
	        }
	    }
	    return stack.pop();
	}

	private static int compute(String cal, int b, int a) {
	    if (cal.equals("+")) return a + b;
	    if (cal.equals("-")) return a - b;
	    if (cal.equals("*")) return a * b;
	    if (cal.equals("/")) return a / b;
	    return Integer.MIN_VALUE;
	}

	private static boolean isNumber(String s) {
	    try {
	        Integer.parseInt(s);
	    } catch (Exception e){
	        return false;
	    }
	    return true;
	}
}
