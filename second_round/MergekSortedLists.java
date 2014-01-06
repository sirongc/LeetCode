package second_round;

import java.util.ArrayList;

public class MergekSortedLists {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(11);
		ListNode n2 = new ListNode(14);
		n1.next = n2;
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(5);
		n3.next = n4;
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(7);
		n5.next = n6;
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		//lists.add(n1);
		//lists.add(n3);
		//lists.add(n5);
		lists.add(null);
		ListNode merged = mergeKLists(lists);
		
		while (merged != null) {
			System.out.print(merged.val + " ");
			merged = merged.next;
		}
	}
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
	    if (lists == null) return null;
	    ListNode temphead = new ListNode(Integer.MIN_VALUE);
	    ListNode runner = temphead;
	    while (!lists.isEmpty()) {
	        int minIndex = -1;
	        int min = Integer.MAX_VALUE;
	        for (int i = 0; i < lists.size(); i++) {
	        	if (lists.get(i) == null) continue;
	            if (lists.get(i).val < min) {
	                minIndex = i;
	                min = lists.get(i).val;
	             }
	        }
	        if (minIndex == -1) break;
	        runner.next = lists.get(minIndex);
	        runner = runner.next;
	        ListNode minNode = lists.get(minIndex);
	        minNode = minNode.next;
	        if (minNode == null) lists.remove(minIndex);
	        else lists.set(minIndex, minNode);
	        
	    }
	    return temphead.next;
	}

}
