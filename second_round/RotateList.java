package second_round;

public class RotateList {
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
		ListNode head = rotateRight(n1, 8);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		
	}
	public static ListNode rotateRight(ListNode head, int n) {    
	    int size = getSize(head);
	    int k = n % size;
	    ListNode newTail = head;
	    ListNode runner = head;
	    for (int i = 0; i < k; i++) runner = runner.next;
	    while (runner.next != null) {
	        newTail = newTail.next;
	        runner = runner.next;
	    }
	    runner.next = head;
	    ListNode newHead = newTail.next;
	    newTail.next = null;
	    return newHead;    
	}

	private static int getSize(ListNode head) {
	    int size = 0;
	    while (head != null) {
	        size++;
	        head = head.next;
	    }
	    return size;
	}

}
