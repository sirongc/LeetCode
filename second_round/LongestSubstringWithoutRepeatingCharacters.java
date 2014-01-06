package second_round;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args){
		System.out.println(lengthOfLongestSubstring(""));
	}
	
	
	public static int lengthOfLongestSubstring(String s) {
        int p = 0;
        int maxlength = 0;
        while (p < s.length()) {
            int[] result = getMaxLength(s, p);
            maxlength = Math.max(result[0], maxlength);
            p = result[1] + 1;
        }
        return maxlength;
    }

	private static int[] getMaxLength(String s, int p) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int length = 0;
		int[] result = new int[2];
		while (p < s.length()) {
			if (!map.containsKey(s.charAt(p))){
				length++;
				map.put(s.charAt(p), p);
			} else {
				result[0] = length;
				result[1] = map.get(s.charAt(p));
				return result;
			}
			p++;
		}
		//假设之前没return，就说明一直到string尾部都不会有重复了，那就直接返回length的值，后面都不用判断了。
		result[0] = length;
		result[1] = s.length();
		return result;
	}
}


