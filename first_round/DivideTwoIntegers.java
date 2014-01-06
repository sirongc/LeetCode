package first_round;

public class DivideTwoIntegers {
	public static void main(String[] args){
		System.out.println(divide(9,0));
	}
	
    public static int divide(int dividend, int divisor) {
    	
    	if(divisor == 1) return dividend;
    	boolean isNeg = false;
    	if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
    		isNeg = true;
    	}
    	dividend = Math.abs(dividend);
    	divisor = Math.abs(divisor);
    	
    	int count = 0;
    	while(dividend > 0){
    		dividend -= divisor;
    		count++;
    	}
    	if(dividend < 0) count--;
    	
    	return (isNeg? -1 * count: count);
    }

}
