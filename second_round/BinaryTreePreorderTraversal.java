package second_round;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {	  
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.add(root);

	    while (!stack.isEmpty()) {
	        TreeNode t = stack.pop();
	        res.add(t.val);
	        if (t.right != null)
	            stack.push(t.right);
	        if (t.left != null)
	            stack.push(t.left);
	    }
	    return res;
	}    
	 
	    
}
