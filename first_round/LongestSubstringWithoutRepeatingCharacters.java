package first_round;
import java.util.HashSet;


public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args){
		System.out.println(lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
	}
    public static int lengthOfLongestSubstring(String s) {
    	int max = 0;
    	int j = -1;
    	for(int i = 0; i < s.length(); i++){
    		int newLength = helper(s, i);
    		if(newLength > max){
    			max = newLength;
    			j = i;
    		}
    	}
    	
    	System.out.println(j);
    	return max;
    }
	private static int helper(String s, int i) {
		HashSet<Character> set = new HashSet<Character>();
		int length = 0;
		for(int j = i; j < s.length(); j++){
			if(!set.contains(s.charAt(j))){
				length++;
				set.add(s.charAt(j));
			}else{
				break;
			}
		}
		return length;
	}

}
