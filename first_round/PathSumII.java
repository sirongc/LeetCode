package first_round;
import java.util.ArrayList;


public class PathSumII {
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(8);
		TreeNode leftleft = new TreeNode(11);
		TreeNode leftleftleft = new TreeNode(7);
		TreeNode leftleftright = new TreeNode(2);
		TreeNode rightleft = new TreeNode(13);
		TreeNode rightright = new TreeNode(4);
		TreeNode rightrightleft = new TreeNode(5);
		TreeNode rightrightright = new TreeNode(1);
		
		root.left = left;
		root.right = right;
		left.left = leftleft;
		leftleft.left = leftleftleft;
		leftleft.right = leftleftright;
		right.left = rightleft;
		right.right = rightright;
		rightright.left = rightrightleft;
		rightright.right = rightrightright;
				
		
		ArrayList<ArrayList<Integer>> lists = pathSum(root,22);
		for(ArrayList<Integer> list: lists){
			for(int n: list){
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    	
		if(root == null){
    		lists.add(list);
    		return lists;
    	}
    	
    	if(root.left == null && root.right == null){
    		if (root.val == sum){
    			list.add(root.val);
    			lists.add(list);
    			return lists;
    		} else{
    			return lists;
    		}
    	} 
    	
    	if(root.left != null) {
    		ArrayList<ArrayList<Integer>> tempLists = pathSum(root.left, sum-root.val);
    		for(ArrayList<Integer> tempList: tempLists){
    			ArrayList<Integer> temp = (ArrayList<Integer>) tempList.clone();
    			temp.add(0, root.val);
    			lists.add(0, temp);
    		}
    	}
    	
    	if(root.right != null) {
    		ArrayList<ArrayList<Integer>> tempLists = pathSum(root.right, sum-root.val);
    		for(ArrayList<Integer> tempList: tempLists){
    			ArrayList<Integer> temp = (ArrayList<Integer>) tempList.clone();
    			temp.add(0, root.val);
    			lists.add(0, temp);
    		}
    	}
    	return lists;
    }

}
