package second_round;

public class SingleNumberII {
	public static void main(String[] args) {
		int[] A = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		System.out.println(singleNumber(A));
	}
	public static int singleNumber(int[] A) {
	    int[] bit = new int[32];
	    for (int i = 0; i < A.length; i++)
	        setBit(A[i], bit);
	    int res = 0;
	    for (int i = 0; i < 32; i++)
	        res += (bit[i] % 3) << i;
	    return res;     
	    
	}

	private static void setBit(int n, int[] bit) {
	    int i = 0;
	    while (n != 0 && i <= 31) {
	        bit[i++] += n & 1;
	        n >>= 1;
	    }
	}
}
