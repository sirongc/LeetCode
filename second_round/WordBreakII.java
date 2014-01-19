package second_round;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreakII {
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		ArrayList<String> res = wordBreak("catsanddog", dict);
		for (String s: res)
			System.out.println(s);
	}
	
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> ans = split(s, 0, dict, map);
	    return ans == null ? new ArrayList<String>() : ans;    
	}

	private static ArrayList<String> split(String s, int start, Set<String> dict, HashMap<Integer, ArrayList<String>> map) {
		if (map.containsKey(start)) 
			return map.get(start);
		
		boolean canSplit = false;
		ArrayList<String> res = new ArrayList<String>();
		for (int i = start; i < s.length(); i++) {
			String word = s.substring(start, i+1);
			if (dict.contains(word)) {
				//base condition
				if (i+1 == s.length()) {
					res.add(word);
					map.put(start, res);
					return res;
				}
				
				canSplit = true;
				ArrayList<String> left = split(s, i+1, dict, map);
				if (left != null) {
					for (int j = 0; j < left.size(); j++) 
						res.add(word + " " + left.get(j));
				}
			}
		}
		if (!canSplit) {
			map.put(start, null);
			return null;
		}
			
		map.put(start, res);
		return res;
	}
	

	/** DFS method
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
	    ArrayList<String> res = new ArrayList<String>();
	    generate(s, 0, "", dict, res);
	    return res;
	}

	private static void generate(String s, int start, String cur, Set<String> dict, ArrayList<String> res) {
	    if (start == s.length())
	        res.add(cur.substring(0, cur.length()-1));    
	        
	    for (int i = start; i < s.length(); i++) {
	        String word = s.substring(start, i+1);
	        if (dict.contains(word))
	            generate(s, i+1, cur + word + " ", dict, res);
	    }
	}**/
}
