package second_round;

import java.util.ArrayList;
import java.util.HashSet;

public class WordLadder {
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(ladderLength(start, end, dict));
		System.out.println("abc".substring(1));
	}
	public static int ladderLength(String start, String end, HashSet<String> dict) {
	    ArrayList<String> frontier = new ArrayList<String>();
	    HashSet<String> added = new HashSet<String>();
	    frontier.add(start);
	    added.add(start);
	    int step = 1;
	    while (frontier.size() != 0) {
	        ArrayList<String> nextLevel = new ArrayList<String>();
	        for (int i = 0; i < frontier.size(); i++) {
	            for (int j = 0; j < frontier.get(i).length(); j++) {
	                for (int k = 0; k < 26; k++) {
	                    String modified = modify(frontier.get(i), j, k);
	                    if (modified.equals(end)) return step + 1;
	                    if (added.contains(modified) || !dict.contains(modified)) continue;            
	                    nextLevel.add(modified);
	                    added.add(modified);
	                }
	            }
	        }
	        frontier = nextLevel;
	        step++;
	    }     
	    return -1;
	}

	private static String modify(String S, int j, int k) {
		if (j == S.length()-1) return S.substring(0, S.length()-1) + (char)('a' + k);
		return S.substring(0, j) + (char)('a' + k) + S.substring(j+1, S.length());
	}

}
