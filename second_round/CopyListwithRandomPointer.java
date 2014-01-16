package second_round;

public class CopyListwithRandomPointer {
	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		n1.random = n1;
		RandomListNode head = copyRandomList(n1);
		while (head!= null) {
			System.out.print(head.label + " ");
			head = head.next;
		}
	}
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		 
	    if (head == null) return null;
	    // for every node, insert a copied node beside it.
	    RandomListNode temp = head;
	    while (temp != null) {
	        RandomListNode next = temp.next;
	        RandomListNode newNode = new RandomListNode(temp.label);
	        temp.next = newNode;
	        newNode.next = next;
	        temp = next;
	    }
	    // copy the random refernce of old node to each new node
	    RandomListNode oldnode = head;
	    RandomListNode newnode = head.next;
	    while (newnode != null) {
	        if (oldnode.random != null)
	            newnode.random = oldnode.random.next;
	        if (newnode.next == null) break;
	        oldnode = oldnode.next.next;
	        newnode = newnode.next.next;
	    }

	    RandomListNode oldList = head;
	    RandomListNode newList = head.next;
	    RandomListNode node = newList;
	    while (newList.next != null) {
	        oldList.next = oldList.next.next;
	        newList.next = newList.next.next;
	        oldList = oldList.next;
	        newList = newList.next;
	    }
	    oldList.next = null;
	    return node;
	} 
	    
}
