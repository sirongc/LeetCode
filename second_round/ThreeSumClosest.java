package second_round;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int length = num.length;
    	for(int i = 0; i < length-2; i++){
    		int temp = num[i];
    		int j = i + 1;
    		int k = length - 1;
    		while(j < k){
    			if(num[j] + num[k] + temp == target){
    				return target;
    			}else if(num[j] + num[k] + temp < target){
    				int dif = Math.abs(num[j] + num[k] + temp-target);
    				if(min > dif){
    					min = dif;
    					sum = num[j] + num[k] + temp;
    				}
    				j++;	
    			}else{
    				int dif = Math.abs(num[j] + num[k] + temp-target);
    				if(min > dif){
    					min = dif;
    					sum = num[j] + num[k] + temp;
    				}
    				k--;
    			}
    		}	
    	}
		return sum; 
    }
}
