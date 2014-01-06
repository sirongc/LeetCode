package first_round;

public class RemoveElement {
	public static void main(String[] args){
		int[] A = {};
		System.out.println(removeElement(A, 0));
		for(int a: A){
			System.out.print(a + " ");
		}
	}
	
    public static int removeElement(int[] A, int elem) {
    	
    	int j = 0;
    	for(int i = 0; i < A.length; i++){
    		if(A[i] != elem){
    			A[j] = A[i];
    			j++;
    		}
    	}
    	return j;
    }

}
