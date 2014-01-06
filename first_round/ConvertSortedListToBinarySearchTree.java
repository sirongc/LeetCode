package first_round;

public class ConvertSortedListToBinarySearchTree {
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode h1 = new ListNode(2);
		ListNode h2 = new ListNode(3);
		ListNode h3 = new ListNode(4);
		ListNode h4 = new ListNode(5);
		ListNode h5 = new ListNode(6);
		
		head.next = h1;
		h1.next = h2;
		h2.next = h3;
	//	h3.next = h4;
	//	h4.next = h5;
		
		TreeNode root = sortedListToBST(head);
		print(root);
	}
	
	public static void print(TreeNode root){
		if(root == null) return;
		print(root.left);
		System.out.println(root.val);
		print(root.right);
	}
	
    public static TreeNode sortedListToBST(ListNode head) {
    	if(head == null) return null;
    	int length = getLength(head);
    	return convertListToBST(head, length);
    }
    
    public static TreeNode convertListToBST(ListNode head, int length) {
    	if(head == null) return null;
    	if(head.next == null) return new TreeNode(head.val);
    	ListNode left = head;
    	int mid = length / 2;
    	for(int i = 0; i < mid-1; i++){
    		head = head.next;
    	}
    	ListNode temp = head;  	
    	head = head.next;
    	temp.next = null;
    	
    	ListNode right = head.next;
    	TreeNode root = new TreeNode(head.val);
    	root.right = convertListToBST(right, length - mid - 1);
    	root.left = convertListToBST(left, mid);
    	return root;
    }

	private static int getLength(ListNode head) {
		int i = 1;
		while(head.next != null){
			i++;
			head = head.next;
		}
		return i;
	}
}
