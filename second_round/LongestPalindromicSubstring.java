package second_round;

public class LongestPalindromicSubstring {
	public static void main(String[] args){
	    System.out.println(longestPalindrome("abcba"));
	}
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int max = 0;
        int lo = 0;;
        int hi = 0;;
        for (int i = 0; i < s.length() - 1; i++) {
            int[] evenLP = getEvenLP(s, i);
            int[] oddLP = getOddLP(s, i);
            if (evenLP[0] > oddLP[0] && max < evenLP[0]) {
                max = evenLP[0];
                lo = evenLP[1];
                hi = evenLP[2];
            }
            if (evenLP[0] < oddLP[0] && max < oddLP[0]) {
                max = oddLP[0];
                lo = oddLP[1];
                hi = oddLP[2];
            }
        }
        return s.substring(lo, hi+1);
    }

    private static int[] getEvenLP(String s, int p) {
        int lo = p;
        int hi = p+1;
        int length = 0;
        return getLP(s, lo, hi, length);
    }

    private static int[] getOddLP(String s, int p) {
        int lo = p-1;
        int hi = p+1;
        int length = 1;
        return getLP(s, lo, hi, length);
    }
    
    private static int[] getLP(String s, int lo, int hi, int length){
        while (lo >= 0 && hi < s.length()) {
            if (s.charAt(lo--) == s.charAt(hi++)) length +=2;
            else {
            	lo++;
            	hi--;
            	break;
            }
        }
        int[] result = new int[3];
        result[0] = length;
        result[1] = lo+1;
        result[2] = hi-1;
        return result;
    }
    
}
