package first_round;
import java.util.*;


public class LinkedListCycleII {
	
	public static void main(String[] args){
		
	}
	
    public ListNode detectCycle(ListNode head) {
    	ListNode faster = head;
    	ListNode slower = head;
    	while(faster != null && faster.next != null){
    		faster = faster.next.next;
    		slower = slower.next;
    		if(faster == slower) break;
    	}
    	
    	if(faster == null || faster.next == null) return null;
    	
    	slower = head;
    	
    	while(faster != slower){
    		faster = faster.next;
    		slower = slower.next;
    	}
    	
    	return faster;
    }

}
