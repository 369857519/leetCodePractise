package algorithm.categories.dp.MinimumOrMaximumPath;

public class MiniCostForTickets983 {

    public static void main(String[] args) {
        MiniCostForTickets983 miniCostForTickets983 = new MiniCostForTickets983();
        miniCostForTickets983.minSteps(10);
    }

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i]=Integer.MAX_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[j] + i / j, dp[i]);
                }
            }
        }
        return dp[n];
    }
}
