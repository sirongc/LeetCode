package first_round;
import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		ArrayList<String> list = letterCombinations("23");
		for(String s: list){
			System.out.println(s);
		}
	}

	public static ArrayList<String> letterCombinations(String digits) {
		if(digits.length() == 0 || digits == null){
			ArrayList<String> ans = new ArrayList<String>();
			ans.add("");
			return ans;
		}
		if(digits.length() == 1){
			String array = getIntArray(digits.charAt(0));
			ArrayList<String> ans = new ArrayList<String>();
			for(int i = 0; i < array.length(); i++){
				ans.add(String.valueOf(array.charAt(i)));
			}
			return ans;
		}
		
		String array = getIntArray(digits.charAt(digits.length() - 1));
		ArrayList<String> com = letterCombinations(digits.substring(0, digits.length() - 1));
		ArrayList<String> ans = new ArrayList<String>();
		for(int i = 0; i < array.length(); i++){
			ArrayList<String> temp = (ArrayList<String>) com.clone();
			for(String s: temp){
				s = s + array.charAt(i);
				ans.add(s);
			}
		}
		return ans;
	}

	public static String getIntArray(char digit) {
		switch (digit) {
		case '2':
			return "abc";
		case '3':
			return "def";
		case '4':
			return "ghi";
		case '5':
			return "jkl";
		case '6':
			return "mno";
		case '7':
			return "pqrs";
		case '8':
			return "tuv";
		case '9':
			return "wxyz";
		}
		return "";
	}

}
