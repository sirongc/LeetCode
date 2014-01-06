package first_round;

public class ReverseNodesInKGroup {
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode h1 = new ListNode(2);
		ListNode h2 = new ListNode(3);
		ListNode h3 = new ListNode(4);
		ListNode h4 = new ListNode(5);
		ListNode h5 = new ListNode(6);
		
		head.next = h1;
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		
		head = reverse(head, 5);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}	
	}

    public ListNode reverseKGroup(ListNode head, int k) {
    	
    	ListNode temp = head;
    	for(int i = 0; i < k; i++){
    		temp = temp.next;
    	}
    	
    	ListNode nextList = reverseKGroup(temp, k);
    	
    	ListNode tail = reverse(head, k);
    	tail.next = nextList;
    	return head;
    }

	private static ListNode reverse(ListNode head, int k) {
		
		
		
		return null;
		
	}
}
