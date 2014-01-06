package first_round;

public class GasStation {
	public static void main(String[] args){
		
		
	}
	
	 public int canCompleteCircuit(int[] gas, int[] cost) {
		 for(int i = 0; i < gas.length; i++){
			 if(canCompleteCircuit(gas, cost, i) != -1) return i;
		 }
		 return -1;
	 }
	
     public int canCompleteCircuit(int[] gas, int[] cost, int j) {
    	int sum = 0;
    	for(int i = j; i < cost.length; i++){
    		sum += gas[i];
    		sum -= cost[i];
    		if(sum < 0){
    			return -1;
    		}
    	}
    	for(int i = 0; i < j; i++){
    		sum += gas[i];
    		sum -= cost[i];
    		if(sum < 0){
    			return -1;
    		}
    	}
    	return j; 	
    }
}
