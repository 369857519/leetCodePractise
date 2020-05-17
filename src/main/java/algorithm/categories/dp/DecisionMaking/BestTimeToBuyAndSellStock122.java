package algorithm.categories.dp.DecisionMaking;

public class BestTimeToBuyAndSellStock122 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock122 bestTimeToBuyAndSellStock122 = new BestTimeToBuyAndSellStock122();
        bestTimeToBuyAndSellStock122.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int sub = prices[i] - prices[i - 1];
            if (sub > 0) {
                res += sub;
            }
        }
        return res;
    }

}
