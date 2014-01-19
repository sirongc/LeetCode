package second_round;


public class PalindromePartitioningII {
	public static void main(String[] args) {
		//fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"
		System.out.println(minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
	
	public static int minCut(String s) {
		int[] map = new int[s.length()+1];
		for (int i = 0; i < map.length; i++) 
			map[i] = -1;
		return minCut(s, 0, map);
	}

	public static int minCut(String s, int j, int[] map) {
		if (map[j] != -1) return map[j];
		if (j == s.length()-1) return 0;
		int mincut = Integer.MAX_VALUE;
		for (int i = j; i < s.length(); i++) {
			if (isPalindrome(s, j, i)) {
				int nextmincut = minCut(s, i+1, map);
				if (nextmincut != Integer.MAX_VALUE)
					mincut = Math.min(mincut, nextmincut + 1);
			}
		}
		map[j] = mincut;
		return mincut;
	}
	

	
	private static boolean isPalindrome(String s, int lo, int hi) {
		int[][] map = new int[s.length()+1][s.length()+1];
		return isPalindrome(s, lo, hi, map);
	}
	
	
	private static boolean isPalindrome(String fnode, int l, int h, int[][] map) {
		if (map[l][h] != 0) return map[l][h] == 1;
		int lo = l;
		int hi = h;
		while (lo <= hi) {
			if (fnode.charAt(lo) != fnode.charAt(hi)) {
				map[lo][hi] = -1;
				return false;
			}
				
			else {
				lo++;
				hi--;
			}
		}
		map[l][h] = 1;
		return true;
	}
	
	/**
	public static int minCut(String s) {
	    Queue<String> frontier = new LinkedList<String>();
	    int step = 0;
	    int count = 1;
	    frontier.add(s);
	    while (frontier.size() != 0) {
	    	while (count > 0) {
	    		String fnode = frontier.poll();
		    	for (int i = 0; i < fnode.length(); i++) {
	                if (isPalindrome(fnode, 0, i)) {
	                	if (i == fnode.length()-1) 
	                		return step;
	                	frontier.add(fnode.substring(i+1, fnode.length()));
	                }            
		        }
		    	count--;
	    	}
	        step++;
	        count = frontier.size();
	    }
	    return -1; 
	}


	**/
}
