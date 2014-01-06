package first_round;
import java.util.LinkedList;


public class SymmetricTree {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;
		SymmetricTree x = new SymmetricTree();
		System.out.println(x.isSymmetric(root));
		
	}
    public boolean isSymmetric(TreeNode root) {
    	if(root == null) return true;
    	if(root.left ==  null && root.right == null) return true;
    	
    	LinkedList<Integer> leftList = new LinkedList<Integer>();
    	leftTransfer(root.left, leftList);
    	
    	LinkedList<Integer> rightList = new LinkedList<Integer>();
    	rightTransfer(root.right, rightList);
    	
    	if(leftList.size() != rightList.size()) return false;
    	for(int i = 0; i < leftList.size(); i++){
    		if(leftList.get(i) != rightList.get(i)) return false;
    	}
        return true;
    }
    
	private void leftTransfer(TreeNode left, LinkedList<Integer> leftList) {
		if(left == null) return;
		leftTransfer(left.left, leftList);
		leftList.add(left.val);
		leftTransfer(left.right, leftList);
	}
	private void rightTransfer(TreeNode right, LinkedList<Integer> rightList) {
		if(right == null) return;
		rightTransfer(right.right, rightList);
		rightList.add(right.val);
		rightTransfer(right.left, rightList);
	}

}
