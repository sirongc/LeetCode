package second_round;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
    	if (getHeight(root) == -1) return false;
    	return true;
    }
    
    private int getHeight(TreeNode root) {
    	if (root == null) 
    		return 0;
    	int left = getHeight(root.left);
    	if (left == -1) 
    		return -1;
    	
    	int right = getHeight(root.right);
    	if (right == -1) 
    		return -1;
    	
    	if (Math.abs(left - right) > 1) 
    		return -1;
    	
    	return Math.max(left, right) + 1;
    }
    
}
