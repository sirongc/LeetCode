package second_round;

public class DistinctSubsequences {
	public static void main(String[] args) {
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(num(S, T));
	}
	public static int numDistinct(String S, String T) {
		int[][] map = new int[S.length()][T.length()];
		return numDistinct(S, T, 0, 0, map);
	}
	public static int numDistinct(String S, String T, int i, int j, int[][] map) {
		if (j == T.length() && i == S.length()) return 1; //如果两个都走到底了，说明S在寿终前好歹匹配完了一条T，返回1.
		if (j == T.length()) return 1; //如果j走到底了，相当于之前j一直匹配到最后了，说明一条j已匹配完成，因此返回1.
		if (i == S.length()) return 0; //如果i走到底了，说明S本身都走到底了，这个时候还没返回，说明1条都没匹配完成，否则之前就return 1了，所以这里返回值是0.
		
	    if (map[i][j] != 0) return map[i][j];

	    map[i][j] = numDistinct(S, T, i + 1, j, map);
	    if (S.charAt(i) == T.charAt(j))
	    	map[i][j] += numDistinct(S, T, i + 1, j + 1, map);
	    
	    return map[i][j];    
	}
	
	public static int num(String S, String T) {
		if (S.length() == 0) return 0; //为什么要有这条呢？因为下面我要用到map[0].length，二维数组的题目一旦有这种情况，一定要检查边界的哦。
		
		int[][] map = new int[S.length()+1][T.length()+1];
		//首先要干的是存递归中的3个base condition，也就是j == T.length()和i == S.length()，以及j == T.length()&&i == S.length()这3种情况
		map[S.length()][T.length()] = 1;
		
		for (int j = 0; j < map[0].length-1; j++)
			map[S.length()][j] = 0;
		
		for (int i = 0; i < map.length-1; i++)
			map[i][T.length()] = 1;
	
		//开始DP，有多少维就几重循环，把整张map填满，切记是从base condition开始的循环，才能填满整张表。
		for (int i = S.length() - 1; i >= 0; i--) {
			for (int j = T.length() -1; j >= 0; j--) {
				map[i][j] = map[i+1][j];
				if (S.charAt(i) == T.charAt(j))
					map[i][j] += map[i+1][j+1];
			}
		}
		return map[0][0];
	}
	
	
	public static int numDistinct2(String S, String T, int i, int j) {
	    if (i >= S.length()) return 0;
	    if (j >= T.length()) return 1;
	    if (S.substring(i).equals(T.substring(j))) return 1;

	    if (S.charAt(i) == T.charAt(j))
	        return numDistinct2(S, T, i + 1, j) + numDistinct2(S, T, i + 1, j + 1);
	    else
	        return numDistinct2(S, T, i + 1, j);
	}
	
}
