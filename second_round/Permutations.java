package second_round;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
	public static void main(String[] args) {
		int[] num = {1,1,2};
		ArrayList<ArrayList<Integer>> res = permute(num);
		for(ArrayList<Integer> ans: res) {
			for (int i: ans){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		Arrays.sort(num);
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> ans = new ArrayList<Integer>();
	    boolean[] isUsed = new boolean[num.length];
	    generate(num, isUsed, ans, res);
	    return res;
	}

	private static void generate(int[] num, boolean[] isUsed, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res) {
	    for (int i = 0; i < num.length; i++) {
	        if (isUsed[i]) continue;
	        ans.add(num[i]);
	        isUsed[i] = true;
	        if (ans.size() == num.length) res.add(new ArrayList<Integer>(ans));
	        generate(num, isUsed, ans, res);
	        isUsed[i] = false;
	        ans.remove(ans.size() - 1);
	        while (i + 1 < num.length && num[i] == num[i+1]) i++;
	    }
	}
}
