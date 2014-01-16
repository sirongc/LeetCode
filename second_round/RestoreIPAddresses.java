package second_round;

import java.util.ArrayList;

public class RestoreIPAddresses {
	public static void main(String[] args) {
		ArrayList<String> ans = restoreIpAddresses("010010");
		for (String s: ans) {
			System.out.println(s);
		}
	}
	
	public static ArrayList<String> restoreIpAddresses(String s) {
	    ArrayList<String> ans = new ArrayList<String>();
	    generate(0, 0, "", s, ans);
	    return ans;  	    
	}

	private static void generate(int p, int count, String cur, String s, ArrayList<String> ans) {
		if (p > s.length() || count > 4) return;
	    if (count == 4 && p == s.length()) {
	        ans.add(cur.substring(0, cur.length()-1));
	        return;
	    }

	    if (p < s.length() && isValid(s, p, 0)) 
	        generate(p+1, count + 1, cur + s.charAt(p) + ".", s, ans);
	    if (p + 1 < s.length() && isValid(s, p, 1))
	        generate(p+2, count + 1, cur + s.charAt(p) + s.charAt(p+1) + ".", s, ans);
	    if (p + 2 < s.length() && isValid(s, p, 2))
	        generate(p+3, count + 1, cur + s.charAt(p) + s.charAt(p+1) + s.charAt(p+2) + ".", s, ans);
	}

	private static boolean isValid(String s, int p, int k) {
		int num = Integer.parseInt(s.substring(p, p+k+1));
		if (k > 0 && s.charAt(p) == '0') return false;
		return num >= 0 && num <= 255;
	} 
}
