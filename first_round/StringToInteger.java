package first_round;

public class StringToInteger {
	public static void main(String[] args){
		System.out.println(atoi("+1"));
		
	}
	
    public static int atoi(String str) {
    	str = str.trim();
    	StringBuilder sb = new StringBuilder();
    	boolean isNeg = false;
    	if(str.length() == 0) return 0;

    	if(str.charAt(0) == '-') 
    		isNeg = true;
    	else if(str.charAt(0) == '+'){
    		
    	}else if(!Character.isDigit(str.charAt(0))){
    		return 0;
    	}else{
    		sb.append(str.charAt(0));
    	}
    		
    	
    	for(int i = 1; i < str.length(); i++){
    		if(Character.isDigit(str.charAt(i)))
    			sb.append(str.charAt(i));
    		else break;
    	}
    	
    	if(sb.length() == 0) return 0;
    	
    	if(!isValid(sb.toString())){
    		if(isNeg) return Integer.MIN_VALUE;
    		return Integer.MAX_VALUE;
    	}
    	
    	return (!isNeg ? Integer.parseInt(sb.toString()): -1 * Integer.parseInt(sb.toString()));
    }
    
    public static boolean isValid(String num){
    	try{
    		Integer.parseInt(num);
    	}catch(Exception e){
    		return false;
    	};
    	return true;
    }

}
