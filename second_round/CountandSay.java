package second_round;

public class CountandSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(6));
	}
	public static String countAndSay(int n) {
	    if (n == 1) return "1";
	    if (n == 2) return "11";
	    String S = countAndSay(n - 1);
	    StringBuilder next = new StringBuilder();
	    int count = 1;
	    for (int i = 0; i < S.length() - 1; i++) {
	        if (S.charAt(i) != S.charAt(i+1)) {
	            next.append(count);
	            next.append(S.charAt(i));
	            count = 1;
	        } else count++;
	    }
	    next.append(count);
	    next.append(S.charAt(S.length() - 1));
	    return next.toString();
	}

}
