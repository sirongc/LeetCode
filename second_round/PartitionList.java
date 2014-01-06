package second_round;

public class PartitionList {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
	//	n1.next = n2;
	//	n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		ListNode head = partition(n1, 2);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public static ListNode partition(ListNode head, int x) {
		if (head == null) return null;
	    ListNode temphead = new ListNode(-1);
	    temphead.next = head;
	    ListNode pivot = temphead;
	    while (pivot.next != null) {
	        if (pivot.next.val >= x) break;
	        pivot = pivot.next;
	    }
	    ListNode center = pivot.next;
	    ListNode runner = pivot.next;

	    while (runner != null && runner.next != null) {
	        if (runner.next.val < x) {
	            ListNode changed = runner.next;
	            runner.next = runner.next.next;
	            pivot.next = changed;
	            changed.next = center;
	            pivot = pivot.next;
	        } else
	            runner = runner.next;
	    }
	    return temphead.next;
	}   
}
