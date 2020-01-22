package categories.dp.DistinctWays;

public class TargetSum494 {

    public static void main(String[] args) {
        TargetSum494 targetSum494 = new TargetSum494();
        int res = targetSum494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        res = targetSum494.findTargetSumWays(new int[]{1, 1}, 2);
        res = targetSum494.findTargetSumWays(new int[]{1}, 2);
        res = targetSum494.findTargetSumWays(new int[]{1, 2, 7, 9, 981}, 1000000000);
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 1) {
            return nums[0] == S || nums[0] == -S ? 1 : 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum) {
            return 0;
        }
        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        dp[0][sum] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = -sum; j <= sum; j++) {
                int index = j + sum;
                if (index + nums[i - 1] <= sum * 2) {
                    dp[i][index] += dp[i - 1][index + nums[i - 1]];
                }
                if (index - nums[i - 1] >= 0) {
                    dp[i][index] += dp[i - 1][index - nums[i - 1]];
                }
            }
//            ArrayPrintUtil.printArr(dp);
        }

        return dp[nums.length][sum + S];
    }

}
