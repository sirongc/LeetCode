package second_round;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public static void main(String[] args) {
		int[] inorder = {1,2,3,4,5};
		int[] postorder = {2,3,1,5,4};
		@SuppressWarnings("unused")
		TreeNode root = buildTree(inorder, postorder);
		System.out.println("123");
	}
	
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) 
        	map.put(inorder[i], i);
        return buildTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
    }
    
	private static TreeNode buildTree(int[] postorder,int postlo, int posthi, int[] inorder, int inlo, int inhi, HashMap<Integer, Integer> map) {	    
	    if (postlo > posthi || inlo > inhi) return null;
	    TreeNode root = new TreeNode(postorder[posthi]);
	    int rootIndexInorder = map.get(root.val);
	    int leftsize = rootIndexInorder - inlo;
	    TreeNode left = buildTree(postorder, postlo, postlo+leftsize-1, inorder, inlo, rootIndexInorder-1, map);
	    TreeNode right = buildTree(postorder, postlo+leftsize, posthi-1, inorder, rootIndexInorder+1, inhi, map);
	    root.left = left;
	    root.right = right;
	    return root;
	}
}
