package second_round;

public class AddBinary {
	public static void main(String[] args) {
		System.out.println(addBinary("1","1"));
	}
	public static String addBinary(String a, String b) {
		 
	    if (a == null) return b;
	    if (b == null) return a;
	    int i = a.length() - 1;
	    int j = b.length() - 1;
	    int c = 0;
	    StringBuilder res = new StringBuilder();
	    while (i >= 0 && j >= 0) {
	        int ch1 = a.charAt(i--) - '0';
	        int ch2 = b.charAt(j--) - '0';
	       // res.append((c+ch1+ch2) % 2);
	        res.insert(0, (c+ch1+ch2) % 2);
	        if (c + ch1 + ch2 > 1) 
	            c = 1;
	        else 
	            c = 0;
	    }

	    while (i >= 0) {
	        int ch = a.charAt(i--) - '0';
	        //res.append((c + ch) % 2);
	        res.insert(0, (c + ch) % 2);
	        if (c + ch > 1)
	            c = 1;
	        else
	            c = 0;
	    }
	    while (j >= 0) {
	        int ch = b.charAt(j--) - '0';
	        //res.append((c + ch) % 2);
	        res.insert(0, (c + ch) % 2);
	        if (c + ch > 1)
	            c = 1;
	        else
	            c = 0;
	    }
	    if (c == 1) //res.append(1); 
	    	res.insert(0, 1);
	    return res.toString();
	}
}
