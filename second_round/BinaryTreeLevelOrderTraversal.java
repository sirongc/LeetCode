package second_round;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(17);
		root.left = n1;
		root.right = n2;
		n2.left = n3;
		n2.right = n4;
		
		ArrayList<ArrayList<Integer>> res = levelOrder(root);
		for (ArrayList<Integer> list: res) {
			for (int i: list)
				System.out.print(i + " ");
			System.out.println();
		}
		
	}
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {	 
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if (root == null) return res;    
	    ArrayList<TreeNode> front = new ArrayList<TreeNode>();
	    front.add(root);
	    while (front.size() != 0) {
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        ArrayList<TreeNode> newFront = new ArrayList<TreeNode>();
	        for (TreeNode fnode: front) {
	            list.add(fnode.val);
	            if (fnode.left != null) newFront.add(fnode.left);
	            if (fnode.right != null) newFront.add(fnode.right);
	        }
	        res.add(new ArrayList<Integer>(list));
	        front = newFront;
	    }
	    return res;      
	    
	}
}
