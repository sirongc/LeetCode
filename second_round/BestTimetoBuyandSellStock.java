package second_round;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
	    if (prices.length == 0) return 0;
	    int lo = prices[0];
	    int max = 0;    
	    for (int i = 0; i < prices.length; i++) {
	        if (prices[i] < lo) lo = prices[i];
	        else max = Math.max(max, prices[i] - lo);
	    }
	    return max;
	}
}
