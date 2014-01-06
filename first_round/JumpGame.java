package first_round;
import java.util.HashMap;


public class JumpGame {
	public static void main(String[] args){
		int[] A = {3,2,1,0,4};
		System.out.println(canJump(A));
	}
	
	//A = [2,3,1,1,4], return true.

	// A = [3,2,1,0,4], return false.
	
	 public static boolean canJump(int[] A) {
		 int maxIndex = 0;
		 for(int i = 0; i < A.length; i++){
			 if(i <= maxIndex){
				 maxIndex = Math.max(A[i] + i, maxIndex);
			 }else{
				 return false;
			 }
		 }
	     return true;
	 }
	 
	 
	 public static boolean canJump1(int[] A) {
		 if(A.length == 1) return true;
		 HashMap<Integer, Boolean> map = new HashMap();
	     return helper(A, 2, map);
	 }
	    
	 private static boolean helper(int[] A, int i, HashMap<Integer, Boolean> map){
		if(map.containsKey(i)) return map.get(i);
	    int jumpSteps = A[i];
		int maxIndex = jumpSteps + i;
		if(maxIndex >= A.length-1) return true;
			
		for(int j = i + 1; j < A.length && j <= maxIndex; j++){
			if(helper(A, j, map)){
				map.put(i, true);
				return true;
			}
		}
		map.put(i, false);
		return false;
	 }

}
