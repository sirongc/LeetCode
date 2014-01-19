package second_round;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArrayList<TreeNode> res = generateTrees(3);
		System.out.println();
	}
	public static ArrayList<TreeNode> generateTrees(int n) { 
	    return generateTrees(1, n); 
	}

	public static ArrayList<TreeNode> generateTrees(int lo, int hi) {
	    if (lo > hi) {
	        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
	        res.add(null);
	        return res;
	    }

	    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
	    for (int k = lo; k <= hi; k++) {
	        ArrayList<TreeNode> left = generateTrees(lo, k-1);
	        ArrayList<TreeNode> right = generateTrees(k+1, hi);

	        for (int i = 0; i < left.size(); i++) {
	            for (int j = 0; j < right.size(); j++) {
	                TreeNode root = new TreeNode(k);
	                root.left = left.get(i);
	                root.right = right.get(j);
	                res.add(root);
	            }
	        }
	    }
	    return res;
	}
}
