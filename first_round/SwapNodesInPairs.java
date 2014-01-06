package first_round;

public class SwapNodesInPairs {
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
	//	h4.next = h5;
		head = swapPairs(head);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}	
		
	}
	// 1->2->3->4, you should return the list as 2->1->4->3.
    public static ListNode swapPairs(ListNode head) {
    	
    	if(head == null) return null;
    	if(head.next == null) return head;
    	
    	ListNode laterList = swapPairs(head.next.next);
    	ListNode temp = head.next;
    	temp.next = head;
    	head.next = laterList;
    	return temp;
    }

}
