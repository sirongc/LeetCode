package second_round;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	public static void main(String[] args) {
		int[] S = {4, 1, 0};
		ArrayList<ArrayList<Integer>> res = subsets(S);
		for (ArrayList<Integer> s: res) {
			for (int i: s) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);
	    int length = S.length;
	    int k = 1 << length;
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    for (int i = 0; i < k; i++) {
	        res.add(generate(S, i));
	    }
	    return res;
	}

	private static ArrayList<Integer> generate(int[] S, int k) {
	    ArrayList<Integer> ans = new ArrayList<Integer>();
	    int i = 0;
	    while (k > 0) {
	        if((k & 1) == 1) {
	            ans.add(S[i]);
	        }
	        k >>= 1;
	        i++;
	    }
	    return ans;
	}
}
