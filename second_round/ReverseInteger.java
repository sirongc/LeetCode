package second_round;

public class ReverseInteger {
	public static void main(String[] args){
		System.out.println(reverse(-103));
	}
	public static int reverse(int x) {
	    if (x > 0)
	        return reversePositiveInt(x);
	    else
	        return -1 * reversePositiveInt(-x);
	}

	private static int reversePositiveInt(int x) {
	    int result = 0;
	    while (x > 0) {
	        int last = x % 10;
	        result = 10 * result + last;
	        x /= 10;
	    }
	    return result;
	}
	        

}
