package second_round;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (root == null) return res;
    	ArrayList<TreeNode> frontier = new ArrayList<TreeNode>();
    	frontier.add(root);   	
    	while (frontier.size() != 0) {
    		ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		for (TreeNode fnode: frontier) {
    			list.add(fnode.val);
    			if (fnode.left != null) nextLevel.add(fnode.left);
    			if (fnode.right != null) nextLevel.add(fnode.right);
    		}
    		frontier = nextLevel;
    		res.add(0, new ArrayList<Integer>(list));
    	}
    	return res;       
    }

}
