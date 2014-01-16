package second_round;

public class ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome(" "));
	}
	public static boolean isPalindrome(String s) {		 
	    int lo = 0;
	    int hi = s.length() - 1;
	    while (lo <= hi) {
	        while (lo < s.length() && !isValid(s.charAt(lo))) lo++;
	        while (hi >= 0 && !isValid(s.charAt(hi))) hi--;
	        if (lo <= hi && hi >= 0 && lo < s.length()) {
	            if (Character.toUpperCase(s.charAt(lo)) != Character.toUpperCase(s.charAt(hi))) return false;
	            else {
	                lo++;
	                hi--;
	            }
	        }
	    }
	    return true;
	}

	private static boolean isValid(Character c) {
	    return ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <='Z'));
	}	
}
