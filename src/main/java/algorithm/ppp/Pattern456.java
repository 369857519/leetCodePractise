package algorithm.ppp;

import java.util.Stack;

public class Pattern456 {

	public static void main(String[] args) {
		Pattern456 pattern456 = new Pattern456();
		pattern456.find132pattern(new int[]{1, 2, 3, 4});
		pattern456.find132pattern(new int[]{3, 1, 4, 2});
		pattern456.find132pattern(new int[]{-1, 3, 2, 0});
		pattern456.find132pattern(new int[]{3, 5, 0, 3, 4});
		pattern456.find132pattern(new int[]{2, 3, 1, 4});
		pattern456.find132pattern(new int[]{16, 16, 36, 36, 26, 26, 56, 56});
	}

	public boolean find132pattern(int[] nums) {
		int[] mins = new int[nums.length];
		mins[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			mins[i] = Math.min(mins[i - 1], nums[i]);
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] > mins[i]) {
				while (!stack.empty() && stack.peek() <= mins[i]) {
					stack.pop();
				}
				if (stack.empty() || nums[i] < stack.peek()) {
					stack.push(nums[i]);
				}
				if (!stack.empty() && nums[i] > stack.peek()) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean find132pattern_self(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		final int UP = 0;
		final int DOWN = 1;
		final int STRAIGHT = -1;
		int preDirection = STRAIGHT;

		int lastValley = -1;
		int[][] ranges = new int[nums.length / 2][];
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < len; j++) {
				if (ranges[j][0] < nums[i] && nums[i] < ranges[j][1]) {
					return true;
				}
			}
			if (i == nums.length - 1) {
				break;
			}
			if (nums[i] < nums[i + 1] && (preDirection == DOWN || preDirection == STRAIGHT)) {
				lastValley = i;
				preDirection = UP;
			}
			if (nums[i] > nums[i + 1] && (preDirection == UP || preDirection == STRAIGHT)) {
				if (lastValley != -1) {
					ranges[len++] = new int[]{nums[lastValley], nums[i]};
				}
				preDirection = DOWN;
			}
		}
		return false;
	}
}
