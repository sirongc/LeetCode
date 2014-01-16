package second_round;

import java.util.ArrayList;

public class PascalsTriangle {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = generate(5);
		for (ArrayList<Integer> list: res) {
			for (int i: list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {		 
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
	    if (numRows <= 0) return res;
	    if (numRows == 1) {
	        ArrayList<ArrayList<Integer>> firstList = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> fsl = new ArrayList<Integer>();
	        fsl.add(1);
	        firstList.add(fsl);
	        return firstList;
	    }
	    ArrayList<ArrayList<Integer>> temp = generate(numRows-1);
	    ArrayList<Integer> lastline = temp.get(temp.size()-1);
	    ArrayList<Integer> newlastline = new ArrayList<Integer>();
	    newlastline.add(1);
	    for (int i = 0; i < lastline.size()-1; i++)
	        newlastline.add(lastline.get(i) + lastline.get(i+1));
	    newlastline.add(1);
	    temp.add(newlastline);
	    
	    return temp;
	}
}
