package first_round;
import java.util.ArrayList;
import java.util.Stack;


public class BinaryTreePostorderTraversal {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		//TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		TreeNode rightleft = new TreeNode(3);
	//	TreeNode leftleftleft = new TreeNode(2);
		
		root.right = right;
		right.left = rightleft;
		
		ArrayList<Integer> list =postorderTraversal(root);
		for(int a: list){
			System.out.println(a);
		}
	}
	
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(root == null) return list;
    	Stack<TreeNode> stack = new Stack<TreeNode>();    
    	stack.add(root);
    	while(!stack.isEmpty()){
    		TreeNode node = stack.pop();
    		list.add(0, node.val);
    		if (node.left != null && node.right != null){
    			stack.push(node.left);
    			stack.push(node.right);
    		} else if (node.left != null){
    			stack.push(node.left);
    		} else if(node.right != null){
    			stack.push(node.right);
    		}
    	}
    	return list;
    }

}
