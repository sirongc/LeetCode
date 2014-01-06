package first_round;

public class ScrambleString {
	public static void main(String[] args){
		System.out.println(isScramble("rgtae", "rgeat"));
	   // System.out.println("ab".substring(1,2));
	}
	
    public static boolean isScramble(String s1, String s2) {
    	if(s1.length() != s2.length()) return false;
    	int length = s1.length();
    	int mid = length / 2;
    	if(length == 1){
    		if(s1.equals(s2)) return true;
    		else return false;
    	}
    	for(int i = 1; i <= mid; i++){
        	if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, length), s2.substring(i, length))){
        		return true;
        	}
        	if(isScramble(s1.substring(0, i), s2.substring(length-i, length)) && isScramble(s1.substring(i, length), s2.substring(0, length-i))){
        		return true;
        	}
    	}
    	return false;	
    }
}
