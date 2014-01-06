package second_round;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    for (int i = 0; i < num.length - 2; i++) {
	        if (i > 0 && (num[i] == num[i-1])) continue;
	        int j = i+1;
	        int k = num.length-1;
	        int target = -1 * num[i];
	        while (j < k) {
	            if (num[j] + num[k] == target) {
	                ArrayList<Integer> list = new ArrayList<Integer>();
	                list.add(num[i]);
	                list.add(num[j]);
	                list.add(num[k]);
	                result.add(list);
	                k--;
	                j++;
	                while (j < k && num[j] == num[j-1]) j++;
	                while (j < k && num[k] == num[k+1]) k--;
	            } else if(num[j] + num[k] < target) { 
	                j++;
	            } else 
	                k--;
	        }           
	    }
	    return result;   
	}


}
