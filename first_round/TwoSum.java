package first_round;
import java.util.*;


public class TwoSum {
	public static void main(String[] args){
		int[] x = {2, 7, 11, 15};
		int[] answer = twoSum(x, 9);
		for(int i: answer){
			System.out.println(i);
		}
		
	}
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < numbers.length; i++){
            if(!map.containsKey(numbers[i])){
            	map.put(target - numbers[i], i);
            }else{
            	int[] answer = new int[2];
            	answer[0] = map.get(numbers[i]) + 1;
            	answer[1] = i + 1;
            	return answer;
            }
        }
        return null;
    }
}
