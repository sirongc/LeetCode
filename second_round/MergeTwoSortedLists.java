package second_round;

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(10);
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		n5.next = n6;
		ListNode head = mergeTwoLists(n1, n4);
		while (head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    if (l1 == null) return l2;
	    if (l2 == null) return l1;
	    ListNode head = null;
	    if (l1.val < l2.val) {
	        head = l1;
	        l1 = l1.next;
	    } else{
	        head = l2;
	        l2 = l2.next;
	    }
	    ListNode runner = head;

	    while (l1 != null && l2 != null) {
	        if (l1.val < l2.val) {
	            runner.next = l1;
	            l1 = l1.next;
	        } else{
	            runner.next = l2;
	            l2 = l2.next;
	        }
	        runner = runner.next;
	    }
	    while (l1 != null) {
	        runner.next = l1;
	        l1 = l1.next;
	        runner = runner.next;
	    }
	    while (l2 != null) {
	        runner.next = l2;
	        l2 = l2.next;
	        runner = runner.next;
	    }
	    return head;                
	}
}
