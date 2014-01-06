package second_round;

public class DecodeWays {
	public static void main(String[] args) {
		System.out.println(numDecodings("110"));
	}
	public static int numDecodings(String s) {
	    int n = s.length();
	    if (n == 0) return 0;
	    int[] f = new int[n+1];
	    f[0] = 1;
	    if (isValid(s.substring(0,1))) f[1] = 1;
	    else f[1] = 0;
	    for (int i = 2; i <= n; i++) {
	        if (isValid(s.substring(i-1, i)))
	            f[i] = f[i-1];
	        if (isValid(s.substring(i-2, i)))
	            f[i] += f[i-2];
	    }
	    return f[n];
	}

	private static boolean isValid(String s) {
	    if (s.charAt(0) == '0') return false;
	    int code = Integer.parseInt(s);
	    return code >= 1 && code <= 26;
	}
}
