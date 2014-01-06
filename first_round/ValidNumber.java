package first_round;

public class ValidNumber {
	public static void main(String[] args){
		System.out.println(isNumber("."));
	}
	
    public static boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0) return false;
        if(s.length() == 1 && Character.isDigit(s.charAt(0))) return true;
    	int eCount = 0;
    	int dotCount = 0;
    	int digitCount = 0;
    	if(!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+'&& s.charAt(0) != '.') 
    		return false;
    	else if(s.charAt(0) == '.'){
    		dotCount++;
    	}else if(Character.isDigit(s.charAt(0))){
    	    digitCount++;
    	}
    	for(int i = 1; i < s.length(); i++){
    		if(s.charAt(i) == 'e'){
    			eCount++;
     			if(eCount > 1 || i == s.length() - 1 || i == 0) return false;
    			if(s.charAt(i+1) == '.' || (s.charAt(i - 1) == '.' && i == 1) || digitCount == 0) return false;
    		}else if(s.charAt(i) == '.'){
    			dotCount++;
    			if(dotCount > 1 || s.length() == 1 || eCount != 0) return false;
    		}else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
    		    if(s.charAt(i-1) != 'e' || i == s.length()-1) return false;
    		}else if (!Character.isDigit(s.charAt(i))){
    			return false;
    		}else{
    		    digitCount++;
    		}
    	}
    	if(digitCount == 0) return false;
        return true;
    }
}
