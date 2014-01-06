package first_round;

public class RemoveDuplicatesFromSortedArrayII {
	public static void main(String[] args){
		int[] A = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(A));
		for(int a: A){
			System.out.println(a);
		}
	}

    public static int removeDuplicates(int[] A) {
    	if(A.length == 0) return 0;
    	int temp = 0;
    	boolean appeared = false;

    	for(int i = 1; i < A.length; i++){
    		if(A[temp] == A[i] && !appeared){
    			appeared = true;
    			temp++;
    			A[temp] = A[i];
    		}
    		else if(A[temp] != A[i]){
    			appeared = false;
    			temp++;
    			A[temp] = A[i];
    		} 
    		
    	}
    	
    	return temp + 1;
    }
}
