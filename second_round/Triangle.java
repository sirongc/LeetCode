package second_round;

import java.util.ArrayList;

public class Triangle {
	public static void main(String[] args) {
		ArrayList<Integer> n1 = new ArrayList<Integer>();
		n1.add(2);
		ArrayList<Integer> n2 = new ArrayList<Integer>();
		n2.add(3);
		n2.add(4);
		ArrayList<Integer> n3 = new ArrayList<Integer>();
		n3.add(6);
		n3.add(5);
		n3.add(7);
		ArrayList<Integer> n4 = new ArrayList<Integer>();
		n4.add(4);
		n4.add(1);
		n4.add(8);
		n4.add(3);
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(n1);
		//triangle.add(n2);
		//triangle.add(n3);
		//triangle.add(n4);
		
		System.out.println(minimumTotal(triangle));
		
		
	}
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle.size() == 0) return 0;
	    int[] minSum = new int[1];
	    minSum[0] = Integer.MAX_VALUE;
	    generateMinSum(triangle, 0, 0, 0, minSum);	   
	    return minSum[0];
	}

	private static void generateMinSum(ArrayList<ArrayList<Integer>> triangle, int lastI, int level, int sum, int[] minSum) {
	    if (level == triangle.size()) {
	        minSum[0] = Math.min(minSum[0], sum);
	        return;
	    }
	    ArrayList<Integer> line = triangle.get(level);
	    if (lastI - 1 >= 0) generateMinSum(triangle, lastI-1, level+1,sum+line.get(lastI-1), minSum);
	    if (lastI + 1 < line.size()) generateMinSum(triangle, lastI+1, level+1, sum+line.get(lastI+1), minSum);
	    generateMinSum(triangle, lastI, level+1, sum+line.get(lastI), minSum);
	}
}
