package categories.dp;

import Utils.ArrayUtil;

public class PartitionEqualSubsetSum416 {

	public static void main(String[] args) {
		PartitionEqualSubsetSum416 partitionEqualSubsetSum416 = new PartitionEqualSubsetSum416();
		partitionEqualSubsetSum416.canPartition(new int[]{1, 5, 11, 5});
	}

	//  https://juejin.im/post/5b40c99ee51d45190b615f33
	//	Input: [1, 5, 11, 5]
	//
	//	Output: true
	//
	//	Explanation: The array can be partitioned as [1, 5, 5] and [11].
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (nums.length > 1 && sum % 2 == 0) {
			return calculate(nums, sum / 2);
		}
		return false;
	}

	public boolean calculate(int[] nums, int target) {
		int[][] dpState = new int[nums.length][target + 1];
		dpState[0][0] = 1;
		dpState[0][nums[0]] = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j <= target; j++) {
				int lastState = 0;
				if (j - nums[i] >= 0) {
					lastState = dpState[i - 1][j - nums[i]];
				}
				dpState[i][j] = (lastState == 1 || dpState[i - 1][j] == 1) ? 1 : 0;
			}
			ArrayUtil.printArr(dpState);
		}
		return dpState[nums.length - 1][target] == 1;
	}
}
