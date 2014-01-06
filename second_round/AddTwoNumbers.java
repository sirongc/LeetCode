package second_round;

public class AddTwoNumbers {
	public static void main(String[] args){
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		n5.next = n6;
		
		ListNode sum = addTwoNumbers(n1, n4);
		while (sum != null){
			System.out.print(sum.val + " ");
			sum = sum.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    int c = 0;
	    ListNode ans = new ListNode(-1); //temp node;
	    ListNode temphead = ans;
	    while (l1 != null && l2 != null) {
	        int cur = l1.val + l2.val + c;
	        ans.next = new ListNode(cur % 10);
	        ans = ans.next;
	        c = (cur >= 10 ? 1: 0);
	        l1 = l1.next;
	        l2 = l2.next;
	    }
	    l1 = (l1 == null ? l2 : l1);
	    while (l1 != null) {
	        int cur = l1.val + c;
	        ans.next = new ListNode(cur % 10);
	        ans = ans.next;
	        c = (cur >= 10 ? 1: 0);
	        l1 = l1.next;
	    }
	    if (c != 0)
	        ans.next = new ListNode(c);
	    return temphead.next;
	}
}
