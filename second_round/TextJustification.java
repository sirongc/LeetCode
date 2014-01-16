package second_round;

import java.util.ArrayList;

public class TextJustification {
	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		ArrayList<String> res = fullJustify(words, 16);
		for (String s: res) {
			System.out.println(s);
		}
	}
	public static ArrayList<String> fullJustify(String[] words, int L) {
	    ArrayList<String> res = new ArrayList<String>();
	    int i = 0;
	    boolean lastline = false;
	    while (i < words.length) {
	        int j = i;
	        int sum = 0;
	        while (j < words.length && sum <= L + 1)
	            sum += words[j++].length() + 1;
	        if (sum <= L + 1) lastline = true;
	        if (!lastline) {
	        	j -= 2;
	        	res.add(getLine(words, i, j, L, lastline));
	        }
	        	
	        else {
	        	res.add(getLine(words, i, words.length-1, L, lastline));
	        }
	        
	        i = j + 1;
	    }
	    return res;
	}

	private static String getLine(String[] words, int i, int j, int L, boolean lastline) {
		String res = "";
		int sum = 0;		
		for (int k = i; k <= j; k++) 
			sum += words[k].length();
		
		if (i == j) {
			res += words[i];
		} else {
			if (!lastline) {
				int space = (L - sum) / (j - i);
				int extraPad = (L - sum) % (j - i);	
				
				for (int k = i; k <= j; k++) {
					res += words[k];
					if (k < i + extraPad) {
						for (int t = 0; t < space + 1; t++)
							res += " ";
					} else {
						for (int t = 0; t < space; t++)
							res += " ";
					}
				}
			} else {
				for (int k = i; k <= j; k++) 
					res += words[k] + " ";
			}
		}
		res = res.trim();
		while (res.length() < L) {
			res += " ";
		}
		return res;
	}

}
