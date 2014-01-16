package second_round;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code3");
		System.out.println(wordBreak("leetcode", dict));
	}
	
	public static boolean wordBreak(String s, Set<String> dict) {
	    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	    return wordBreak(s, 0, dict, map);     	    
	}

	public static boolean wordBreak(String s, int p, Set<String> dict, HashMap<Integer, Boolean> map) {
		if (p == s.length()) return true;
	    if (map.containsKey(p)) return map.get(p);
	    for (int i = p; i <= s.length(); i++) {
	        if (dict.contains(s.substring(p, i))) {
	            boolean canBeBroken = wordBreak(s, i, dict, map);
	            map.put(i, canBeBroken);
	            if (canBeBroken)
	                return true;
	        }
	    }
	    map.put(p, false);
	    return false;       	    
	}
}
