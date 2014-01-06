package second_round;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	public static void main(String[] args) {
		int[] candidates = {1,1,1};
		int target = 3;
		ArrayList<ArrayList<Integer>> list = combinationSum(candidates, target);
		for (ArrayList<Integer> l : list) {
			for (int x: l){
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {	
		Arrays.sort(candidates);
	    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> ans = new ArrayList<Integer>();
	    generateSum(0, candidates, target, ans, list);
	    return list;         
	}

	private static void generateSum(int k, int[] candidates, int target, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> list) {
	    if (target < 0 || k == candidates.length) return;
		for (int i = k; i < candidates.length; i++) {
	        if (candidates[i] < target) {
	        	//if (i > 0 && candidates[i] == candidates[i-1]) continue;
	            ans.add(candidates[i]);
	            generateSum(i+1, candidates, target-candidates[i], ans, list);
	            ans.remove(ans.size()-1);
	            while (i+1 < candidates.length && candidates[i] == candidates[i+1]) i++;
	        } else if (candidates[i] > target) {
	            continue;
	        } else {
		        ans.add(candidates[i]);
	            list.add(new ArrayList<Integer>(ans));
	            ans.remove(ans.size()-1);
	            while (i+1 < candidates.length && candidates[i] == candidates[i+1]) i++;
	        }
	    }
	}

}
