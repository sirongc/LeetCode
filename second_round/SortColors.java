package second_round;

public class SortColors {
	public static void main(String[] args) {
		int[] A = {1,1,1,1,2,2,2,0,0,0,0,0,2,2,2,2,1,1};
		sortColors(A);
		for (int i: A) System.out.print(i + " ");
	}
	public static void sortColors(int[] A) { 
	    int n0 = 0;
	    int n1 = 0;
	    int n2 = 0;
	    for (int i = 0; i < A.length; i++) {
	       if (A[i] == 0) n0++;
	       if (A[i] == 1) n1++;
	       if (A[i] == 2) n2++;
	    }
	    for (int i = 0; i < n0; i++)
	        A[i] = 0; 
	    for (int i = 0; i < n1; i++)
	        A[n0+i] = 1;
	    for (int i = 0; i < n2; i++)
	        A[n0+n1+i] = 2;  
	}
}
