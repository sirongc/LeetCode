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
		if (j == T.length() && i == S.length()) return 1; //����������ߵ����ˣ�˵��S������ǰ�ô�ƥ������һ��T������1.
		if (j == T.length()) return 1; //���j�ߵ����ˣ��൱��֮ǰjһֱƥ�䵽����ˣ�˵��һ��j��ƥ����ɣ���˷���1.
		if (i == S.length()) return 0; //���i�ߵ����ˣ�˵��S�����ߵ����ˣ����ʱ��û���أ�˵��1����ûƥ����ɣ�����֮ǰ��return 1�ˣ��������ﷵ��ֵ��0.
		
	    if (map[i][j] != 0) return map[i][j];

	    map[i][j] = numDistinct(S, T, i + 1, j, map);
	    if (S.charAt(i) == T.charAt(j))
	    	map[i][j] += numDistinct(S, T, i + 1, j + 1, map);
	    
	    return map[i][j];    
	}
	
	public static int num(String S, String T) {
		if (S.length() == 0) return 0; //ΪʲôҪ�������أ���Ϊ������Ҫ�õ�map[0].length����ά�������Ŀһ�������������һ��Ҫ���߽��Ŷ��
		
		int[][] map = new int[S.length()+1][T.length()+1];
		//����Ҫ�ɵ��Ǵ�ݹ��е�3��base condition��Ҳ����j == T.length()��i == S.length()���Լ�j == T.length()&&i == S.length()��3�����
		map[S.length()][T.length()] = 1;
		
		for (int j = 0; j < map[0].length-1; j++)
			map[S.length()][j] = 0;
		
		for (int i = 0; i < map.length-1; i++)
			map[i][T.length()] = 1;
	
		//��ʼDP���ж���ά�ͼ���ѭ����������map�������м��Ǵ�base condition��ʼ��ѭ���������������ű�
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
