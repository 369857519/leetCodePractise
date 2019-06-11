package ppp;

import java.util.ArrayList;
import java.util.List;

public class PartitionEqualSubsetSum416 {

	//  https://juejin.im/post/5b40c99ee51d45190b615f33
	//	Input: [1, 5, 11, 5]
	//
	//	Output: true
	//
	//	Explanation: The array can be partitioned as [1, 5, 5] and [11].
	int[][] list;

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;
		list = new int[nums.length][nums.length / 2 + 1];
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[0].length; j++) {
				list[i][j] = -1;
			}
		}
		return tryPartition(nums, nums.length - 1, target);
	}

	boolean tryPartition(int[] nums, int index, int sum) {
		if (sum == 0) {
			return true;
		}

		if (sum < 0 || index < 0) {
			return false;
		}

		if (list[index][sum] != -1) {
			return list[index][sum] == 1;
		}

		list[index][sum] =
			(tryPartition(nums, index - 1, sum) || tryPartition(nums, index - 1, sum - nums[index]))
				? 1 : 0;
		return list[index][sum] == 1;
	}
}
