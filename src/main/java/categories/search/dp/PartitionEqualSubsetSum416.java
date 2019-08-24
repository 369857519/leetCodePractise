package categories.search.dp;

import Utils.Printer;

public class PartitionEqualSubsetSum416 {

	public static void main(String[] args) {
		int[] num = new int[]{
			2, 2, 3, 5
		};
		PartitionEqualSubsetSum416 partitionEqualSubsetSum416 = new PartitionEqualSubsetSum416();
		boolean res = partitionEqualSubsetSum416.canPartition(num);
		res = partitionEqualSubsetSum416.canPartition(new int[]{3, 10});
		res = partitionEqualSubsetSum416.canPartition(new int[]{});
	}

	public boolean canPartition(int[] nums) {
		int total = 0;
		if (nums.length == 0) {
			return false;
		}
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}
		if (total % 2 != 0) {
			return false;
		}
		int target = total / 2;
		return dpWithTwoD(nums, target);
	}

	public boolean dpWithTwoD(int[] nums, int target) {
		int[][] table = new int[nums.length + 1][target + 1];
		table[0][target] = 1;
		//init
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 0; j <= target; j++) {
				int currentNum = nums[i - 1];
				if (table[i - 1][j] == 1 && (j - currentNum) >= 0) {
					if (j == currentNum) {
						return true;
					}
					table[i][j - currentNum] = 1;
					table[i][j] = 1;
				}
			}
			Printer.printArr(table);
		}
		return false;
	}

	public boolean traverse(int[] nums, int target, int index) {
		if (index > nums.length - 1) {
			return false;
		}
		if (target == nums[index]) {
			return true;
		}
		return traverse(nums, target, index + 1) || traverse(nums, target - nums[index], index + 1);
	}
}
