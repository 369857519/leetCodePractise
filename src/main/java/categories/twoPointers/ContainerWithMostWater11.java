package categories.twoPointers;

import net.sf.json.JSONObject;

public class ContainerWithMostWater11 {

	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.element("product", "zhuanzhuan");
		jsonObject.element("OS", "Android");
		jsonObject.element("tech", "QuickGame");
		jsonObject.element("scene", "browserMi");
		System.out.println(jsonObject);
	}

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
