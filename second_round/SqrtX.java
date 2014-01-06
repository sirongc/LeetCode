package second_round;

public class SqrtX {
	public static void main(String[] args) {
		System.out.println(sqrt(1));
	}
	public static int sqrt(int x) { 
	    long lo = 0;
	    long hi = x;
	    while (lo <= hi) {
	        long mid = (lo + hi) / 2;
	        long sq = mid * mid;
	        if (sq == x) return (int)mid;
	        if (sq < x) lo = mid + 1;
	        else hi = mid - 1;
	    }
	    return (int) hi;
	}
}
