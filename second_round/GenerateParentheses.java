package second_round;

import java.util.ArrayList;

public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
	    ArrayList<String> result = new ArrayList<>();
	    generate(result, "", 0, 0, n);
	    return result;
	}

	public void generate(ArrayList<String> result, String s, int leftCount, int rightCount, int pairs) {
	    if (leftCount == pairs) {
	        for (int i = 0; i < leftCount-rightCount; i++) {
	            s += ")";
	        }
	        result.add(s);
	    }
	    generate(result, s + "(", leftCount + 1, rightCount, pairs);
	    if (rightCount < leftCount) generate(result, s + ")", leftCount, rightCount + 1, pairs);
	}
	    

}
