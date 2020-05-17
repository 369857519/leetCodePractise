package algorithm.categories.dp.DecisionMaking;

public class BestTimeToBuyAndSellStock121 {

    // [7,1,5,3,6,4]

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock121 bestTimeToBuyAndSellStock121 = new BestTimeToBuyAndSellStock121();
//        int res = bestTimeToBuyAndSellStock121.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        int res = bestTimeToBuyAndSellStock121.maxProfit(new int[]{5, 3, 1});
    }

    public int maxProfit(int[] prices) {
        if(prices.length==0||prices.length==1){
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return dp[prices.length - 1];
    }

}
