package second_round;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public static void main(String[] args) {
		int[] preorder = {7,2,1,3,10,9,11};
		int[] inorder = {1,2,3,7,9,10,11};
		@SuppressWarnings("unused")
		TreeNode root = buildTree(preorder, inorder);
		while (true) {
			
		}
	}
	
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) 
        	map.put(inorder[i], i);
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
    
	private static TreeNode buildTree(int[] preorder,int prelo, int prehi, int[] inorder, int inlo, int inhi, HashMap<Integer, Integer> map) {	    
	    if (prelo > prehi || inlo > inhi) return null;
	    TreeNode root = new TreeNode(preorder[prelo]);
	    int rootIndexInorder = map.get(root.val);
	    int leftsize = rootIndexInorder - inlo;
	    TreeNode left = buildTree(preorder, prelo+1, prelo+leftsize, inorder, inlo, rootIndexInorder-1, map);
	    TreeNode right = buildTree(preorder, prelo+leftsize+1, prehi, inorder, rootIndexInorder+1, inhi, map);
	    root.left = left;
	    root.right = right;
	    return root;
	}

}
