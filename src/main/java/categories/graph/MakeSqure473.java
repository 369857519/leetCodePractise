package categories.graph;

import java.util.Set;

public class MakeSqure473 {

	public static void main(String[] args) {
		MakeSqure473 makeSqure473 = new MakeSqure473();
		boolean res = makeSqure473.makesquare(new int[]{1, 1, 2, 2, 6});
	}

	public boolean makesquare(int[] nums) {
		if(nums.length<4){
			return false;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 4 != 0) {
			return false;
		}
		return traverse(0, nums, new int[4], sum / 4);
	}

	private boolean traverse(int currentIndex, int[] nums, int[] process, int target) {
		if (currentIndex >= nums.length) {
			return false;
		}
		for (int i = 0; i < 4; i++) {
			if (process[i] < target) {
				process[i] += nums[currentIndex];
				//judge result
				if (currentIndex == nums.length - 1) {
					boolean currentRes = judgeRes(process, target);
					if (currentRes) {
						return true;
					}
				}
				boolean tempRes = traverse(currentIndex + 1, nums, process, target);
				process[i] -= nums[currentIndex];
				//如果其中有一种情况OK了，则直接返回
				if (tempRes) {
					return true;
				}
			}
		}
		//没有OK的路径，返回false
		return false;
	}

	public boolean judgeRes(int[] process, int target) {
		for (int j = 0; j < 4; j++) {
			if (process[j] != target) {
				return false;
			}
		}
		return true;
	}
}
