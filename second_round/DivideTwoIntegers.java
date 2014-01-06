package second_round;

public class DivideTwoIntegers {
	public static void main(String[] args) {
		System.out.println(divide(-1010369383,-2147483648));
	}
	public static int divide(int dividend, int divisor) {
	    if (divisor == 1) return dividend;
	    boolean isNeg = false;
	    if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) isNeg = true;
	    
	    long a = (dividend >= 0 ?  dividend : -1 * (long) dividend);
	    long b = (divisor >= 0 ?  divisor : -1 * (long) divisor);

	    int count = 0;
	    int i = 0;
	    while (a >= b) {
	        long sum = b * (1 << i);
	        if (a >= sum) {
	            count += 1 << i;
	            a -= sum;
	            i++;
	        } else i = 0;
	     }
	     return (isNeg ? -1 * count : count);
	}
}
