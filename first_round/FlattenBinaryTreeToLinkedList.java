package first_round;

public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
	//	root.left = left;
		root.right = right;
		FlattenBinaryTreeToLinkedList x = new FlattenBinaryTreeToLinkedList();
		TreeNode test = x.flattenHelper(root);
		
		while(test != null){
			System.out.println(test.val);
			test = test.right;
		}
	}
	
	public void flatten(TreeNode root){
		if(root == null) return;
		flattenHelper(root);
	}
	
	
    public TreeNode flattenHelper(TreeNode root) {
    	if(root == null) return null;
    	if(root.left == null && root.right == null) return root;
    	
    	TreeNode rightList = flattenHelper(root.right);
    	TreeNode leftList = flattenHelper(root.left);
    	if(leftList == null){
    		root.right = rightList;
    	}else{
    		root.right = leftList;
        	while(leftList.right != null){
        		leftList = leftList.right;
        	}
        	leftList.right = rightList;
    	}
    	return root;
    }

}
