package first_round;
import java.util.Stack;


public class ReorderList {
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
		
		reorderList(null);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
		
	}
	
    public static void reorderList(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
    	ListNode temp = head;
    	
    	while(fast != null && fast.next != null){
    		fast = fast.next.next;
    		temp = slow;
    		slow = slow.next;
    	}
    	if(temp != null)
    		temp.next = null;
    	
    	Stack<ListNode> stack = new Stack<ListNode>();
    	while(slow != null){
    		stack.push(slow);
    		slow = slow.next;
    	}
    	
    	while(!stack.isEmpty()){
    		ListNode tempNext = head.next;
    		head.next = stack.pop();
    		head.next.next = tempNext;
    		if(tempNext != null)
    			head = tempNext;
    		else
    			head = head.next;
    	}
    	
    	
    }

}
