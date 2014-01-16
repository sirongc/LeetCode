package second_round;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetII {
	public static void main(String[] args) {
		int[] S = {1,1};
		ArrayList<ArrayList<Integer>> res = subsetsWithDup(S);
		for (ArrayList<Integer> s: res) {
			for (int i: s) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
	    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    Arrays.sort(S);
	    generate(ans, list, 0, S);
	    return ans;
	}

	private static void generate(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list, int start, int[] S) {
		ans.add(new ArrayList<Integer>(list));
        for (int i = start; i < S.length; i++) {
        	list.add(S[i]);
        	generate(ans, list, i + 1, S);
        	list.remove(list.size()-1);
        	while (i+1 < S.length && S[i] == S[i+1]) i++;
        }
	}
}
