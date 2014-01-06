package second_round;

public class LengthofLastWord {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World  "));
	}
    public static int lengthOfLastWord(String s) {
    	int j = 0;
    	for (int i = s.length()-1; i >= 0; i--) {
    		if (s.charAt(i) == ' ') {
    			if (j == 0) continue;
    			else break;
    		}
    		j++;
    	}
    	return j;     
    }
}
