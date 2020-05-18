package algorithm.categories.dp.MinimumOrMaximumPath;

public class PerfectSqures279 {

    public static void main(String[] args) {
        PerfectSqures279 perfectSqures279 = new PerfectSqures279();
        perfectSqures279.numSquares(13);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int[] squareCache = new int[(int) Math.ceil(Math.sqrt(n))];
        for (int i = 0; i * i <= n; i++) {
            squareCache[i] = i * i;
        }
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 0; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; squareCache[j] < i; j++) {
                min = Math.min(dp[i - j * j] + 1, min);
            }
            dp[i] = min;
        }
        return dp[dp.length - 1];
    }

}
