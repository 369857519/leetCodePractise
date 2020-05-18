package algorithm.categories.search.partition;

import java.util.Arrays;

public class Partition698 {

	public static void main(String[] args) {
		int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
		Partition698 partition698 = new Partition698();
		boolean res = partition698.canPartitionKSubsets(nums, 4);
	}

	public boolean search(int[] groups, int row, int[] nums, int target) {
		if (row < 0) {
			//这个条件有点儿不懂
			return true;
		}
		int v = nums[row--];
		for (int i = 0; i < groups.length; i++) {
			if (groups[i] + v <= target) {
				groups[i] += v;
				if (search(groups, row, nums, target)) {
					return true;
				}
				groups[i] -= v;
			}
			if (groups[i] == 0) {
				break;
			}
		}
		return false;
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = Arrays.stream(nums).sum();
		//不能整除，干掉
		if (sum % k > 0) {
			return false;
		}
		int target = sum / k;
		Arrays.sort(nums);
		//有一个数过大，干掉
		int row = nums.length - 1;
		if (nums[row] > target) {
			return false;
		}
		//记录末位有可能等于这个数字的情况
		while (row >= 0 && nums[row] == target) {
			row--;
			k--;
		}
		//开始遍历
		return search(new int[k], row, nums, target);
	}

}
