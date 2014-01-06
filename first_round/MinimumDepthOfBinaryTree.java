package first_round;
import java.util.ArrayList;


public class MinimumDepthOfBinaryTree {
	public static void main(String[] args){
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		TreeNode leftleft = new TreeNode(2);
		TreeNode leftleftleft = new TreeNode(2);
		
		root.left = left;
		root.right = right;
		left.left = leftleft;
		leftleft.left = leftleftleft;
		System.out.println(minDepth(root));
	}
	
    public static int minDepth(TreeNode root) {
    	if(root == null) return 0;
    	ArrayList<TreeNode> frontier = new ArrayList<TreeNode>();
    	frontier.add(root);
    	int level = 1;
    	
    	while(!frontier.isEmpty()){
    		ArrayList<TreeNode> nextLevelNodes = new ArrayList<TreeNode>();
    		for(TreeNode node: frontier){
    			if(node.left == null && node.right == null) return level;
    			if(node.left != null) nextLevelNodes.add(node.left);
    			if(node.right != null) nextLevelNodes.add(node.right);
    		}
    		frontier = nextLevelNodes;
    		level++;
    	}
    	return level;
    }

}
