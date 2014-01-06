package first_round;

public class ReverseLinkedListII {
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
		
		head = reverseBetween(head,2,3);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
    public static ListNode reverseBetween(ListNode head, int m, int n) {
    	if(m == 0) return head;
    	ListNode returnNode = head;
    	ListNode[] nodes = new ListNode[(int)Math.ceil((double)(n-m+1)/2)];
    	for(int i = 0; i < nodes.length; i++){
    		nodes[i] = head;
    	}
    	
    	for(int i = 0; i < m - 1; i++){
    		head = head.next;
    		for(int j = 0; j < nodes.length; j++){
    			nodes[j] = nodes[j].next;
    		}
    	}
    	
    	for(int i = 0; i < nodes.length; i++){
    		nodes[i] = advance(nodes[i], (int)Math.ceil((double)(i + (n-m+1)/2)));
    	}
    	
    	for(int i = 0; i < nodes.length; i++){
    		int temp = nodes[nodes.length - 1- i].val;
    		nodes[nodes.length - 1- i].val = head.val;
    		head.val = temp;
    		head = head.next;
    	}
    	return returnNode;
    }
    
    public static ListNode advance(ListNode node, int step){
    	for(int i = 0; i < step; i++){
    		node = node.next;
    	}
    	return node;
    }
}
