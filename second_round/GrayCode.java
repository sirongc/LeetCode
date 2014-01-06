package second_round;

import java.util.ArrayList;

public class GrayCode {
	public static void main(String[] args) {
		ArrayList<Integer> res = grayCode(0);
		for (int i: res) System.out.print(i + " ");
	}
	public static ArrayList<Integer> grayCode(int n) {
		if (n < 0) return null;
	    if (n == 0) {
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        res.add(0);
	        return res;
	    }
	    ArrayList<Integer> res = grayCode(n-1);
	    for (int i = res.size() - 1; i >= 0; i--) {
	        res.add(res.get(i) + (1 << (n-1)));
	    }
	    return res;
	}   
}
