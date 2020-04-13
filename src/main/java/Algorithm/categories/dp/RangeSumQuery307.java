package Algorithm.categories.dp;

public class RangeSumQuery307 {

	public static void main(String[] args) {
		RangeSumQuery307 numArray = new RangeSumQuery307(new int[]{1, 3, 5});
		int res = numArray.sumRange(0, 2);
		numArray.update(1, 2);
		res = numArray.sumRange(0, 2);
	}

	int[] preSums;
	int[] nums;

	public RangeSumQuery307(int[] nums) {
		this.nums = nums;
		preSums = new int[nums.length + 1];
		preSums[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			preSums[i + 1] = nums[i] + preSums[i];
		}
	}

	public void update(int i, int val) {
		int diff = nums[i] - val;
		nums[i]=val;
		for (int j = i; j < nums.length; j++) {
			preSums[j + 1] -= diff;
		}
	}

	public int sumRange(int i, int j) {
		return preSums[j + 1] - preSums[i];
	}


}
