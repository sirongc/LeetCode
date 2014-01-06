package first_round;

public class LongestCommonPrefix {
	public static void main(String[] args){

		
		String[] strs = {"aa","a"};
		System.out.println(longestCommonPrefix(strs));
		
		
	}
	
    public static String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0 || strs == null) return "";
    	StringBuilder sb = new StringBuilder();
    	int j = 0;
    	for(int k = 0; k < strs[0].length(); k++){
        	for(int i = 1; i < strs.length; i++){
        		if(j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)){
        			return sb.toString();
        		}
        	}
        	sb.append(strs[0].charAt(j));
        	j++;
    	}
    	return sb.toString();
    }

}
