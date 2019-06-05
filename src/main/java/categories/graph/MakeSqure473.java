package categories.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeSqure473 {

	public static void main(String[] args) {
		MakeSqure473 makeSqure473 = new MakeSqure473();
		boolean res = makeSqure473.makesquare(
			new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
	}

	public boolean makesquare(int[] nums) {
		if (nums.length < 4) {
			return false;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 4 != 0) {
			return false;
		}
		Arrays.sort(nums);
		//循环四次
		for (int i = 0; i < 4; i++) {
			if (!traverse(0, nums.length - 1, nums, sum / 4)) {
				return false;
			}
		}
		return true;
	}

	Set<Integer> usedNumIndex = new HashSet<>();

	private boolean traverse(int currentSum, int indexOfNums, int[] nums, int target) {
		if (currentSum == target) {
			return true;
		}
		if (currentSum > target) {
			return false;
		}
		//仅在能填满第一个的情况下去找第二个的可能性，否则就不可能
		for (int i = indexOfNums; i >= 0; i--) {
			//每次indexOfNums已经排除了用过的情况
			if (!usedNumIndex.contains(i)) {
				usedNumIndex.add(i);
				if (traverse(currentSum + nums[i], indexOfNums - 1, nums, target)) {
					return true;
				}
				usedNumIndex.remove(i);
			}
		}
		return false;
	}
}
