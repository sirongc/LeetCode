package second_round;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringwithConcatenationofAllWords {
	public static void main(String[] args) {
		String[] L = {"a"};
		ArrayList<Integer> list = findSubstring("a", L);
		for (int x: list){
			System.out.println(x);
		}
	}
	public static ArrayList<Integer> findSubstring(String S, String[] L) {

	    ArrayList<Integer> indices = new ArrayList<Integer>();
	    if (S == null || L == null) return indices;

	    int lengthPK = L[0].length();
	    int numberOfKeys = L.length;

	    HashMap<String, Integer> wordMap = new HashMap<String, Integer>(); 
	    for (String s: L) {
	        if (!wordMap.containsKey(s))  
	        	wordMap.put(s,1);
	        else wordMap.put(s, wordMap.get(s) + 1);
	    } 

	    for (int i = 0; i <= S.length() - lengthPK * numberOfKeys; i++) {
	        HashMap<String, Integer> map = new HashMap<String, Integer>(wordMap);
	        int j = i;
	        int numOfIteration = 0;
	        for (int k = 0; k < numberOfKeys; k++) {
	            String sub = S.substring(j, j+lengthPK);
	            if (map.containsKey(sub)) {
	                map.put(sub, map.get(sub)-1);
	                if (map.get(sub) < 0) break;
	            } else break;
	            j += lengthPK;
	            numOfIteration++;
	        }
	        if (numOfIteration == numberOfKeys) indices.add(i);
	    }
	    return indices;
	}
}
