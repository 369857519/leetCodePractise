package algorithm.categories.twoPointers;

public class MinimumSizeSubarray209 {

	public static void main(String[] args) {
		MinimumSizeSubarray209 minimumSizeSubarray209 = new MinimumSizeSubarray209();
		int res = minimumSizeSubarray209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
	}


	public int minSubArrayLen(int s, int[] nums) {
		int left = 0;
		int sum = 0;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				//如果大了左移一位
				res = Math.min(res, i - left + 1);
				sum -= nums[left++];
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
