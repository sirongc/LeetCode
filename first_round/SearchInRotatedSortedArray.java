package first_round;

public class SearchInRotatedSortedArray {
	public static void main(String[] args){
		int[] A = {3,1};
		System.out.println(search(A, 1));
		
	}
	

	
    public static int search(int[] A, int target) {
    	int lo = 0;
    	int hi = A.length - 1;
    	while(lo <= hi){
    		int mid = (lo + hi) / 2;
    		if(A[mid] == target) 
    			return mid;
    		if(A[mid] > A[lo]){
    			if(target >= A[lo] && target < A[mid]){
    				hi = mid - 1;
    			}else{
    				lo = mid + 1;
    			}
    		}else {
    			if(target <= A[hi] && target > A[mid]){
    				lo = mid + 1;
    			}else{
    				hi = mid - 1;
    			}
    		}
    	}
    	return -1;
    }
    
 

}
