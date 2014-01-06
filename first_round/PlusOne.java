package first_round;

public class PlusOne {
	public static void main(String[] args){
		int[] digits = {9};
		digits = plusOne(digits);
		for(int i = 0; i < digits.length; i++){
			System.out.println(digits[i]);
		}
		
	}
	
    public static int[] plusOne(int[] digits) {
    	int lastIndex = digits.length - 1;
    	if(digits[lastIndex] != 9){
    		digits[lastIndex] = digits[lastIndex] + 1;
    		return digits;
    	}else{
    		digits[lastIndex] = 0;
    		int i = lastIndex - 1;
    		while(i >= 0 && digits[i] == 9){
    			digits[i] = 0;
    			i--;
    		}
    		if(i >= 0){
    			digits[i] = digits[i] + 1;
    			return digits;
    		}else{
    			int[] newDigits = new int[digits.length+1];
    			newDigits[0] = 1;
    			for(int j = 0; j < digits.length; j++){
    				newDigits[j+1] = digits[j];
    			}
    			return newDigits;
    		}
    	}
    }

}
