package second_round;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
	    if (head == null) return null;
	    if (head.next == null) return head;
	    ListNode nextPair = head.next.next;

	    ListNode newhead = head.next;
	    newhead.next = head;
	    head.next = swapPairs(nextPair);
	    return newhead;
	}
}
