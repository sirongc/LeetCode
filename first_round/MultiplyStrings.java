package first_round;

public class MultiplyStrings {
	public static void main(String[] args){
		
		System.out.println(multiply("1","101"));
		
	}
    public static String multiply(String num1, String num2) {
    	if(num1.equals("0") || num2.equals("0")) return "0";
    	int length = num2.length();
    	StringBuilder finalNum = new StringBuilder("0");
    	for(int i = 0; i < length; i++){
    		finalNum = add(multiply(num1, num2.charAt(length - 1 - i), i), finalNum);
    	}

        return finalNum.toString();
    }
    
    public static StringBuilder add(StringBuilder num1, StringBuilder num2){
    	int i = num1.length() - 1;
    	int j = num2.length() - 1;
    	int c = 0;
    	StringBuilder sb = new StringBuilder();
    	while(i >= 0 && j >= 0){
    		int temp = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + c;
    		c = temp / 10;
    		sb.append(temp % 10);
    		i--;
    		j--;
    	}
    	while(i >= 0){
    		int temp = (num1.charAt(i) - '0') + c;
    		c = temp / 10;
    		sb.append(temp % 10);
    		i--;
    	}
    	while(j >= 0){
    		int temp = (num2.charAt(j) - '0') + c;
    		c = temp / 10;
    		sb.append(temp % 10);
    		j--;
    	}
    	if(c != 0)
    		sb.append(c);
    	sb.reverse();
    	return sb;
    }
    
    public static StringBuilder multiply(String num, char digit, int zeroNumber){
    	int pos = num.length() - 1;
    	int c = 0;
    	StringBuilder sb = new StringBuilder();
    	for(int i = pos; i >=0; i--){
    		int temp = (digit - '0') * (num.charAt(i) - '0') + c;
    		c = temp / 10;
    		sb.append(temp % 10);
    	}
    	if(c != 0)
    		sb.append(c);
    	sb.reverse(); 
    	for(int i = 0; i < zeroNumber; i++){
    		sb.append('0');
    	}
    	return sb;
    }
}
