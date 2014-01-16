package second_round;

public class SumRoottoLeafNumbers {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(9);
		TreeNode n4 = new TreeNode(9);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(5);
		n1.left = n2;
		n2.right = n3;
		n3.left = n4;
		n3.right = n5;
		n1.right = n6;
		
		System.out.println(sumNumbers(n1));
	}
	public static int sumNumbers(TreeNode root) {
		if (root == null) return 0;
	    int[] totalSum = new int[1];
	    sum(root, 0, totalSum);
	    return totalSum[0];
	}

	private static void sum(TreeNode root, int sum, int[] totalSum) {
	    if (root.left == null && root.right == null) {
	    	totalSum[0] += sum * 10 + root.val; 
	    	return;
	    }
        if (root.left != null)
        	sum(root.left, sum * 10 + root.val, totalSum);
        if (root.right != null)
        	sum(root.right, sum * 10 + root.val, totalSum);
	}
}
