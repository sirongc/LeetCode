package second_round;

import java.util.HashMap;

public class RomantoInteger {
	public static void main(String[] args) {
		System.out.println(romanToInt("MV"));
	}
	public static int romanToInt(String s) {
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    map.put("M", 1000);
	    map.put("CM", 900);
	    map.put("D", 500);
	    map.put("CD", 400);
	    map.put("C", 100);
	    map.put("XC", 90);
	    map.put("L", 50);
	    map.put("XL", 40);
	    map.put("X", 10);
	    map.put("IX", 9);
	    map.put("V", 5);
	    map.put("IV", 4);
	    map.put("I", 1);

	    int sum = 0;
	    if (s.length() == 1) return map.get(s);
	    for (int i = 0; i < s.length() - 1; i++) {
	        if (map.containsKey(s.substring(i, i+2))) {
	        	sum += map.get(s.substring(i, i+2));
	        	i++;
	        }    
	        else
	            sum += map.get(s.substring(i, i+1));
	    }
	    if (s.length() >= 2 && !map.containsKey(s.substring(s.length()-2, s.length())))
	        sum += map.get(s.substring(s.length()-1, s.length()));
	    return sum;
	}
}
