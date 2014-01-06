package second_round;

public class PalindromeNumber {
	public static void main(String[] args){
		System.out.println(isPalindrome(121312));
	}
	public static boolean isPalindrome(int x) {
	    if (x < 0) return false;
	    int length = getLength(x);
	    while (x > 0) {
	        int last = x % 10;
	        int first = (int) (x / Math.pow(10, length-1));
	        if (last != first) return false;
	        x = (int) ((x % Math.pow(10, length-1)) / 10);
	        length -= 2;
	    }
	    return true;
	}


	private static int getLength(int x) {
	    if (x == 0) return 1;
	    int length = 0;
	    while (x > 0) {
	        x /= 10;
	        length++;
	    }
	    return length;
	}



}
