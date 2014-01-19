package second_round;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		ArrayList<ArrayList<Integer>> list = combinationSum2(candidates, target);
		for (ArrayList<Integer> l : list) {
			for (int x: l){
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	 public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> temp = new ArrayList<Integer>();
	        boolean[] visited = new boolean[num.length];
	        Arrays.sort(num);
	        helper(num, res, temp, visited, target, 0);
	        return res;
	    }
	    
	    public static void helper(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, boolean[] visited, int target, int i){
	        if(target == 0){
	            res.add(new ArrayList<Integer>(temp));
	            return;
	        }
	        
	        for(int j=i; j<num.length; j++){
	            if(num[j] > target) break;
	            if(!visited[j]){
	                temp.add(num[j]);
	                visited[j] = true;
	                helper(num, res, temp, visited, target-num[j], j);
	                visited[j] = false;
	                temp.remove(temp.size()-1);
	            }
	            while(j+1<num.length && num[j] == num[j+1]) j++;
	        }
	        return;
	    }


}
