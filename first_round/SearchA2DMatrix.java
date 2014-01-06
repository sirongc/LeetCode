package first_round;

public class SearchA2DMatrix {
	public static void main(String[] args){
		int[][] s = { {1},
				  {3}};
		int[] k = {1,3};
		System.out.println(getLine(k, 3));
		//
	}

    public static boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length == 0 || matrix == null) return false;
    	int[] firstCol = new int[matrix.length];
    	for(int i = 0; i < firstCol.length; i++){
    		firstCol[i] = matrix[i][0];
    	}
    	int line = getLine(firstCol, target);
    	if(line == -1) return false;
    	return binarySearch(matrix[line], target);
    }
    
    

	private static boolean binarySearch(int[] s, int target) {
		int lo = 0;
		int hi = s.length-1;
		while(lo <= hi){
			int mid = (lo+hi)/2;
			if(s[mid] == target) return true;
			if(s[mid] < target){
				lo = mid+1;
			}else{
				hi = mid-1;
			}
		}
		return false;
	}

	private static int getLine(int[] s, int target) {
		int lo = 0;
		int hi = s.length-1;
		int mid = (lo+hi)/2;
		int count = 0;
		if(target < s[0]) return -1;
		while(lo < hi){
			mid = (lo+hi)/2;
			if(count >= 3) break;
			if(s[mid] == target) return mid;
			if(s[mid] < target){
				if(lo == mid) count++;
				lo = mid;
			}else{
				if(hi == mid) count++;
				hi = mid;
			}
		}
		if(target >= s[s.length-1]) return s.length-1;
		return mid;
	}
}
