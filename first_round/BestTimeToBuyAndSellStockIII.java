package first_round;

public class BestTimeToBuyAndSellStockIII {
	public static void main(String[] args){
		int[] prices = {1,2,4};
		System.out.println(maxProfit(prices));
	}
	
    public static int maxProfit(int[] prices) {
    	int profit = 0;
    	if(prices.length == 0 || prices.length == 1) return 0;
    	if(prices.length == 2) return (prices[1] - prices[0] > 0 ? prices[1] - prices[0]: 0);
    	
    	for(int i = 0; i < prices.length - 2; i++){
    		if(prices[i + 1] - prices[i] > 0){
    			profit = Math.max(profit, maxProfitOneTime(prices, 0, i+1) + maxProfitOneTime(prices, i+2, prices.length-1));
    		}
    	}
    	return Math.max(profit, maxProfitOneTime(prices, 0, prices.length-1));
    }
    
    public static int maxProfitOneTime(int[] prices, int i, int j) {
    	if(i == j) return 0;
    	int lo = prices[i];
    	int hi = Integer.MIN_VALUE;
    	int maxProfit = 0;
    	for (int x = i; x < j + 1; x++){
    		if(prices[x] > hi){
    			hi = prices[x];
    			maxProfit = Math.max(maxProfit, hi - lo);
    		}
    		if(prices[x] < lo){
    			lo = prices[x];
    			hi = Integer.MIN_VALUE;
    		}
    	}
    	return maxProfit;
    }

}
