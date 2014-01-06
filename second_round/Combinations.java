package second_round;

import java.util.ArrayList;

public class Combinations {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = combine(4, 2);
		for (ArrayList<Integer> list: res) {
			for (int i: list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    int[] A = new int[n];
	    for (int i = 0; i < A.length; i++)
	        A[i] = i + 1;
	    generate(res, list, A, 0, k);
	    return res;
	}

	private static void generate(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] A, int t, int k) {
	    if (list.size() == k) return;
	    for (int i = t; i < A.length; i++) {
	        list.add(A[i]);
	        if (list.size() == k)
	            res.add(new ArrayList<Integer>(list));
	        generate(res, list, A, i+1, k);
	        list.remove(list.size()-1);
	    }
	}
	         
}
