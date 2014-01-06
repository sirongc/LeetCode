package second_round;

public class RemoveNthNodeFromEndofList {
	public static void main(String[] args) {
		
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
	    if (n == 0) return head;
	    ListNode runner = head;
	    for (int i = 0; i < n; i++) {
	        runner = runner.next;
	        if (runner == null) return head.next;
	    }
	    ListNode del = head;
	    while (runner.next != null) {
	        del = del.next;
	        runner = runner.next;
	    }
	    del.next = del.next.next;
	    return head;
	}


}
