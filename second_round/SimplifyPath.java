package second_round;

import java.util.Stack;

public class SimplifyPath {
	public static void main(String[] args) {
		System.out.println(simplifyPath("/.."));
	}
	public static String simplifyPath(String path) {
	    String[] split = path.split("/");
	    Stack<String> stack = new Stack<String>();
	    for (String s: split) {
	        if (s.equals(".") || s.equals("")) continue;
	        if (s.equals("..")) {
	            if(!stack.isEmpty())
	        	    stack.pop();
	        }
	        else stack.push(s);
	    }
	    StringBuilder sb = new StringBuilder();
	    while (!stack.isEmpty())
	        sb.insert(0, "/" + stack.pop());
	    return sb.length() == 0 ? "/" : sb.toString();
	}
}
