package first_round;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static void main(String[] args){
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		
		WordBreak x = new WordBreak();
		System.out.println(x.wordBreak("leetcode", dict));
		
	}
	
	public boolean wordBreak(String s, Set<String> dict) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		return wordBreakHelper(s, dict, map);
	}

    public boolean wordBreakHelper(String s, Set<String> dict, HashMap<String, Boolean> map) {
    	if(map.containsKey(s)) return map.get(s);
    	
    	if(dict.contains(s)){
    		map.put(s, true);
    		return true;
    	}
    	int length = s.length();
    	for(int i = 1; i < length; i++){
    		if(dict.contains(s.substring(0, i))){
    			if(wordBreakHelper(s.substring(i, length), dict, map)){
    				map.put(s, true);
    				return true;
    			}
    		}
    	}
    	map.put(s, false);
    	return false;
    }
}
