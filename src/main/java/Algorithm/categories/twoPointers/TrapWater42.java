package Algorithm.categories.twoPointers;

public class TrapWater42 {

	public static void main(String[] args) {
		TrapWater42 trapWater42 = new TrapWater42();
		int test = trapWater42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
		test = trapWater42.trap(new int[]{});
		test = trapWater42.trap(new int[]{1, 1});
		test = trapWater42.trap(new int[]{1, 0, 0, 1});
		test = trapWater42.trap(new int[]{0, 5, 6, 4, 6, 1, 0, 0, 2, 7});
	}

	public int trap(int[] height) {
		int left = 0, leftStop = 0, right = 0;
		int leftCount = 0, rightCount = 0;
		int res = 0;
		//从左到右,把等于的情况也记录在内
		for (int i = 0; i < height.length; i++) {
			if (height[i] < left) {
				leftCount += left - height[i];
			} else {
				res += leftCount;
				leftCount = 0;
				left = height[i];
				leftStop = i;
			}
		}
		//从右到左,等于的情况清0
		for (int i = height.length - 1; i >= 0; i--) {
			if (height[i] < right) {
				rightCount += right - height[i];
			} else {
				if (height[i] != right || i >= leftStop) {
					res += rightCount;
					right = height[i];
				}
				rightCount = 0;
			}
		}
		return res;
	}
}
