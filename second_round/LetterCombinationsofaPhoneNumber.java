package second_round;

import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {
	public static void main(String[] args) {
		ArrayList<String> ans = letterCombinations("23");
		for (String s: ans) {
			System.out.print(s + " ");
		}
	}
	public static ArrayList<String> letterCombinations(String digits) {
	    char[][] table = {{}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'},{'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
	    ArrayList<String> ans = new ArrayList<String>();
	    generate(digits, "", 0, table, ans);
	    return ans;
	}

	private static void generate(String digits, String S, int p, char[][] table, ArrayList<String> ans) {
	    if (p == digits.length()) {
	        ans.add(S);
	        return;
	    }

	    int t = digits.charAt(p) - '0';
	    for (int i = 0; i < table[t-1].length; i++) {
	        generate(digits, S + table[t-1][i], p + 1, table, ans);
	    }
	}
}
