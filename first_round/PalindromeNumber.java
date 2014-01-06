package first_round;

public class PalindromeNumber {
	public static void main(String[] args){
		System.out.println(isPalindrome(122321));
	}
	
    public static boolean isPalindrome(int x) {
    	if(x < 0) return false;
    	int result = 0;
    	int lastDigit = 0;
    	int y = x;
    	while(y > 0){
    		lastDigit = y % 10;
    		result = result * 10 + lastDigit;
    		y /= 10;
    	}
    	
    	if(result < 0) return false;

    	return result == x;
    }
    

}
