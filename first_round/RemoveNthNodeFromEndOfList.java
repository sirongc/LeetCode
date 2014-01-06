package first_round;

public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode h1 = new ListNode(2);
		ListNode h2 = new ListNode(3);
		ListNode h3 = new ListNode(4);
		ListNode h4 = new ListNode(5);
		ListNode h5 = new ListNode(6);
		
	//	head.next = h1;
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		
		head = removeNthFromEnd(head, 1);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}	
	}
	
	// Given linked list: 1->2->3->4->5, and n = 2.
	// After removing the second node from the end, the linked list becomes 1->2->3->5.
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	if(n == 0) return head;
    	ListNode temp1 = head;
    	ListNode temp2 = head;
    	for(int i = 0; i < n; i++){
    		if(temp1 == null) return head;
    		temp1 = temp1.next;
    		
    	}
    	if(temp1 == null) return head.next;
    	while(temp1.next != null){
    		temp2 = temp2.next;
    		temp1 = temp1.next;
    	}
    	
    	temp2.next = temp2.next.next;
    	return head;
    }

}
