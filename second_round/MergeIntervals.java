package second_round;

import java.util.ArrayList;

public class MergeIntervals {
	
	public static void main(String[] args) {
		Interval n1 = new Interval(1,3);
		Interval n2 = new Interval(2,6);
		Interval n3 = new Interval(8,10);
		Interval n4 = new Interval(15,18);
		ArrayList<Interval> n = new ArrayList<Interval>();
		n.add(n1);
		n.add(n2);
		n.add(n3);
		n.add(n4);
		
		ArrayList<Interval> res = merge(n);
		
		for (Interval x : res) {
			System.out.print(x.start + " " + x.end);
			System.out.println();
		}
	}
	
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        for (Interval newInterval: intervals){
        	insert(res, newInterval);
        }
        return res;
    }
	
	public static void insert(ArrayList<Interval> intervals, Interval newInterval) {
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
	}
}
