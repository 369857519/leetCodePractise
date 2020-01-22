package categories.dp.DistinctWays;

import Utils.ArrayPrintUtil;

public class CombinationSum377 {

    public static void main(String[] args) {
        CombinationSum377 combinationSum377 = new CombinationSum377();
        int res = combinationSum377.combinationSum4(new int[]{1, 2, 3}, 4);
    }

    public int combinationSum4DP(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
            ArrayPrintUtil.printArr(dp);
        }
        return dp[target];
    }

    public int combinationSum4(int[] nums, int target) {
        record = new Integer[target + 1];
        return search(nums, target);
    }

    private Integer[] record;

    public int search(int[] nums, int target) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (record[target] != null) {
            return record[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += search(nums, target - nums[i]);
        }
        record[target] = res;
        return res;
    }
}
