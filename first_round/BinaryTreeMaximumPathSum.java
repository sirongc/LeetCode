package first_round;
import java.util.HashMap;
import java.util.HashSet;


public class BinaryTreeMaximumPathSum {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		BinaryTreeMaximumPathSum X = new BinaryTreeMaximumPathSum();
		System.out.println(X.maxPathSum(root));
		
	}
	
	public int maxPathSum(TreeNode root) {
		HashMap<TreeNode, Integer> nodeMap = new HashMap();
		return maxPathSumHelper(root, nodeMap);
	}
	
	public int maxPathSumHelper(TreeNode root, HashMap<TreeNode, Integer> nodeMap) {
		if(root == null) return 0;
		if(nodeMap.containsKey(root)){
			return nodeMap.get(root);
		}
		else{
			int maxSum = Math.max(Math.max(maxPathSumHelper(root.left, nodeMap), maxPathSumHelper(root.right, nodeMap)), maxRootSum(root));
			nodeMap.put(root, maxSum);
			return maxSum;
		}
	}
	
	public int maxRootSum(TreeNode root){
		if(root == null) return 0;
		return maxHeight(root.left) + maxHeight(root.right) + root.val;
		
	}
	
	public int maxHeight(TreeNode root){
		if(root == null) return 0;
		return root.val + Math.max(maxHeight(root.left), maxHeight(root.right));
	}

}
