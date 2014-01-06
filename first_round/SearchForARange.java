package first_round;

public class SearchForARange {
	public static void main(String[] args){
		int[] A = {2,2};
		int[] a = searchRange(A, 3);
		for(int b: a){
			System.out.println(b);
		}
	}
    public static int[] searchRange(int[] A, int target) {
    	int left = searchLeftTarget(A, target);
    	int right = searchRightTarget(A, target);
    	int[] answer = new int[2];
    	answer[0] = left;
    	answer[1] = right;
    	return answer;
    }
    
	private static int searchRightTarget(int[] a, int target) {
		int lo = 0;
		int hi = a.length-1;
		
		while(lo <= hi){
			int mid = (lo+hi)/2;
			if(a[mid] < target){
				lo = mid+1;
			}
			if(a[mid] > target){
				hi = mid-1;
			}
			if(a[mid] == target){
				if(mid == a.length-1 || a[mid+1] != a[mid]) {
					return mid;
				}
				lo = mid+1;
			}
		}
		return -1;
	}
	
	private static int searchLeftTarget(int[] a, int target) {
		int lo = 0;
		int hi = a.length-1;
		
		while(lo <= hi){
			int mid = (lo+hi)/2;
			if(a[mid] < target){
				lo = mid+1;
			}
			if(a[mid] > target){
				hi = mid-1;
			}
			if(a[mid] == target){
				if(mid == 0 || a[mid-1] != a[mid]) {
					return mid;
				}
				hi = mid-1;
			}
		}
		return -1;
	}
    
    
}
