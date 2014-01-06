package first_round;
import java.util.ArrayList;
import java.util.Arrays;


public class ThreeSum {
	public static void main(String[] args){
		int[] num = {-1,-1,-1,-1,-1,0,0,1,1,1,1,1};
		ArrayList<ArrayList<Integer>> lists = threeSum(num);
		for(ArrayList<Integer> list: lists){
			for(int i: list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	
    	if(num == null){
    		return null;
    	}
    	Arrays.sort(num);
    	System.out.println(" ");
    	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0; i < num.length-2; i++){
    		if(i > 0 && (num[i] == num[i-1])) continue;
    		int target = -1 * num[i];
    		int j = i+1;
    		int k = num.length-1;
    		while(j < k){
    			if(num[j] + num[k] == target){
    				ArrayList<Integer> list = new ArrayList<Integer>();
    				list.add(num[i]);
    				list.add(num[j]);
    				list.add(num[k]);
    				lists.add(list);
    				j++;
    				k--;
    				while(j < k && num[j] == num[j-1])
    					j++;
    				
    				while(j < k && num[k] == num[k+1])
    					k--;
    			}else if(num[j] + num[k] < target){
    				j++;
    			}else{
    				k--;
    			}
    		}
    	}
    	return lists;
    }
}
