package second_round;

import java.util.ArrayList;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		ArrayList<TreeNode> frontier = new ArrayList<TreeNode>();
		frontier.add(root);
		int level = 0;
		outer:
		while (frontier.size() != 0) {
			level++;
			ArrayList<TreeNode> nextlevel = new ArrayList<TreeNode>();
			for (TreeNode fn: frontier) {
				if (fn.left == null && fn.right == null) break outer;
				if (fn.left != null) nextlevel.add(fn.left);
				if (fn.right != null) nextlevel.add(fn.right);
			}
			frontier = nextlevel;		
		}
		return level;
	}
	
	
}
