package second_round;

public class BinaryTreeMaximumPathSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-1);
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(-2);
		TreeNode n6 = new TreeNode(-1);
		root.left = n1;
		root.right = n2;
		//n1.left = n3;
		//n1.right = n4;
		n3.left = n6;
		n2.left = n5;
		System.out.print(maxPathSum(root));
	}
	public static int maxPathSum(TreeNode root) {
	    if (root == null) return 0;
	    if (root.left == null && root.right == null) return root.val;
	    
	    if (root.left == null) {
	    	int right = maxPathSum(root.right);
	    	int onePartMax = Math.max(root.val, right);
		    return Math.max(onePartMax, right + root.val);
	    }
	    
	    if (root.right == null) {
	    	int left = maxPathSum(root.left);
	    	int onePartMax = Math.max(root.val, left);
		    return Math.max(onePartMax, left + root.val); 
	    }
	    
	    int left = maxPathSum(root.left);
	    int right = maxPathSum(root.right);
	    
	    int twoPartMax = Math.max(root.val + left, root.val + right);
	    return Math.max(Math.max(root.val, twoPartMax), left + right + root.val);
	}
	
}
