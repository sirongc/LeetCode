package first_round;

public class FirstMissingPositive {
	public static void main(String[] args){
		int[] A = {1,1};
		System.out.println(firstMissingPositive(A));
	}
	//1,3,2,4
	//1,2,3,4
    public static int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length; i++){
        	while(A[i] >= 1 && A[i] <= A.length && A[i] != i + 1 && A[A[i] -1] != A[i]){
        		int temp = A[A[i]-1];
        		A[A[i] - 1] = A[i];
        		A[i] = temp;
        	}
        }
       
        for (int i = 0; i < A.length; i++){
        	if(A[i] != i + 1) return i+1;
        }
    	return A.length + 1;
    }

}
