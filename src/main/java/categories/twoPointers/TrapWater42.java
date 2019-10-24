package categories.twoPointers;

public class TrapWater42 {

	public static void main(String[] args) {
//		[0,1,0,2,1,0,1,3,2,1,2,1]
	}

	public int trap(int[] height) {
		int left = 0, right = height.length - 1;
		int res = 0;
		int collect = 0;
		while (true) {
			if (height[left] >= height[right]) {
				right++;
			} else {
				left++;
			}
		}
	}
}
