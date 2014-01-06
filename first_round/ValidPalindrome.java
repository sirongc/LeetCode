package first_round;

public class ValidPalindrome {
	
	//"race a car" is not a palindrome.
	//"A man, a plan, a canal: Panama" is a palindrome.
	
	public static void main(String[] args){
		System.out.println(isPalindrome(" "));
	}
	
	
    public static boolean isPalindrome(String s) {
    	int left = 0;
    	int right = s.length() - 1;
    	
    	while(left <= right){
    		while(left < s.length() && !Character.isLetterOrDigit(s.charAt(left))){
    			left++;
    		};
    		while(right >= 0 && !Character.isLetterOrDigit(s.charAt(right))){
    			right--;
    		}
    		if(left >= s.length() || right < 0) return true;
    		if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
    		left++;
    		right--;
    	}
        return true;
    }

}
