package second_round;

import java.util.HashMap;

public class ScrambleString {
	public static void main(String[] args) {
		System.out.println(isScramble("tqxpxeknttgwoppemjkivrulaflayn", "afaylnlurvikjmeppowgttnkexpxqt"));
	}
	public static boolean isScramble(String s1, String s2) {	
		if (s1.length() != s2.length()) return false;
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		return isScramble(s1, s2, map);
	}
	
	/**
	public static boolean isScramble(String s1, String s2, int s1lo, int s1hi, int s2lo, int s2hi, int[][][][] map) {	
		if (s1lo < 0 || s2lo < 0 || s1hi < 0 || s2hi < 0 || s1hi >= s1.length() || s2hi >= s2.length()) return false;
	    if (s1hi - s1lo != s2hi - s2lo) return false;
	    if (s1hi < s1lo) return true;
	    if (map[s1lo][s1hi][s2lo][s2hi] != 0) return map[s1lo][s1hi][s2lo][s2hi] == 1;
	    if (s1hi == s1lo) return s1.charAt(s1lo) == s2.charAt(s2lo);

	    for (int i = s1lo + 1; i <= s1hi; i++) {
	    	boolean result1 = false;
	    	if (s1lo >= 0 && i-1 >= 0 && s2lo >= 0 && s2hi >= 0) {
	    		map[s1lo][i-1][s2lo][i-1] = isScramble(s1, s2, s1lo, i-1, s2lo, i-1, map) ? 1 : -1;
	    	    map[i][s1hi][i][s2hi] = isScramble(s1, s2, i, s1hi, i, s2hi, map) ? 1 : -1;
	    	    result1 = map[s1lo][i-1][s2lo][i-1] == 1 && map[i][s1hi][i][s2hi] == 1;
	    	}

	    	    
	    	
	    	boolean result2 = false;
	    	if (s1lo >= 0 && i-1 >= 0 && s2hi-i+1 >= 0 && s2hi-i >= 0) {
		    	map[s1lo][i-1][s2hi-i+1][s2hi] = isScramble(s1, s2, s1lo, i-1, s2hi-i+1, s2hi, map) ? 1 : -1;
		    	map[i][s1hi][s2lo][s2hi-i] = isScramble(s1, s2, i, s1hi, s2lo, s2hi-i, map) ? 1 : -1;
		    	result2 = map[s1lo][i-1][s2hi-i+1][s2hi] == 1 && map[i][s1hi][s2lo][s2hi-i] == 1;
	    	}

	    	
	       // if ((isScramble(s1, s2, s1lo, i-1, s2lo, i-1, map) && isScramble(s1, s2, i, s1hi, i, s2hi, map)) || (isScramble(s1, s2, s1lo, i-1, s2hi-i+1, s2hi, map) && isScramble(s1, s2, i, s1hi, s2lo, s2hi-i, map)))
	        if (result1 || result2)	
	        	return true;
	    }
	    return false;  	    
	}
	**/
	public static boolean isScramble(String s1, String s2, HashMap<String, Boolean> map) {	 
		String key = s1.compareTo(s2) > 0? s1 + s2 : s2 + s1;
		if (map.containsKey(key)) return map.get(key);
		
	    if (s1.length() != s2.length()) {
	    	map.put(key, false);
	    	return false;
	    }
	    if (s1.length() == 0) {
	    	map.put(key, true);
	    	return true;
	    }
	    if (s1.length() == 1) {
	    	map.put(key, s1.equals(s2));
	    	return s1.equals(s2);
	    }

	    for (int i = 1; i < s1.length(); i++) {
	        String left1 = s1.substring(0, i);
	        String right1 = s1.substring(i);
	        
	        String left2 = s2.substring(0, i);
	        String right2 = s2.substring(i);  
	        
	        String left3 = s2.substring(0, s2.length() - i);
	        String right3 = s2.substring(s2.length() - i);
	        
	        if ((isScramble(left1, left2, map) && isScramble(right1, right2, map)) || isScramble(left1, right3, map) && isScramble(right1, left3, map)) {
	        	map.put(key, true);
	        	return true;
	        }
	        	
	            
	    }
	    map.put(key, false);
	    return false;  	    
	}
/**	
	public static boolean isScramble(String s1, String s2) {	 
	    if (s1.length() != s2.length()) return false;
	    if (s1.length() == 0) return true;
	    if (s1.length() == 1) return s1.equals(s2);

	    for (int i = 1; i < s1.length(); i++) {
	        String left1 = s1.substring(0, i);
	        String right1 = s1.substring(i);
	        
	        String left2 = s2.substring(0, i);
	        String right2 = s2.substring(i);  
	        
	        String left3 = s2.substring(0, s2.length() - i);
	        String right3 = s2.substring(s2.length() - i);
	        if ((isScramble(left1, left2) && isScramble(right1, right2)) || (isScramble(left1, right3) && isScramble(right1, left3)))
	            return true;
	    }
	    return false;  	    
	}
	**/
	
}
