package first_round;

public class BestTimeToBuyAndSellStockII {
	public static void main(String[] args){
		
	}
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0;
        for(int i = 0; i < prices.length - 1; i++){
        	if(prices[i + 1] - prices[i] > 0) profit += prices[i + 1] - prices[i];
        }
    	return profit;
    }

}
