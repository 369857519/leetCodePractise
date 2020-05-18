package algorithm.categories.dp.DistinctWays;

public class NumberOfDiceRollsWithTargetSum1155 {

    public static void main(String[] args) {
        NumberOfDiceRollsWithTargetSum1155 numberOfDiceRollsWithTargetSum1155 = new NumberOfDiceRollsWithTargetSum1155();
        int res = numberOfDiceRollsWithTargetSum1155.numRollsToTarget(2, 5, 10);
        res = numberOfDiceRollsWithTargetSum1155.numRollsToTarget(2, 6, 7);
        res = numberOfDiceRollsWithTargetSum1155.numRollsToTarget(1, 2, 3);
        res = numberOfDiceRollsWithTargetSum1155.numRollsToTarget(30, 30, 500);
    }

    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        //第几个色子
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k])%1000000007;
                    } else {
                        break;
                    }
                }
            }
//            ArrayPrintUtil.printArr(dp);
        }

        return dp[d][target];
    }

}
