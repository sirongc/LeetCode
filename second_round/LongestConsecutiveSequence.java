package second_round;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] num = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(num));
	}
	public static int longestConsecutive(int[] num) {
		HashSet<Integer> set = new HashSet<Integer>();		
		for (int n: num)
			set.add(n);
		
		int max = 0;
		while (!set.isEmpty()) {
			for (int i: set) {
				int count = 1;
				set.remove(i);
				int left = i - 1;
				int right = i + 1;
				while (set.contains(left)) {
					set.remove(left--);
					count++;
				}
				while (set.contains(right)) {
					set.remove(right++);
					count++;
				}
				max = Math.max(max, count);
				break;
			}

		}
		return max;
	}

}
