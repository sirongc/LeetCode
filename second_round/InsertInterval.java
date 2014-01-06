package second_round;

import java.util.ArrayList;

public class InsertInterval {
	public static void main(String[] args) {
		Interval n1 = new Interval(1,2);
		Interval n2 = new Interval(3,5);
		Interval n3 = new Interval(6,7);
		Interval n4 = new Interval(8,10);
		Interval n5 = new Interval(12,16);
		ArrayList<Interval> n = new ArrayList<Interval>();
		n.add(n1);
		n.add(n2);
		n.add(n3);
		n.add(n4);
		n.add(n5);
		
		Interval newInterval = new Interval(4,9);
		ArrayList<Interval> res = insert(n, newInterval);
		
		for (Interval x : res) {
			System.out.print(x.start + " " + x.end);
			System.out.println();
		}
	}
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	    int j = intervals.size();
	    for (int i = 0; i < intervals.size(); i++) {
	        if (newInterval.start < intervals.get(i).start) {
	            j = i;
	            break;
	        }
	    }
	    int p = j;
	    if (j > 0 && intervals.get(j-1).end >= newInterval.start) {
	        intervals.get(j-1).end = Math.max(intervals.get(j-1).end, newInterval.end);
	        p = j-1;
	    } else{
	        intervals.add(j, newInterval);
	    }

	    while (p + 1 < intervals.size() && intervals.get(p).end >= intervals.get(p+1).end)
	        intervals.remove(p+1);

	    if (p + 1 < intervals.size() && intervals.get(p).end >= intervals.get(p+1).start) {
	        intervals.get(p).end = Math.max(intervals.get(p).end, intervals.get(p+1).end);
	        intervals.remove(p+1);
	    }
	    return intervals;
	}
	        
	    
}
