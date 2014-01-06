package second_round;

public class RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("",""));
	}
	
	public static boolean isMatch(String s, String p) {
		int[][] map = new int[s.length()+1][p.length()+1];
		return isMatch(s, p, 0, 0, map);
	}
	
	public static boolean isMatch(String s, String p, int sp, int pp, int[][] map) {
	    if (pp == p.length()) return sp == s.length();
	    if (map[sp][pp] != 0) return map[sp][pp] == 1;
	    if (pp == p.length() - 1 || p.charAt(pp+1) != '*') {
	    	 boolean ans = (sp < s.length() && (p.charAt(pp) == s.charAt(sp) || p.charAt(pp) == '.')) && isMatch(s, p, sp+1, pp+1, map);
	    	 if (ans) map[sp][pp] = 1;
	    	 else map[sp][pp] = 2;
	    	 return ans; 
	    }
	    while (sp < s.length() && (p.charAt(pp) == s.charAt(sp) || p.charAt(pp) == '.')) {
	        if (isMatch(s, p, sp, pp + 2, map)) {
	        	map[sp][pp] = 1;
	        	return true;
	        }
	        sp++;
	    }
	    boolean ans = isMatch(s, p, sp, pp + 2, map);
	    if (ans) map[sp][pp] = 1;
	    else map[sp][pp] = 2;
	    return ans;	
	 }

}
