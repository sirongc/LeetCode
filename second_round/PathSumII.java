package second_round;

import java.util.ArrayList;

public class PathSumII {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(11);
		TreeNode n4 = new TreeNode(13);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(5);
		TreeNode n9 = new TreeNode(1);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n3.left = n6;
		n3.right = n7;
		n2.left = n4;
		n2.right = n5;
		n5.left = n8;
		n5.right = n9;
		
		ArrayList<ArrayList<Integer>> res = pathSum(root, 22);
		for (ArrayList<Integer> list: res) {
			for (int i: list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	generatePath(root, 0, sum, ans, res);
    	return res;   	
    }

	private static void generatePath(TreeNode root, int sum, int target, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res) {
		if (root == null) return;
		if (root.left == null && root.right == null && root.val + sum == target) {
			ans.add(root.val);
			res.add(new ArrayList<Integer>(ans));
			ans.remove(ans.size() - 1);
			return;
		}
		
		ans.add(root.val);
		generatePath(root.left, sum + root.val, target, ans, res);
		ans.remove(ans.size() - 1);		
		
		ans.add(root.val);
		generatePath(root.right, sum  + root.val, target, ans, res);
		ans.remove(ans.size() - 1);	
	}
}
