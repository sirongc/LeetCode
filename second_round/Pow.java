package second_round;

public class Pow {
    public static void main(String[] args) {
    	System.out.println(pow(2,-3));
    }
	public static double pow(double x, int n) {
	    if (n == 0) return 1;
	    if (n < 0) return 1 / powPositive(x, -1 * n);
	    return powPositive(x, n);
	}

	private static double powPositive(double x, int n) {      
	   if (n == 0) return 1;
	   double v = pow(x, n/2);
	   if (n % 2 == 0) return v * v;
	   else return v * v * x;  
	    
	}

}
