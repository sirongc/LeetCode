package second_round;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	public static void main(String[] args) {
		int[] num = {-1,0,1,2,-1,-4};
		ArrayList<ArrayList<Integer>> result = fourSum(num, -1);
		for (ArrayList<Integer> list: result) {
			for (int i: list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	    Arrays.sort(num);

	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    for (int m = 0; m < num.length - 3; m++) {
	        if (m > 0 && (num[m] == num[m-1])) continue;
	        for (int i = m + 1; i < num.length - 2; i++) {
	            if (i > m+1 && (num[i] == num[i-1])) continue;
	            int j = i + 1;
	            int k = num.length-1;
	            
	            while (j < k) {
	            	int sum = num[m] + num[i] + num[j] + num[k];
	                if (sum == target) {
	                    ArrayList<Integer> list = new ArrayList<Integer>();
	                    list.add(num[m]);
	                    list.add(num[i]);
	                    list.add(num[j]);
	                    list.add(num[k]);
	                    result.add(list);
	                    k--;
	                    j++;
	                    while (j < k && num[j] == num[j-1]) j++;
	                    while (j < k && num[k] == num[k+1]) k--;
	                } else if(sum < target) { 
	                    j++;
	                } else 
	                    k--;
	            }           
	        }
	    }
	    return result;   
	}
}
