package first_round;

public class ZigZagConversion {
	public static void main(String[] args){
		System.out.println(convert("ABCDEF", 4));
		
	}
	
    public static String convert(String s, int nRows) {
    	if(s == null || nRows <= 0) return null;
    	if(nRows == 1) return s;
    	StringBuilder sb = new StringBuilder();
    	int bigStep = (nRows - 1) * 2;
    	int step = bigStep;
    	for(int i = 0; i < nRows && i < s.length(); i++) {
    		int j = i;
    		int flag = 0;
    		while(j < s.length()){
    			if(step == 0){
    				step = bigStep - step;
    				flag++;
    				continue;
    			}
    			sb.append(s.charAt(j));
    			j += step;
    			step = bigStep - step;
    			flag++;
    		}
    		if(flag % 2 != 0){
    			step = bigStep - step;
    		}
    		step -= 2;
    	}
    	
    	
    	return sb.toString();
    }

}
