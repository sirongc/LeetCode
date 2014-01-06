package second_round;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANCD","ABC"));
	}
	public static String minWindow(String S, String T) {
	    int minlo = 0;
	    int minhi = 0;
	    int minlength = Integer.MAX_VALUE;
	    int[] needToFind = new int[256];
	    int[] hasFound = new int[256];

	    for (int i = 0; i < T.length(); i++)
	        needToFind[T.charAt(i)]++;

	    int count = 0;
	    for (int lo = 0, hi = 0; hi < S.length(); hi++) {
	        if (needToFind[S.charAt(hi)] == 0) continue;
	        if (hasFound[S.charAt(hi)] < needToFind[S.charAt(hi)]) count++;
	        hasFound[S.charAt(hi)]++;

	        if (count == T.length()) {
	            while (lo <= hi) {
	                if (needToFind[S.charAt(lo)] == 0) lo++;
	                else if (needToFind[S.charAt(lo)] < hasFound[S.charAt(lo)]) {
	                    hasFound[S.charAt(lo)]--;
	                    lo++;
	                } else {
	                    int length = hi - lo + 1;
	                    if (length < minlength) {
	                        minlength = length;
	                        minlo = lo;
	                        minhi = hi;
	                    }
	                    break;
	                }
	            }
	        }
	    }
	    if (minlength == Integer.MAX_VALUE) return "";
	    return S.substring(minlo, minhi+1);       
	    
	}
}
