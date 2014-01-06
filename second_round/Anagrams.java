package second_round;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {
	public static void main(String[] args) {
		String[] strs = {"tea","and","ate","eat","den"};
		ArrayList<String> ana = anagrams(strs);
		for (String s: ana) {
			System.out.println(s);
		}	
	}
	
	public static ArrayList<String> anagrams(String[] strs) {	 
	    ArrayList<String> ans = new ArrayList<String>();
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        HashMap<String, String> oriStringMap = new HashMap<String, String>();
        for (String s: strs) {
        	char[] ch = s.toCharArray();
        	Arrays.sort(ch);
        	String sortedS = new String(ch);
        	if (!map.containsKey(sortedS)) {
        		map.put(sortedS, false);
        		oriStringMap.put(sortedS, s);
        	} else{
        		map.put(sortedS, true);	
        		ans.add(s);
        	}
        }
        
        for (String s: map.keySet()) {
        	if (map.get(s)) ans.add(oriStringMap.get(s));
        }
        
	    return ans;
	}
	
	private static boolean isAnagram(String A, String B) {
	    if (A.length() != B.length()) return false;
	    int[] map = new int[26];
	    for (int i = 0; i < A.length(); i++) {
	        int c = A.charAt(i) - 'a';
	        map[c] = map[c] + 1;
	    }
	    for (int i = 0; i < B.length(); i++) {
	        int c = B.charAt(i) - 'a';
	        if (map[c] == 0) return false;
	        map[c] = map[c] - 1;
	    }
	    return true;
	}
}
