package Algorithm.categories.array;


public class NextPermutation31 {

	public static void main(String[] args) {

		NextPermutation31 nextPermutation31 = new NextPermutation31();
		nextPermutation31.nextPermutation(new int[]{1, 2, 3});
		nextPermutation31.nextPermutation(new int[]{1, 3, 2});
		nextPermutation31.nextPermutation(new int[]{3, 2, 1});
		nextPermutation31.nextPermutation(new int[]{1, 1, 5});
		nextPermutation31.nextPermutation(new int[]{2, 3, 1});
		nextPermutation31.nextPermutation(new int[]{1, 5, 1});
		nextPermutation31.nextPermutation(new int[]{4, 2, 4, 4, 3});
		nextPermutation31.nextPermutation(
			new int[]{4, 0, 5, 29, 14, 16, 9, 2, 12, 14, 7, 27, 15, 4, 8, 11, 2, 18, 29, 3, 16, 8,
				10, 22, 11, 10, 15, 1, 1, 0, 28, 5, 0, 26, 4, 6, 12, 5, 8, 16, 12, 8, 14, 27, 12,
				14, 0, 6, 2, 29, 9, 10, 8, 11, 3});

	}

	public void nextPermutation(int[] nums) {
		int len = nums.length;
		//从最后一位开始找，如果之前找到过比现在的为大的，则把之前找过的比现在大的里面最小的做替换
		int left = -1;
		int right = -1;
		for (int i = len - 1; i > 0; i--) {
			//靠最右，比左边大
			if ((i + 1 >= len && nums[i] > nums[i - 1]) ||
				//大于左边，大于等于右边
				(i + 1 < len && nums[i] >= nums[i + 1]
					&& nums[i] > nums[i - 1])) {
				left = i - 1;
				break;
			}
		}
		if (left != -1) {
			for (int i = left + 1; i <= len; i++) {
				if (i >= len || nums[i] <= nums[left]) {
					right = i - 1;
					break;
				}
			}
			swap(left, right, nums);
		}
		reverse(left + 1, nums.length, nums);
	}

	public void swap(int left, int right, int[] nums) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	public void reverse(int start, int end, int[] nums) {
		int len = end - start;
		for (int i = start; i < len / 2 + start; i++) {
			int temp = nums[i];
			nums[i] = nums[end - (i - start) - 1];
			nums[end - (i - start) - 1] = temp;
		}
	}
}
