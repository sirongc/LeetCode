package first_round;

public class RotateList {
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
		
		head = rotateRight(head, 2);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
		
		
		
	}
    public static ListNode rotateRight(ListNode head, int n) {
    	if(head == null) return null;
    	int size = getSize(head);
    	n = n % size;
    	ListNode temp = head;
    	ListNode newHead = head;
    	for(int i = 0; i < n; i++){
    		temp = temp.next;
    	}
    	
    	while(temp.next != null){
    		temp = temp.next;
    		newHead = newHead.next;
    	}
    	
    	temp.next = head;
    	head = newHead.next;
    	newHead.next = null;

    	return head;
    }
    
    public static int getSize(ListNode head){
    	int size = 0;
    	while(head != null){
    		head = head.next;
    		size++;
    	}
    	return size;
    }
}
