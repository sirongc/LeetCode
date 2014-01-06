package first_round;

public class ConvertSortedArrayToBinarySearchTree {
	public static void main(String[] args){
		
	//	int[] num = {1, 2, 3, 4, 5, 6, 7, 8};
	//	TreeNode root = sortedArrayToBST(num);
	//	print(root);
		
		
	}
	
	public static void print(TreeNode root){
		if(root == null) return;
		print(root.left);
		System.out.println(root.val);
		print(root.right);
	}
	
    public TreeNode sortedListToBST(ListNode head) {
        
    	return null;
        
    }
    


}
