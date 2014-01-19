package second_round;

public class SortList {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(7);
		ListNode n3 = new ListNode(5);
		
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(6);
		
		n1.next = n2; n2.next = n3; n3.next = n4;
		n4.next = n5; n5.next = n6;
		ListNode head = sortList(n1);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		
	}
	public static ListNode sortList(ListNode head) {	 
	    if (head == null || head.next == null) return head;
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode slow = dummy;
	    ListNode fast = dummy;
	    while (fast.next != null && fast.next.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    ListNode firstLast = slow;
	    slow = slow.next;
	    firstLast.next = null;
	    
	    ListNode firsthalf = sortList(head);
	    ListNode secondhalf = sortList(slow);
	    
	    ListNode newhead = merge(firsthalf, secondhalf);
	    return newhead;
	}

	private static ListNode merge(ListNode first, ListNode second) {
	    if (first == null && second == null) return null;
	    if (first == null) return second;
	    if (second == null) return first;
	    
	    ListNode newhead;
	    if (first.val < second.val) {
	        newhead = first;
	        first = first.next;
	    } else {
	        newhead = second;
	        second = second.next;
	    }
	    ListNode runner = newhead;
	    while (first != null && second != null) {
	        if (first.val < second.val) {
	            runner.next = first;
	            first = first.next;
	        } else {
	            runner.next = second;
	            second = second.next;
	        }
	        runner = runner.next;
	    }

	    runner.next = (first == null? second : first);
	    return newhead;
	}
}
