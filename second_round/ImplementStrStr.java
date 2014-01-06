package second_round;
public class ImplementStrStr {
    public String strStr(String haystack, String needle) {
    	int i = 0;
    	int j = needle.length();
    	for (int k = j; k <= haystack.length(); k++) {
    		if (needle.equals(haystack.substring(i, k))) return haystack.substring(i);
    		i++;
    	}
    	return null;
    }
}
