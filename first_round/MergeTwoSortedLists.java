package first_round;

public class MergeTwoSortedLists {
	public static void main(String[] args){
		ListNode x1 = new ListNode(1);
		ListNode x2 = new ListNode(3);
		x1.next = x2;
		
		ListNode y1 = new ListNode(2);
		ListNode y2 = new ListNode(4);
		y1.next = y2;
		
		
		ListNode node = mergeTwoLists(x1, y1);
		while(node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null) return l2;
    	if (l2 == null) return l1;
    	
		ListNode small = null;
		ListNode big = null;
    	if (l1.val < l2.val) {
    		small = l1;
    		big = l2;	
    	} else {
    		small = l2;
    		big = l1;
    	}
    	ListNode returnNode = small;
    	
		while (small.next != null && big != null) {
			if (small.next.val <= big.val) {
				small = small.next;
			} else {
				ListNode temp = big;
				big = big.next; //the sequence here is really important
				temp.next = small.next;
				small.next = temp;
				small = small.next;
				
			}
		}
		
		if (small.next != null) {
			return returnNode;
		}
		
		if (big != null) {
			small.next = big;
		}  	
    	return returnNode;
    }

}
