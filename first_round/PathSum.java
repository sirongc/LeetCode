package first_round;

public class PathSum {
	public static void main(String[] args){
		
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right == null){
			if(root.val == sum) return true;
			else return false;
		}
		if(hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val)) return true;
		return false;
        
    }
}
