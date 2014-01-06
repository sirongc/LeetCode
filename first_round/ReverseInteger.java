package first_round;

public class ReverseInteger {
	public static void main(String[] args){
		System.out.println(reverse(-1223));
		
	}
	
    public static int reverse(int x) {
    	boolean isNeg = false;
    	if(x < 0) isNeg = true;
    	x = Math.abs(x);
    	
    	int lastDigit = 0;
    	int result = 0;
    	while(x > 0){
    		lastDigit = x % 10;
    		result = 10 * result + lastDigit;
    		x /= 10;
    	}
    	
    	if(x < 0) return -1;
    	
    	if(isNeg) return -1 * result;
    	
    	return result;
    }
}
