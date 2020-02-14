package categories.array;

public class MaximumProductSubarray152 {

	public static void main(String[] args) {
		MaximumProductSubarray152 maximumProductSubarray152 = new MaximumProductSubarray152();
		maximumProductSubarray152.maxProduct(new int[]{2, 3, -2, 4});
		maximumProductSubarray152.maxProduct(new int[]{-2, 0, -1});
		maximumProductSubarray152.maxProduct(new int[]{});
		maximumProductSubarray152.maxProduct(new int[]{1, 2, 3, 4, -5, 6, 7, 8});
		maximumProductSubarray152.maxProduct(new int[]{-2, 3, -4});
	}

	public int maxProduct(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		//以n为结尾的最大值
		int[] maxProduct = new int[nums.length];
		int[] minProduct = new int[nums.length];
		int res = nums[0];
		maxProduct[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			minProduct[i] = Math
				.min(nums[i], Math.min(nums[i] * minProduct[i - 1], nums[i] * maxProduct[i - 1]));
			maxProduct[i] = Math
				.max(nums[i], Math.max(nums[i] * maxProduct[i - 1], nums[i] * minProduct[i - 1]));
			res = Math.max(res, maxProduct[i]);
		}
		return res;
	}
}
