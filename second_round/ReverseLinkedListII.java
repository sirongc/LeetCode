package second_round;

public class ReverseLinkedListII {
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
		ListNode head = reverseBetween(n1, 2, 4);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
	    if (head == null) return null;
	    ListNode temphead = new ListNode(-1);
	    temphead.next = head;
	    ListNode start = temphead;
	    for (int i = 0; i < m-1; i++)
	        start = start.next;
	    ListNode runner = start.next;
	    for (int i = 0; i < n-m; i++) {
	        ListNode temp = start.next;
	        start.next = runner.next;
	        runner.next = runner.next.next;
	        start.next.next = temp;
	    }
	    return temphead.next;
	}
}
