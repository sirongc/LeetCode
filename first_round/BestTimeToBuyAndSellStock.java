package first_round;

public class BestTimeToBuyAndSellStock {
	
	public static void main(String[] args){
		int[] prices = {2,0,1};
		System.out.println(maxProfit(prices));
		
	}
	
    public static int maxProfit(int[] prices) {
    	if(prices.length == 0) return 0;
    	int lo = prices[0];
    	int hi = Integer.MIN_VALUE;
    	int maxProfit = 0;
    	for (int i = 1; i < prices.length; i++){
    		if(prices[i] > hi){
    			hi = prices[i];
    			maxProfit = Math.max(maxProfit, hi - lo);
    		}
    		if(prices[i] < lo){
    			lo = prices[i];
    			hi = Integer.MIN_VALUE;
    		}
    	}
    	return maxProfit;
    	//return (maxProfit >= 0 ? maxProfit : 0);
    }

}
