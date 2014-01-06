package first_round;
public class BalancedBinaryTree {
	public static void main(String[] args) {
		/**
		 *            2
		 *            /\
		 *           2 3
		 *          /\  /\
		 *          4
		 *         /
		 *        2
 		 * 
		 */
		
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		TreeNode leftleft = new TreeNode(2);
		TreeNode leftleftleft = new TreeNode(2);
		
		root.left = left;
		root.right = right;
		left.left = leftleft;
		leftleft.left = leftleftleft;
		System.out.println(isBalanced(root));

	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		} else if (!isBalanced(root.left) || !isBalanced(root.right)) {
			return false;
		}
		return true;
	}

	public static int height(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (root.left == null)
			return height(root.right) + 1;
		if (root.right == null)
			return height(root.left) + 1;
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
