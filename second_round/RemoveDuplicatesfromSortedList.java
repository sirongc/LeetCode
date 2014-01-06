package second_round;

public class RemoveDuplicatesfromSortedList {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode head = deleteDuplicates(n1);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
	    ListNode runner = head;
	    while (runner != null) {
	        if (runner.next == null) break;
	        if (runner.next.val == runner.val) 
	            runner.next = runner.next.next;  
	        else 
	            runner = runner.next;
	    }
	    return head;         
	}
}
