package second_round;

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
	    int max = 0;
	    for (int i = 0; i < prices.length; i++)
	        max = Math.max(maxProfit(prices, 0, i) + maxProfit(prices, i+1, prices.length-1), max);
	    return max;
	}

	private int maxProfit(int[] prices, int lo, int hi) {
	    if (lo >= hi) return 0;
	    int minPrice = prices[lo];
	    int max = 0;
	    for (int i = lo; i <= hi; i++) {
	        if (prices[i] < minPrice) minPrice = prices[i];
	        else max = Math.max(max, prices[i] - minPrice);
	    }
	    return max;
	}
}
