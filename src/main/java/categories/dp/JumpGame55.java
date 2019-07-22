package categories.dp;

public class JumpGame55 {

	public static void main(String[] args) {
		JumpGame55 jumpGame55 = new JumpGame55();
		jumpGame55.canJump(new int[]{2, 3, 1, 1, 4});
		jumpGame55.canJump(new int[]{3, 2, 1, 0, 4});
		jumpGame55.canJump(new int[]{2, 5, 0, 0});
		jumpGame55.canJump(new int[]{1, 0});
		jumpGame55.canJump(new int[]{0});
	}

	public boolean canJump(int[] nums) {
		if (nums.length == 0) {
			return true;
		}
		int farthest = nums[0];
		for (int i = 0; i <= farthest; i++) {
			farthest = Math.max(farthest, nums[i] + i);
			if (farthest >= nums.length - 1) {
				return true;
			}
		}
		return false;
	}

}
