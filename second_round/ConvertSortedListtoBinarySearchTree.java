package second_round;

public class ConvertSortedListtoBinarySearchTree {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		n5.next = n6;
		
		@SuppressWarnings("unused")
		TreeNode root = sortedListToBST(n1);
		System.out.println(123);
	}
	
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
    	int length = getLength(head);
    	return convertListToBST(head, length);
    }
    public static TreeNode convertListToBST(ListNode head, int length) { 
    	if (head == null || length == 0) return null;
    	ListNode listroot = head;
    	int mid = length / 2;
    	for (int i = 0; i < mid; i++) {
    		listroot = listroot.next;
    	}
    	ListNode right = listroot.next;    	
    	TreeNode root = new TreeNode(listroot.val);
    	root.right = convertListToBST(right, length-mid-1);
    	root.left = convertListToBST(head, mid);
    	return root;
    }
    
    private static int getLength(ListNode head) {
    	int size = 0;
    	while (head != null) {
    		size++;
    		head = head.next;
    	}
    	return size;
    }
}
