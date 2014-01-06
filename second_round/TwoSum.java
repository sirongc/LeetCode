package second_round;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
	    if (nums == null) return null;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        if (map.containsKey(nums[i])) {
	            int[] result = new int[2];
	            result[0] = map.get(nums[i]) + 1;
	            result[1] = i + 1;
	            return result;
	         } else {
	            map.put(target-nums[i], i);
	         }
	     }
	     return null;
	}

}
