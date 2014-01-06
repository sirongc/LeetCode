package first_round;

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode h1 = new ListNode(1);
		ListNode h2 = new ListNode(2);
		ListNode h3 = new ListNode(2);
		ListNode h4 = new ListNode(3);
		ListNode h5 = new ListNode(3);
		
		head.next = h1;
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		
		head = deleteDuplicates(head);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}	
	}
	
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head == null) return null;
    	ListNode returnNode = head;
    	while(head.next != null){
    		if(head.next.val == head.val){
    			head.next = head.next.next;
    		}else{
    			head = head.next;
    		}
    	}
    	return returnNode;
    }

}
