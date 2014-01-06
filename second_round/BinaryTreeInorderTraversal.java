package second_round;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = root;
	    while (!stack.isEmpty() || cur != null) {
	        if (cur != null) {
	            stack.add(cur);
	            cur = cur.left;
	        } else {
	            cur = stack.pop();
	            res.add(cur.val);
	            cur = cur.right;
	        }
	    }      
	    return res;
	}

}
