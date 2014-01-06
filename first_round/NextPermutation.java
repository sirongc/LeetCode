package first_round;

public class NextPermutation {
	public static void main(String[] args){
		int[] num = {1,3,2};
		nextPermutation(num);
		for(int i: num){
			System.out.println(i);
		}
		
	}
	
    public static void nextPermutation(int[] num) {
    	int firstRise = getFirstRise(num);
    	if(firstRise == -1){
    		reverse(num, 0, num.length-1);
    		return;
    	}
    	
    	int change = -1;
    	for(int i = num.length-1; i > firstRise; i--){
    		if(num[i] > num[firstRise]){
    			int temp = num[i];
    			num[i] = num[firstRise];
    			num[firstRise] = temp;
    			change = i;
    			break;
    		}
    	}
    	if(change != -1){
    		reverse(num, firstRise+1, num.length-1);
    	}
    }
    
    private static void reverse(int[] num, int a, int b) {
		while(a < b){
			int temp = num[a];
			num[a] = num[b];
			num[b] = temp;
			a++;
			b--;
		}
	}


	private static int getFirstRise(int[] num) {
		for(int i = num.length-1; i > 0; i--){
			if(num[i] - num[i-1] > 0) return (i-1);
		}
		return -1;
	}

}
