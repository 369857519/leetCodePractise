package Algorithm.categories.twoPointers;

public class ContainerWithMostWater11 {

	public static void main(String[] args) {
		ContainerWithMostWater11 containerWithMostWater11 = new ContainerWithMostWater11();
		containerWithMostWater11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
	}

	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1, max = 0;
		while (left < right) {
			int smaller = Math.min(height[left], height[right]);
			max = Math.max(max, (right - left) * smaller);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}
}
