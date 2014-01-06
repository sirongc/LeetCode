package first_round;
import java.util.LinkedList;


public class ValidateBinarySearchTree {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(1);
		root.left = left;
		ValidateBinarySearchTree x = new  ValidateBinarySearchTree();
		System.out.println(x.isValidBST(root));
	}
	
    public boolean isValidBST(TreeNode root) {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	transfer(root, list);
    	for(int i = 1; i < list.size(); i++){
    		if(list.get(i) - list.get(i-1) <= 0) return false;
    	}
    	return true;
    }
    
    public void transfer(TreeNode root, LinkedList<Integer> list){
    	if(root == null) return;
    	transfer(root.left, list);
    	list.add(root.val);
    	transfer(root.right, list);
    }

}
