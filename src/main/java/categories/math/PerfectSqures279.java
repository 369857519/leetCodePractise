package categories.math;

public class PerfectSqures279 {

	public static void main(String[] args) {
		PerfectSqures279 perfectSqures279 = new PerfectSqures279();
		perfectSqures279.numSquares(13);
	}

	public int numSquares(int n) {
		int[] nums = new int[n + 1];
		nums[1] = 1;
		nums[0] = 0;
		for (int i = 2; i < nums.length; i++) {
			nums[i] = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				int currentProduct = j * j;
				if (i == currentProduct) {
					nums[i] = 1;
				}
				if (nums[i - currentProduct] > 0) {
					nums[i] = Math.min(nums[i], nums[i - currentProduct] + 1);
				}
			}
		}
		return nums[nums.length-1];
	}

}
