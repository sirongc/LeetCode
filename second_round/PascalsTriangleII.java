package second_round;

import java.util.ArrayList;

public class PascalsTriangleII {
	public static void main(String[] args) {
		ArrayList<Integer> res = getRow(2);
			for (int i: res) {
				System.out.print(i + " ");
			}
		
	}
	public static ArrayList<Integer> getRow(int rowIndex) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if (rowIndex < 0) return res;
	    if (rowIndex == 0) {
	        res.add(1);
	        return res;
	    }
	    for (int i = 0; i < rowIndex; i++) {
	        ArrayList<Integer> nextline = new ArrayList<Integer>();
	        nextline.add(1);
	        for (int j = 0; j < res.size() - 1; j++) {
	            nextline.add(res.get(j) + res.get(j+1));
	        }
	        nextline.add(1);
	        res = nextline;
	    }
	    return res;   
	}
}
