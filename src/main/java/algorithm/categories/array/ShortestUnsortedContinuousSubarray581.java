package algorithm.categories.array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray581 {

	public static void main(String[] args) {
		ShortestUnsortedContinuousSubarray581 shortestUnsortedContinuousSubarray581 = new ShortestUnsortedContinuousSubarray581();
		int test = shortestUnsortedContinuousSubarray581
			.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
		test = shortestUnsortedContinuousSubarray581.findUnsortedSubarray(new int[]{1, 2, 3, 4});
		test = shortestUnsortedContinuousSubarray581.findUnsortedSubarray(new int[]{1, 4});
		test = shortestUnsortedContinuousSubarray581.findUnsortedSubarray(new int[]{4, 1});
		test = shortestUnsortedContinuousSubarray581.findUnsortedSubarray(new int[]{1, 3, 2, 2, 2});

	}

	public int findUnsortedSubarray(int[] nums) {
		int[] sortedNums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sortedNums);
		int min = nums.length - 1;
		int max = 0;
		for (int i = 0; i < sortedNums.length; i++) {
			if (sortedNums[i] != nums[i]) {
				min = Math.min(min, i);
				max = Math.max(max, i);
			}
		}
		if (max < min) {
			return 0;
		}
		return max - min + 1;
	}
}
