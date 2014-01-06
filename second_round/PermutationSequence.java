package second_round;

public class PermutationSequence {
	public static void main(String[] args) {
		System.out.println(getPermutation(9,331987));
	}
	public static String getPermutation(int n, int k) {		 
	    boolean[] isUsed = new boolean[n];
	    int[] sum = {0};
	    return generate(isUsed, "", n, k, sum);
	}

	private static String generate(boolean[] isUsed, String S, int n, int k, int[] sum) {
	    if (S.length() == n) {
	        sum[0] = sum[0] + 1;
	        if (sum[0] == k) return S;
	    }   
	    for (int i = 0; i < n; i++) {
	        if (isUsed[i]) continue;
	        isUsed[i] = true;
	        String res = generate(isUsed, S + (i+1), n, k, sum);
	        if (res != null) return res;
	        isUsed[i] = false;
	    }
	    return null;
	}
}
