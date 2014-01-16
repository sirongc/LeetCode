package second_round;

public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode head = reverseKGroup(n1, 2);
		while (head != null) {
			System.out.print(head.val +  " ");
			head = head.next;
		}
		
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1) return head;
        int i = 0;
	    ListNode dummy = new ListNode(-1);
	    dummy.next = head;
	    ListNode pre = dummy;
	    while (head != null) {
	        i++;
	        if (i % k == 0) {
	            pre = reverse(pre, head.next);
	            head = pre.next;
	        } else
	            head = head.next;
	    } 
	    return dummy.next;  
	}

	private static ListNode reverse(ListNode pre, ListNode next) {
	    ListNode last = pre.next;
	    ListNode cur = last.next;
	    while (cur != next) {
	        last.next = cur.next;
	        cur.next = pre.next;
	        pre.next = cur;
	        cur = last.next;
	    }
	    return last;
	}
	    
}
