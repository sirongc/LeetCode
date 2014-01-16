package second_round;

import java.util.HashMap;

public class MaxPointsOnALine {
	public static void main(String[] args) {
		Point[] points = new Point[4];
		points[0] = new Point(1,1);
		points[1] = new Point(2,2);
		points[2] = new Point(3,3);
		points[3] = new Point(5,7);
	
		System.out.println(maxPoints(points));
	}
	public static int maxPoints(Point[] points) {
		if (points.length == 0) return 0;
		if (points.length == 1) return 1;
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    int max = 0;
	    for (int i = 0; i < points.length; i++) {
	        map.clear();
	        int same = 0;
	        for (int j = 0; j < points.length; j++) {
	            if (i == j) continue;
	            if ((points[i].x == points[j].x) && (points[i].y == points[j].y)) same++;
	            else if (points[i].x == points[j].x) {
	                if (!map.containsKey("INFINITY")) map.put("INFINITY", 1);
	                else map.put("INFINITY", map.get("INFINITY") + 1);
	            } else {
	            	String k = ((double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x)) + ""; 
		            if (!map.containsKey(k)) 
		                map.put(k, 1);
		            else 
		                map.put(k, map.get(k) + 1);
	            }          
	        }
	        int submax = 0;
	        for (String k: map.keySet())
	            submax = Math.max((map.get(k)), submax);
	        max = Math.max(submax + same + 1, max);
	    }
	    return max;
	}

}
