package second_round;

import java.util.ArrayList;

public class PopulatingNextRightPointersinEachNode {
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode left = new TreeLinkNode(2);
		TreeLinkNode right = new TreeLinkNode(3);
		root.left = left;
		root.right = right;
		connect(root);
		System.out.println(123);
	}
	
	public static void connect(TreeLinkNode root) {
		if (root == null) return;
		if (root.left != null) root.left.next = root.right;
		if (root.right != null) root.right.next = (root.next != null ? root.next.left : null);
		connect(root.left);
		connect(root.right);		
	}
	
	public static void connect2(TreeLinkNode root) {	 
	    if (root == null) return;
	    ArrayList<TreeLinkNode> frontier = new ArrayList<TreeLinkNode>();
	    frontier.add(root);
	    while (frontier.size() != 0) {
	        ArrayList<TreeLinkNode> nextlevel = new ArrayList<TreeLinkNode>();
	        for (int i = 0; i < frontier.size() - 1; i++)
	            frontier.get(i).next = frontier.get(i+1);
	     
	        for (TreeLinkNode tn: frontier) {
	            if (tn.left != null) nextlevel.add(tn.left);
	            if (tn.right != null) nextlevel.add(tn.right);
	        }
	        frontier = nextlevel;
	    }       
	}
}
