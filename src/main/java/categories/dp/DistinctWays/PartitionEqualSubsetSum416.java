package categories.dp.DistinctWays;

import Utils.ArrayPrintUtil;

public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        PartitionEqualSubsetSum416 partitionEqualSubsetSum416 = new PartitionEqualSubsetSum416();
        partitionEqualSubsetSum416.canPartition(new int[]{1, 5, 11, 5});
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2 + 1;
        boolean[][] dp = new boolean[nums.length + 1][target];
        dp[0][0] = true;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            ArrayPrintUtil.printArr(dp);
        }
        return dp[nums.length][target - 1];
    }
}
