package second_round;

public class TrappingRainWater {
	public int trap(int[] A) {
	    if (A == null) return 0;
	    int maxWater = 0;
	    int maxIndex = 0;
	    for (int i = 0; i < A.length; i++) {
	        if (A[i] > A[maxIndex]) maxIndex = i;
	    }
	    
	    int curHi = 0;
	    for (int i = 0; i < maxIndex; i++) {
	        if (A[i] <= curHi) maxWater += curHi - A[i];
	        else curHi = A[i];
	    }
	    curHi = 0;
	    for (int i = A.length-1; i > maxIndex; i--) {
	        if (A[i] <= curHi) maxWater += curHi - A[i];
	        else curHi = A[i];
	    }
	    return maxWater;
	}
}
