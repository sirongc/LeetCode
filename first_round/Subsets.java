package first_round;
import java.util.ArrayList;
import java.util.Arrays;


public class Subsets {
	public static void main(String[] args){
		int[] S = {1, 2, 3};
		ArrayList<ArrayList<Integer>> list = subsets(S);
		for(ArrayList<Integer> a: list){
			for(int b: a){
				System.out.print(b + " ");
			}
			System.out.println();
		}
		
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		return subsets1(S);
	}
	
    public static ArrayList<ArrayList<Integer>> subsets1(int[] S) {
    	
    	if(S.length == 1){
    		ArrayList<Integer> baseList1 = new ArrayList<Integer>();
    		ArrayList<Integer> baseList2 = new ArrayList<Integer>();
    		baseList1.add(S[0]);
    		ArrayList<ArrayList<Integer>> baseLists = new ArrayList<ArrayList<Integer>>();
    		baseLists.add(baseList1);
    		baseLists.add(baseList2);	
    		return baseLists;
    	}
    	ArrayList<ArrayList<Integer>> sets = subsets1(lessArray(S));
    	ArrayList<ArrayList<Integer>> tempSets = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0; i < sets.size(); i++){
    		ArrayList<Integer> tempSet = (ArrayList<Integer>) sets.get(i).clone();
    		tempSet.add(S[S.length - 1]);
    		tempSets.add(tempSet);
    	}
    	for(int i = 0; i < tempSets.size(); i++){
    		sets.add(tempSets.get(i));
    	}
        return sets;
    }

	private static int[] lessArray(int[] S) {
		int[] T = new int[S.length-1];
		for(int i = 0; i < T.length; i++){
			T[i] = S[i];
		}
		return T;
	}

}
