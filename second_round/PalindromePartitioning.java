package second_round;

import java.util.ArrayList;

public class PalindromePartitioning {
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> ans = partition("aab");
		for (ArrayList<String> temp: ans) {
			for (String s: temp) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
	public static ArrayList<ArrayList<String>> partition(String s) {
	    ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
	    ArrayList<String> temp = new ArrayList<String>();
	    generate(s, 0, temp, ans);
	    return ans;
	}

	private static void generate(String s, int start, ArrayList<String> temp, ArrayList<ArrayList<String>> ans) {
	    if (start == s.length()) {
	        ans.add(new ArrayList<String>(temp));
	        return;
	    }

	    for (int i = start; i < s.length(); i++) {
	        if (isPalindrome(s, start, i)) {
	            temp.add(s.substring(start, i+1));
	            generate(s, i+1, temp, ans);
	            temp.remove(temp.size()-1);
	        }
	    }
	}

	private static boolean isPalindrome(String s, int lo, int hi) {
	    while (lo <= hi) {
	        if (s.charAt(lo) != s.charAt(hi))
	            return false;
	        else {
	            lo++;
	            hi--;
	        }
	    }
	    return true;
	}
	        
	        
}
