package first_round;

public class LinkedListCycle {
	public static void main(String[] args){
		
	}
	
    public boolean hasCycle(ListNode head) {
    	if(head == null || head.next == null) return false;
    	ListNode runner = head;
    	while(runner != null){
    		if(runner.next == null) return false;
    		head = head.next;
    		runner = runner.next.next;
    		if(head == runner) return true;
    	}
    	return false;
    }

}
