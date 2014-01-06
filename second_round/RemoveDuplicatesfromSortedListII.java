package second_round;

public class RemoveDuplicatesfromSortedListII {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(1);
		ListNode n7 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		ListNode head = deleteDuplicates(n1);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
	    if (head == null) return null;
	    ListNode tempHead = new ListNode(-1);
	    tempHead.next = head;
	    ListNode runner = tempHead;
	    int duplicate = 0;
	    
	    while (runner.next != null && runner.next.next != null) {
	        if (runner.next.val == runner.next.next.val) {
	            duplicate = runner.next.val;
	            while (runner.next != null && runner.next.val == duplicate)
	                runner.next = runner.next.next;
	        }
	        else
	            runner = runner.next;
	    }
	    return tempHead.next;
	}
	            
}
