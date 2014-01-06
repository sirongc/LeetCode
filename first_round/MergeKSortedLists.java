package first_round;
import java.util.ArrayList;

public class MergeKSortedLists {
	public static void main(String[] args){
		ListNode x1 = new ListNode(1);
		ListNode x2 = new ListNode(3);
		x1.next = x2;
		
		ListNode y1 = new ListNode(2);
		ListNode y2 = new ListNode(4);
		y1.next = y2;
		
		ArrayList<ListNode> lists = new ArrayList();
	//	lists.add(x1);
	//	lists.add(y1);
		ListNode xx = null;
		lists.add(xx);
		
		ListNode node = mergeKLists(lists);
		while(node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}

	
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
    	ListNode node = null;
    	ListNode first = null;
    	cleanList(lists);
    	while(lists.size() != 0){
    		int minListIndex = getMinIndex(lists);
    		if(node == null){
    			node = lists.get(minListIndex);
    			first = node;
    		}else{
    			node.next = lists.get(minListIndex);
    			node = node.next;
    		}
    		lists.set(minListIndex, lists.get(minListIndex).next);
    		if(lists.get(minListIndex) == null) lists.remove(minListIndex);
    	}
    	return first;
    }
    
    private static void cleanList(ArrayList<ListNode> lists){
    	for(int i = 0; i < lists.size(); i++){
    		if(lists.get(i) == null){
    			lists.remove(i--);
    		}
    	}
    }


	private static int getMinIndex(ArrayList<ListNode> lists) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i = 0; i < lists.size(); i++){
			if(lists.get(i).val < min){
				min = lists.get(i).val;
				minIndex = i;
			}
		}
		return minIndex;
	}
}
