package algorithm.categories.dp;

public class MaximumSubarray53 {

	public static void main(String[] args) {
		MaximumSubarray53 maximumSubarray53 = new MaximumSubarray53();
		int res = maximumSubarray53.maxSubArray(new int[]{-1});
	}

	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res = Math.max(res + nums[i], nums[i]);
			max = Math.max(res, max);
		}
		return max;
	}
}
