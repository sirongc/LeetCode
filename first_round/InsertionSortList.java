package first_round;

public class InsertionSortList {
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
		
		head =insertionSortList(head);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
    public static ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode newHead = new ListNode(Integer.MIN_VALUE);
    	newHead.next = head;
    	head = newHead;
    	
    	ListNode runner = head.next;
    	ListNode start = head;
    	
    	while(runner.next.val > start.next.val){
    		if(start == runner) break;
    		start = start.next;
    	}
    	
    	if(runner.next.val <= start.next.val){
    		swap(runner, start);
    	}
    	
    	
    	
    	return newHead.next;
    }

	private static void swap(ListNode runner, ListNode cur) {
		int temp = runner.val;
		runner.val = cur.val;
		cur.val = temp;
	}

}
