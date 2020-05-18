package algorithm.ppp;

public class SingleElementInASortedArray {

	public static void main(String[] args) {
		SingleElementInASortedArray singleElementInASortedArray = new SingleElementInASortedArray();
		singleElementInASortedArray.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6});
	}

	public int singleNonDuplicate(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res ^= nums[i];
		}
		return res;
	}
}
