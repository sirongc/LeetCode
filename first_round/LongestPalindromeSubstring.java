package first_round;

public class LongestPalindromeSubstring {
	public static void main(String[] args){
		String x = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
	//	String x = "abasefesfe";
		System.out.println(longestPalindrome(x));
	}
    public static String longestPalindrome(String s) {
    	int maxLength = 0;
    	int maxLengthIndex = 0;
    	for(int i = 0; i < s.length(); i++){
    		int oddLength = lengthOfOddPalindrome(s, i);
    		int evenLength = lengthOfEvenPalindrome(s, i);
    		int newLength = Math.max(oddLength, evenLength);
    		if(maxLength < newLength){
    			maxLength = newLength;
    			maxLengthIndex = i;
    		}	
    	}
    	
    	String OddPalindrome = getOddPalindrome(s, maxLengthIndex);
    	String EvenPalindrome = getEvenPalindrome(s, maxLengthIndex);
    	return (OddPalindrome.length() > EvenPalindrome.length() ? OddPalindrome: EvenPalindrome);
        
    }
    
    private static String getOddPalindrome(String s, int i) {
    	int left = i;
    	int right = i;
    	while(left - 1 >= 0 && right + 1 < s.length()){
    		left--;
			right++;
    		if(s.charAt(left) != s.charAt(right)){
    			left++;
    			right--;
    			break;
    		}
    	}
		return s.substring(left, right + 1);
	}
    
    public static int lengthOfOddPalindrome(String s, int i){
    	int length = 1;
    	int left = i;
    	int right = i;
    	while(left - 1 >= 0 && right + 1< s.length()){
    		if(s.charAt(--left) == s.charAt(++right)) 
    			length += 2;
    		else break;
    	}
    	return length;
    }
    
    public static int lengthOfEvenPalindrome(String s, int i){
    	if(i >= s.length() - 1) return 0;
    	if(s.charAt(i) != s.charAt(i+1)) return 0;
    	int length = 2;
    	int left = i;
    	int right = i + 1;
    	while(left - 1 >= 0 && right + 1 < s.length()){
    		if(s.charAt(--left) == s.charAt(++right)) 
    			length += 2;
    		else break;
    	}
    	return length;
    }
    
    private static String getEvenPalindrome(String s, int i) {
    	if(i >= s.length() - 1) return "";
    	if(s.charAt(i) != s.charAt(i+1)) return "";
    	int left = i - 1;
    	int right = i + 2;
    	while(left-1 >= 0 && right < s.length()-1){
    		left--;
			right++;
    		if(s.charAt(left) != s.charAt(right)){
    			left++;
    			right--;
    			break;
    		}
    	}
    	if(left < 0 || right > s.length() - 1){
    		left++;
    		right--;
    	}
		return s.substring(left, right + 1);
	}
}
