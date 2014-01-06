package first_round;

public class MergeSortedArray {
	public static void main(String[] args){
		
		int[] A = {};
		int[] B = {1};
		merge(A,0,B,1);
	}
	
    public static void merge(int A[], int m, int B[], int n) {
        if(B.length == 0){
        	B  = null;
        	return;
        }
    	if(A.length == 0){
    		A = B;
    		B = null;
    		return;
    	}
        int ap = m-1;
    	int bp = n-1;
    	for(int i = m + n - 1; i >=0; i--){
    		if(ap < 0 || bp < 0) break;
    		if(A[ap] > B[bp]){
    			A[i] = A[ap--];
    		}else{
    			A[i] = B[bp--];
    		}
    	}
    	
    	while (bp >= 0){
    		A[bp] = B[bp];
    		bp--;
    	}
    	B = null;
        
    }
}
