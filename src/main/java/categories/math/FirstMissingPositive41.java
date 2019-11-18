package categories.math;

public class FirstMissingPositive41 {

	public static void main(String[] args) {
		FirstMissingPositive41 firstMissingPositive41 = new FirstMissingPositive41();
		int res = firstMissingPositive41.firstMissingPositive(new int[]{1, 2, 0});
		res = firstMissingPositive41.firstMissingPositive(new int[]{3, 4, -1, 1});
	}

	public int firstMissingPositive(int[] nums) {
		int n = nums.length;

		//pre-process
		for (int i = 0; i < n; i++) {
			if (nums[i] > n || nums[i] < 0) {
				nums[i] = 0;
			}
		}

		//mark index
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0 && nums[i] != n + 1) {
				int index = (nums[i] <= n) ? nums[i] - 1 : nums[i] - n - 2;
				if (nums[index] <= n) {
					nums[index] += n + 1;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] <=n && nums[i] >= 0) {
				res = i + 1;
				break;
			}
		}
		if (res == 0) {
			return n + 1;
		} else {
			return res;
		}
	}

}
