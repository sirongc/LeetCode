package second_round;

public class ValidNumber {
	public static void main(String[] args) {
		System.out.println(isNumber("-1."));
	}
	public static boolean isNumber(String s) {
	    s = s.trim();
	    int dotnum = 0;
	    int eNum = 0;
	    int dotpos = -1;
	    int epos = -1;
	    int digitnum = 0;

	    for (int i = 0; i < s.length(); i++) {
	        if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) continue;
	        else if (s.charAt(i) == 'e') {
	            eNum++;
	            epos = i;
	        }
	        else if (s.charAt(i) == '.') {
	            dotnum++;
	            dotpos = i;
	        } else if (!Character.isDigit(s.charAt(i)))
	            return false;
	        else digitnum++;
	    }
	    if (dotnum > 1 || eNum > 1 || epos == 0 || epos == s.length()-1 || digitnum == 0 || (eNum == 1 && dotnum == 1 && (epos < dotpos || Math.abs(epos-dotpos) == 1))) return false;
	    return true; 
	}
}
