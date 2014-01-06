package first_round;

public class RemoveDuplicatesFromSortedListII {
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode h1 = new ListNode(1);
		ListNode h2 = new ListNode(2);
		ListNode h3 = new ListNode(2);
		ListNode h4 = new ListNode(2);
		ListNode h5 = new ListNode(2);
		
		head.next = h1;
	//	h1.next = h2;
	//	h2.next = h3;
	//	h3.next = h4;
	//	h4.next = h5;
		
		head = deleteDuplicates(head);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
		
	}
	
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode returnNode = head;
        boolean lastIsDuplicate = false;
        while(head.next != null){
        	if(head.val == head.next.val){
        		while(head.next != null){
        			if(head.val == head.next.val){
        				head.next = head.next.next;
        			}else{
        				break;
        			}
        		}
        		if(head.next == null){
        			lastIsDuplicate = true;
        			break;
        		}else{
        			head.val = head.next.val;
        			head.next = head.next.next;
        		}
        	}else{
        		head = head.next;
        	}  	
        }
        if(lastIsDuplicate){
        	ListNode temp = returnNode;
        	if(temp.next == null) returnNode = null;
        	else{
            	while(temp.next.next != null) 
            		temp = temp.next;
            	temp.next = null;
        	}	
        }
    	return returnNode;
    }
    

}
