package second_round;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
	    ListNode slower = head;
	    ListNode faster = head;
	    while (faster != null && faster.next != null) {
	        slower = slower.next;
	        faster = faster.next.next;
	        if (slower == faster) break;
	    }
	    if (faster == null || faster.next == null) return null;

	    slower = head;
	    while (faster != slower) {
	        faster = faster.next;
	        slower = slower.next;
	    }
	    return faster;
	}
}
