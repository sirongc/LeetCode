package first_round;

public class PartitionList {
	public static void main(String[] args){
		ListNode head = new ListNode(3);
		ListNode h1 = new ListNode(1);
		ListNode h2 = new ListNode(2);
		ListNode h3 = new ListNode(2);
		ListNode h4 = new ListNode(5);
		ListNode h5 = new ListNode(2);
		
		head.next = h1;
		h1.next = h2;
		//h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		
		head = partition(head, 3);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	
    public static ListNode partition(ListNode head, int x) {
    	
    	if(head == null) return null;
    	ListNode newHead = new ListNode(x-1);
    	newHead.next = head;
    	head = newHead;
    	
    	
    	ListNode p = head;
    	if(p.val < x){
        	while(p.next != null && p.next.val < x ){
        		p = p.next;
        	}
    	}
    	ListNode temp = null;
    	if(p.next != null){
    		temp = p.next;
    	}
    	if(temp == null) return head.next;
    	while(temp.next != null){
    		if(temp.next.val < x){
    			change(p, temp);
    			p = p.next;
    		}else{
    			temp = temp.next;
    		}
    	}

    	return head.next;
    }


	private static void change(ListNode p, ListNode temp) {
		ListNode insertedNode = temp.next;
		temp.next = temp.next.next;
		
		insertedNode.next = p.next;
		p.next = insertedNode;
		p = p.next;
	}
}
