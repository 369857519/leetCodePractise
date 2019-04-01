package categories.dp;

public class RangeSumQuery303 {

	public static void main(String[] args) {
		RangeSumQuery303 rangeSumQuery303 = new RangeSumQuery303(new int[]{});
		int res = rangeSumQuery303.sumRange(1, 2);
	}

	int[] sums;

	public RangeSumQuery303(int[] nums) {
		sums = new int[nums.length];
		if(nums.length==0)return;
		sums[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		if (i == 0) {
			return sums[j];
		}
		return sums[j] - sums[i - 1];
	}
}
