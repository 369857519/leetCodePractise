package categories.twoPointers;

public class ContainerWithMostWater11 {

	public int maxArea(int[] height) {
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return max;
	}
}
