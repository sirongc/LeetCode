package second_round;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] A = new int[10];
		for (int i = 0; i < 5; i++) A[i] = 2 * i;
		int[] B = {1,3,5,7};
		merge(A, 5, B, 4);
		for (int i: A) System.out.print(i + " ");
	}
	public static void merge(int A[], int m, int B[], int n) {
	    int k = m + n - 1;
	    int i = m - 1;
	    int j = n - 1;
	    while (i >= 0 && j >= 0) {
	        if (A[i] <= B[j]) 
	            A[k--] = B[j--];
	        else 
	            A[k--] = A[i--];
	    }
	    while (i >= 0)
	        A[k--] = A[i--];

	    while (j >= 0) 
	        A[k--] = B[j--];            
	}
}
