package second_round;

public class PlusOne {
	public static void main(String[] args) {
		int[] digits = {2,3,4};
		int[] res = plusOne(digits);
		for (int i: res) System.out.print(i);
	}
	public static int[] plusOne(int[] digits) {
	    int[] res = new int[digits.length]; 
	    int c = 0;
	    int i = digits.length-1;
	    while (i >= 0) {
	    	if (i == digits.length - 1) {
	    		res[i] = (digits[i] + 1 + c) % 10;
		    	if (digits[i] + 1 + c >= 10)
		            c = 1;
		        else
		            c = 0;
	    	}
	    		
	    	else {
	    		res[i] = (digits[i] + c) % 10; 
	    		if (digits[i] + c >= 10)
		            c = 1;
		        else
		            c = 0;
	    	}	
	        i--;
	    }
	    if (c == 0)
	        return res;
	    else {
	        res = new int[digits.length+1];
	        res[0] = 1;
	        return res;
	    }
	}
}
