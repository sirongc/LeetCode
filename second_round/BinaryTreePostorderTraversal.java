package second_round;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
     	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(root == null) return list;
    	Stack<TreeNode> stack = new Stack<TreeNode>();    
    	stack.add(root);
    	while(!stack.isEmpty()){
    		TreeNode node = stack.pop();
    		list.add(0, node.val);
    		if (node.left != null)
    			stack.push(node.left);
    		if(node.right != null)
    			stack.push(node.right);
    	}
    	return list;
    }
}
