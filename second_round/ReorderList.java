package second_round;

public class ReorderList {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		//n4.next = n5;
		
		reorderList(n1);
		while (n1 != null) {
			System.out.print(n1.val + " ");
			n1 = n1.next;
		}
	}
	public static void reorderList(ListNode head) {
	    if (head == null) return;
	    ListNode slower = head;
	    ListNode faster = head;
	    int size = 0;
	    while (faster != null && faster.next != null) {
	        slower = slower.next;
	        faster = faster.next.next;
	        size++;
	    }

	    ListNode first = head;
	    ListNode second = reverse(slower);
	    for (int i = 0; i < size; i++) {
	        ListNode newFirst = first.next;
	        first.next = second;
	        ListNode newSecond = second.next;
	        second.next = newFirst;
	        first = newFirst;
	        second = newSecond;
	    }
	   // first.next = second;
	}

	private static ListNode reverse(ListNode head) {
	    if (head == null) return null;
	    ListNode newHead = reverse(head.next);
	    ListNode runner = newHead;
	    head.next = null;
	    if (runner == null) {
	    	return head;
	    }
	    while (runner.next != null) runner = runner.next;
	    runner.next = head;
	    return newHead;
	}
}
