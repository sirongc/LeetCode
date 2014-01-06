package second_round;

public class ZigZagConversion {
	public static void main(String[] args){
		System.out.println(convert(null, 21));
	}
	
	public static String convert(String s, int nRows) {
		if (nRows <= 0 || s == null) return "";
		if (nRows == 1) return s;
	    int step = (nRows-1) * 2;
	    StringBuilder start = getStartEndConvertion(s, step, 0);
	    StringBuilder end = getStartEndConvertion(s, step, nRows-1);
	    StringBuilder result = new StringBuilder();
	    result.append(start);

	    for (int i = 1; i < nRows-1; i++) {
	        result.append(getConvertion(s, i, step));
	    }
	    result.append(end);
	    return result.toString();
	}

	private static StringBuilder getConvertion(String s, int p, int bigstep) {
	    StringBuilder result = new StringBuilder("");
	    int step = bigstep - 2*p;
	    while (p < s.length()) {
	        result.append(s.charAt(p));
	        p += step;
	        step = bigstep- step;
	    }
	    return result;
	}

	private static StringBuilder getStartEndConvertion(String s, int step, int start) {
	    StringBuilder result = new StringBuilder("");
	    while (start < s.length()) {
	        result.append(s.charAt(start));
	        start += step;
	    }
	    return result;
	}


}
