package second_round;

public class FlattenBinaryTreetoLinkedList {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n2.left = n3;
		n2.right = n4;
		n1.right = n5;
		n5.right = n6;
		flatten(n1);
		System.out.println(1);
	}
	
    public static void flatten(TreeNode root) {
    	if (root == null) return;
        flatten(root.right);
        flatten(root.left);  
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.right = left;
        root.left = null;
        if (left == null) root.right = right;
        else {
        	while (left.right != null) left = left.right;
        	left.right = right;
        }     
    }
}
