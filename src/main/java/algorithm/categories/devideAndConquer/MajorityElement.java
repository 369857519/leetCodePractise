package algorithm.categories.devideAndConquer;

public class MajorityElement {

	public int majorityElement(int[] nums) {
		return 0;
	}

	public int[] majorityElement(int l, int r, int[] nums) {
		if (l == r) {
			return new int[]{nums[l], 1};
		}
		int mid = l + r >>> 1;
		//0：数字本身 1：count
		int[] left = majorityElement(l, mid, nums);
		int[] right = majorityElement(mid + 1, r, nums);
		if (left[0] == right[0]) {
			return new int[]{left[0], left[1] + right[1]};
		} else {
			int[] next = left[1] > right[1] ? left : right;
			return next;
		}
	}
}
