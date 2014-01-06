package second_round;

public class InterleavingString {
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(isInterleave(s1, s2, s3));
	}
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length()) return false;
		int[][][] map = new int[s1.length()+1][s2.length()+1][s3.length()+1];
		return isInterleave(s1, s2, s3, 0, 0, 0, map);
	}
	public static boolean isInterleave(String s1, String s2, String s3, int i, int j, int k, int[][][] map) {
		if (map[i][j][k] == 1) return true;
		if (map[i][j][k] == -1) return false;
		
		if (i == s1.length() && j == s2.length() && k == s3.length()) return true;
		if (i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
    		if (s1.charAt(i) != s3.charAt(k)) {
    			map[i][j][k] = -1;
    			return false;
    		}	
    		else {
    			map[i+1][j][k+1] = isInterleave(s1, s2, s3, i+1, j, k+1, map) ? 1 : -1;
    			map[i][j+1][k+1] = isInterleave(s1, s2, s3, i, j+1, k+1, map)? 1 : -1;
    			return  map[i+1][j][k+1] == 1 || map[i][j+1][k+1] == 1;
    		}
    	} 
		else {
    		if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
    			map[i+1][j][k+1] = isInterleave(s1, s2, s3, i+1, j, k+1, map) ? 1 : -1;
    			return map[i+1][j][k+1] == 1;
    		}
    		else if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
    			map[i][j+1][k+1] = isInterleave(s1, s2, s3, i, j+1, k+1, map)? 1 : -1;
    			return map[i][j+1][k+1] == 1;
    		}
    		else {
    			map[i][j][k] = -1;
    			return false;
    		}
    	}
	}
}
