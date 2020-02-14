package categories.array;

import java.util.Arrays;

public class WiggleSort324 {

	public static void main(String[] args) {
		WiggleSort324 wiggleSort324 = new WiggleSort324();
		wiggleSort324.wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
		wiggleSort324.wiggleSort(new int[]{1, 3});
		wiggleSort324.wiggleSort(new int[]{3, 1});
		wiggleSort324.wiggleSort(new int[]{4, 5, 5, 6});
	}

	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int[] res = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			if (i % 2 == 0) {
				swap(nums, i, i + 1);
			}
		}
		for (int i = 1; i < nums.length; i++) {
			if (i % 2 == 0) {
			}
		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
