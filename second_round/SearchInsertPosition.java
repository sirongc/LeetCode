package second_round;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
		int lo = 0;
		int hi = A.length-1;
		
		while(lo <= hi){
			int mid = (lo+hi)/2;
			if(A[mid] == target) return mid;
			if(A[mid] > target){
				hi = mid-1;
			}else{
				lo = mid+1;
			}
		}
		return lo;
    }
}
