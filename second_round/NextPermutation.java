package second_round;

public class NextPermutation {
	public static void main(String[] args) {
		int[] num = {1,1,5};
		nextPermutation(num);
		for (int n: num) System.out.println(n);
	}
	public static void nextPermutation(int[] num) {
	    if (num == null) return;
	    int k = -1;
	    for (int i = num.length-1; i > 0; i--) {
	        if (num[i] > num[i-1]) {
	            k = i;
	            break;
	        }
	    }
	    if (k == -1) {
	        reverse(num, 0, num.length-1);
	        return;
	    }
	    change(num, k);
	    reverse(num, k, num.length-1);
	}

	private static void reverse(int[] num, int lo, int hi) {
	    while (lo < hi) {
	        int temp = num[lo];
	        num[lo] = num[hi];
	        num[hi] = temp;
	        lo++;
	        hi--;
	    }
	}

	private static void change(int[] num, int k) {
	    int pivot = k-1;
	    for (int i = num.length-1; i >=k; i--) {
	        if (num[i] > num[pivot]) {
	            int temp = num[pivot];
	            num[pivot] = num[i];
	            num[i] = temp;
	            return;
	        }
	    }
	}

}
