package second_round;

import java.util.ArrayList;
import java.util.HashSet;

public class WordLadderII {
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		//dict.add("dot");
		dict.add("dog");
		//dict.add("lot");
	//	dict.add("log");
		String start = "hot";
		String end = "dog";
		ArrayList<ArrayList<String>> ans = findLadders(start, end, dict);
		for (ArrayList<String> list: ans) {
			for (String s: list)
				System.out.print(s + " ");
			System.out.println();
		}
	}
	public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {    
	    int step = getMinStep(start, end, dict);
	    ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
	    if (step == -1) return ans;
	    ArrayList<String> list = new ArrayList<String>();
	    list.add(start);
	    generate(start, end, dict, step, list, ans);
	    return ans;
	}

	private static int getMinStep(String start, String end, HashSet<String> dict) {
	    HashSet<String> visited = new HashSet<String>();
	    ArrayList<String> frontier = new ArrayList<String>();
	    frontier.add(start);
	    int step = 1;
	    while (frontier.size() != 0) {
	        ArrayList<String> nextLevel = new ArrayList<String>();
	        for (String cur: frontier) {
	            for (int i = 0; i < cur.length(); i++) {
	                for (int j = 0; j < 26; j++) {
	                    String modified = modifyStr(cur, i, j);
	                    if (modified.equals(end))
	                        return step;
	                    if (!dict.contains(modified) || visited.contains(modified)) continue;
	                    nextLevel.add(modified);
	                    visited.add(modified);
	                }
	            }
	        }
	        frontier = nextLevel;
	        step++;
	    }
	    return -1;
	}

	private static void generate(String start, String end, HashSet<String> dict, int step, ArrayList<String> list, ArrayList<ArrayList<String>> ans) {
	    if (step == 0) return;
	    for (int i = 0; i < start.length(); i++) {
	        for (int j = 0; j < 26; j++) {
	            String modified = modifyStr(start, i, j);
	            if (modified.equals(end)) {
	                list.add(modified);
	                ans.add(new ArrayList<String>(list));
	                list.remove(list.size()-1);
	                return;
	            }
	            if (dict.contains(modified) && !list.contains(modified)) {
	                list.add(modified);
	                generate(modified, end, dict, step-1, list, ans);
	                list.remove(list.size()-1);
	            }
	        }
	    }
	}

	private static String modifyStr(String S, int j, int k) {
	    if (j == 0) return (char)('a' + k) + S.substring(1);
	    if (j == S.length()-1) return S.substring(0, S.length()-1) + (char)('a' + k);
	    return S.substring(0, j) + (char)('a' + k) + S.substring(j+1, S.length());
	}
}
