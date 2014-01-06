package first_round;
import java.util.ArrayList;


public class Permutations {
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
	//	h3.next = h4;
	//	h4.next = h5;
		int[] num = {};
		ArrayList<ArrayList<Integer>> lists = permute(num);
		for(ArrayList<Integer> list: lists){
			for(int i: list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
	}
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		if(num.length == 0 || num == null){
			 ArrayList<Integer> list = new ArrayList<Integer>();
        	 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        	 result.add(list);
        	 return result;
		}
		return permute(num, num.length-1);
	}
	
    public static ArrayList<ArrayList<Integer>> permute(int[] num, int n) {
        if(n == 0){
        	 ArrayList<Integer> list = new ArrayList<Integer>();
        	 list.add(num[0]);
        	 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        	 result.add(list);
        	 return result;
        }

        ArrayList<ArrayList<Integer>> lists = permute(num, n-1);
        ArrayList<ArrayList<Integer>> newLists = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> list: lists){
        	addNewLists(list, num[n], newLists);
        }	
    	return newLists;
    }
    
	@SuppressWarnings("unchecked")
	private static void addNewLists(ArrayList<Integer> list, int num, ArrayList<ArrayList<Integer>> newLists) {
		int size = list.size();
		for(int i = 0; i <= size; i++){
			list.add(i, num);
			ArrayList<Integer> copy = ((ArrayList<Integer>) list.clone());
			newLists.add(copy);
			list.remove(i);
		}	
	}
}
