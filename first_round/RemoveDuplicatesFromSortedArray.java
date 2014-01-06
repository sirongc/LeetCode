package first_round;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args){
		int[] A = {};
		int size = removeDuplicates(A);
		for(int i = 0; i < size; i++){
			System.out.println(A[i]);
		}
	}
	
    public static int removeDuplicates(int[] A) {
    	if(A.length == 0) return 0;
    	int temp = 0;
    	for(int i = 0; i < A.length; i++){
    		if(A[temp] == A[i]) continue;
    		temp++;
    		A[temp] = A[i];
    	}
    	
    	return temp + 1;
    }

}
