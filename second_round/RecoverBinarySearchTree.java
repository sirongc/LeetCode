package second_round;

import java.util.ArrayList;

public class RecoverBinarySearchTree {
	public static void main(String[] args){
		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(1);
		root.left = left;
		//root.right = right;
		recoverTree(root);
		
	}
	public static void recoverTree(TreeNode root) {
		if (root == null) return;
		ArrayList<TreeNode> errorNodes = new ArrayList<TreeNode>();
		findErrorNodes(root, errorNodes, false);
		if (errorNodes.size() != 0){
			TreeNode first = errorNodes.get(0);
			TreeNode last = errorNodes.get(errorNodes.size() - 1);
			int temp = first.val;
			first.val = last.val;
			last.val = temp;
		}
	
	}
	
    public static void findErrorNodes(TreeNode root, ArrayList<TreeNode> errorNodes, boolean isSwapped) {
    	if (root == null) return;
        boolean leftIsSwapped = false;
        boolean rightIsSwapped = false;
    	if (isSwapped) 
    		errorNodes.add(root);
    	
    	if (root.left != null && root.val < root.left.val) {
    		leftIsSwapped = true;
    	}

    	if (root.right != null && root.val > root.right.val) {
    		rightIsSwapped = true;
    	}
    	
    	findErrorNodes(root.left, errorNodes, leftIsSwapped);
    	findErrorNodes(root.right, errorNodes, rightIsSwapped);
    }
}
