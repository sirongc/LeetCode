package first_round;

public class DistinctSubsequences {
	//需要bottom up DP的知识，递归会出错，两个又不好用top down DP
	public static void main(String[] args){
		System.out.println(numDistinct("rabbbit","rabbit"));
	}
	
    public static int numDistinct(String S, String T) {
    	if(S.length() < T.length()) return 0;
    	if(S.length() == T.length()){
    		if(S.equals(T))
    			return 1;
    		else
        		return 0;
    	}
    	if(T.length() == 1){
    		int count = 0;
    		char t = T.charAt(0);
    		for(int i = 0; i < S.length(); i++){
    			if(S.charAt(i) == t) count++;
    		}
    		return count;
    	}
    	
    	if(S.charAt(S.length() - 1) != T.charAt(T.length() - 1)){
    		return numDistinct(S.substring(0, S.length() - 1), T);
    	}else{
    		return numDistinct(S.substring(0, S.length() - 1), T.substring(0, T.length() - 1)) +  numDistinct(S.substring(0, S.length() - 1), T);
    	}
    }
}
