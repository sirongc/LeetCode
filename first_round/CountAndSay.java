package first_round;
import java.util.HashMap;
import java.util.LinkedList;


public class CountAndSay {
	public static void main(String[] args){
		String x = "123";
		System.out.println(countAndSay(5));
		
	}
	
    public static String countAndSay(int n) {
    	if(n == 1) return "1";
    	if(n == 2) return "11";
    	if(n == 3) return "21";
    	
    	HashMap<String, String> answerMap = new HashMap<String, String>();
    	answerMap.put("1", "11");
    	answerMap.put("2", "12");
    	answerMap.put("11", "21");
    	
    	LinkedList<Integer> lengthList = new LinkedList<Integer>();
    	lengthList.addFirst(1);
    	lengthList.addFirst(2);
    	
    	String str = "21";
    	StringBuilder sb = null;
    	for(int i = 3; i < n; i++){
    		String orig = new String(str);
    		sb = new StringBuilder();
    		while(str.length() > 0){
    			for(int j = 0; j < lengthList.size(); j++){
    				if(lengthList.get(j) <= str.length()){
            			if(answerMap.containsKey(str.substring(0, lengthList.get(j)))){
            				sb.append(answerMap.get(str.substring(0, lengthList.get(j))));
            				str = str.substring(lengthList.get(j));
            				break;
            			}
    				}
        		}
        	}
    		if(orig.length() > lengthList.get(0)){
    			lengthList.addFirst(orig.length());
    		}
    		answerMap.put(orig, sb.toString());
    		str = sb.toString();
    	}
    	
    	return sb.toString();
    }
    


}
