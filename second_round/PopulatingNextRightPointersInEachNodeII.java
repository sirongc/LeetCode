package second_round;

public class PopulatingNextRightPointersInEachNodeII {
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode left = new TreeLinkNode(2);
		TreeLinkNode right = new TreeLinkNode(3);
		root.left = left;
		root.right = right;
		
		left.left = new TreeLinkNode(4);
		right.right = new TreeLinkNode(5);
		
		
		connect(root);
		System.out.println(123);
	}
	
	
	public static void connect(TreeLinkNode root) {
	    if (root == null) return;
	    TreeLinkNode p = root.next;
	    while (p != null) {
	        if (p.left != null) {
	        	p = p.left;
	        	break;
	        }
	        else if (p.right != null) {
	        	p = p.right;
	        	break;
	        }    
	        else 
	            p = p.next;
	    }
	    
	    if (root.right != null)
	        root.right.next = p;
	    if (root.left != null)
	        root.left.next = root.right != null ? root.right : p;
	    
	    connect(root.left);
	    connect(root.right);
	}
}
