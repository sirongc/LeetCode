package second_round;

public class WildcardMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb","***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**"));
	}
	public static boolean isMatch(String s, String p) {
	    if (s.equals("")) 
	        return p.equals("") || p.equals("*");
	    if (p.equals("")) return false;
	    if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')
	        return isMatch(s.substring(1), p.substring(1));
	    if (p.charAt(0) == '*') {
	    	int j = 0;
	    	while (j + 1 < p.length() && p.charAt(j) == p.charAt(j+1)) j++;
	        for (int i = j; i < s.length(); i++) {
	            if (isMatch(s.substring(i+1), p.substring(1))) return true;
	        }
	    }
	    return false;
	}

}
