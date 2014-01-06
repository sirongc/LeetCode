package first_round;

public class AddBinary {
	public static void main(String[] args){
		System.out.println(addBinary("11","1"));
		System.out.println('3'-'0');
	}
	
    public static String addBinary(String a, String b) {
    	char[] A = a.toCharArray();
    	char[] B = b.toCharArray();
    	int i = A.length - 1;
    	int j = B.length - 1;
    	int c = 0;
    	
    	StringBuilder sum = new StringBuilder();
    	while(i >= 0 && j >= 0){
    		int temp = (A[i--] -'0') + (B[j--] - '0') + c;
    		if(temp == 0){
    			c = 0;
    			sum.append(0);
    		}
    		else if(temp == 1){
    			c = 0;
    			sum.append(1);
    		}
    		else if(temp == 2){
    			c = 1;
    			sum.append(0);
    		}
    		else if(temp == 3){
    			c = 1;
    			sum.append(1);
    		}
    	}
    	
    	while(i >= 0){
    		int temp = (A[i--] -'0') + c;
    		if(temp == 0){
    			c = 0;
    			sum.append(0);
    		}
    		else if(temp == 1){
    			c = 0;
    			sum.append(1);
    		}
    		else if(temp == 2){
    			c = 1;
    			sum.append(0);
    		}
    	}
    	
    	while(j >= 0){
    		int temp = (B[j--] -'0')+ c;
    		if(temp == 0){
    			c = 0;
    			sum.append(0);
    		}
    		else if(temp == 1){
    			c = 0;
    			sum.append(1);
    		}
    		else if(temp == 2){
    			c = 1;
    			sum.append(0);
    		}
    	}
    	
    	if(c == 1) sum.append(1);
    	sum.reverse();
        return sum.toString();
    }

}
