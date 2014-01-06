package first_round;
import java.util.HashMap;


public class ClimbingStairs {
	public static void main(String[] args){
		ClimbingStairs x = new ClimbingStairs();
		System.out.println(x.climbStairs(38));
		
	}
    public int climbStairs(int n) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	return helper(n, map);
    }
    
    public int helper(int n, HashMap<Integer, Integer> map){
    	if(map.containsKey(n)) return map.get(n);
    	if(n <= 0) return 0;
    	if(n == 1) return 1;
    	if(n == 2) return 2;
    	int steps = helper(n-1, map) + helper(n-2, map);
    	map.put(n, steps);
    	return steps;
    }

}
