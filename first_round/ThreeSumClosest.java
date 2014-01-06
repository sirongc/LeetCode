package first_round;
import java.util.Arrays;


public class ThreeSumClosest {
	public static void main(String[] args){
		int[] num = {1,1,-1,-1,3};
		System.out.println(threeSumClosest(num, -1));
		
	}
	
    public static int threeSumClosest(int[] num, int target) {
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
    				int dif = Math.abs(num[j] + num[k] + temp - target); 
    				if(min > dif){
    					min = dif;
    					sum = num[j] + num[k] + temp;
    				}
    				k--;	
    			}else{
    				int dif = Math.abs(num[j] + num[k] + temp - target);  
    				if(min > dif){
    					min = dif;
    					sum = num[j] + num[k] + temp;
    				}
    				j++;
    			}
    		}	
    	}
		return sum;
    }

}
