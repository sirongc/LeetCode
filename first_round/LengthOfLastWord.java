package first_round;

public class LengthOfLastWord {
	public static void main(String[] args){
		System.out.println(lengthOfLastWord("Hello World"));
	}
    public static int lengthOfLastWord(String s) {
    	s = s.trim();
    	int length = 0;
    	for(int i = 0; i < s.length(); i++){
    		if(s.charAt(i) != ' '){
    			length++;
    		}else{
    			length = 0;
    		}
    	}
        return length;
    }
}
