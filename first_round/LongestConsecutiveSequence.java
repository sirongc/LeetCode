package first_round;
import java.util.HashMap;
import java.util.HashSet;


public class LongestConsecutiveSequence {
	public static void main(String[] args){
		int[] num = {100, 4, 200, 1, 3, 2, 5,0};
		System.out.println(longestConsecutive(num));
	}
	
    public static int longestConsecutive(int[] num) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	for(int n: num){
    		set.add(n);
    	}
    	
    	int max = 0;
    	for(int i = 0; i < num.length; i++){
    		int length = 1;
    		int left = num[i] - 1;
    		int right = num[i] + 1;
    		while(set.contains(left) || set.contains(right)){
    			if(set.contains(left)){
    				length++;
    				set.remove(left);
        			left--;
        		}
    			if(set.contains(right)){
    				length++;
    				set.remove(right);
        			right++;
        		}
    		}
    		max = Math.max(max, length);
    	}
    	
    	return max;
    }

}
