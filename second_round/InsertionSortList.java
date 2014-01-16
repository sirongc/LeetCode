package second_round;

public class InsertionSortList {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		//n2.next = n3;
		//n3.next = n4;
		n4.next = n5;
		ListNode head = insertionSortList(n1);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	public static ListNode insertionSortList(ListNode head) {
	    if (head == null) return null;
	    ListNode temphead = new ListNode(Integer.MIN_VALUE);
	    temphead.next = head;
	    ListNode runner = temphead;
	    while (runner != null && runner.next != null) {
	        ListNode n = runner.next;
	        ListNode sorter = temphead;
	        while (sorter.next != null && sorter.next.val < n.val) sorter = sorter.next;
	        if (sorter.next != n) {
	            runner.next = runner.next.next;
	            n.next = sorter.next;
	            sorter.next = n;    
	        }
	        else runner = runner.next;
	    }
	    return temphead.next;        	    
	}
}
