package ppp;

public class OptimalDivision {

	public String optimalDivision(int[] nums) {
		String ans = "";
		if (nums.length == 1) {
			ans = String.valueOf(nums[0]);
		}
		if (nums.length == 2) {
			ans = nums[0] + "/" + nums[1];
		}
		if (nums.length > 2) {
			ans = String.valueOf(nums[0]);
			ans += "/(";
			for (int i = 1; i < nums.length - 1; i++) {
				ans += nums[i] + "/";
			}
			ans += nums[nums.length - 1] + ")";
		}
		return ans;
	}
}
