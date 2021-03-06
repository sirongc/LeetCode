package second_round;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
	    int total = 0;
	    int j = -1;
	    for (int i = 0; i < gas.length; i++) {
	        sum += gas[i] - cost[i];
	        total += gas[i] - cost[i];
	        if (sum < 0) {
	            j = i + 1;
	            sum = 0;
	        }
	    }
	    return total >= 0 ? j : -1;  
	}
}
