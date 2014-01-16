package second_round;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
    	return sortedArrayToBST(num, 0, num.length - 1);
    }
	
    private TreeNode sortedArrayToBST(int[] num, int lo, int hi) {
    	if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, lo, mid-1);
        root.right = sortedArrayToBST(num, mid+1, hi);
        return root;  
    }

}
