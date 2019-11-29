package categories.math;

import java.util.Stack;

public class LargestRectangle84 {

	public static void main(String[] args) {
		LargestRectangle84 largestRectangle84 = new LargestRectangle84();
		largestRectangle84.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
		largestRectangle84.largestRectangleArea(new int[]{});
	}


	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0, n = heights.length;
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				int height = heights[stack.pop()];
				int length = stack.isEmpty() ? i : i - stack.peek() - 1;
				int area = height * length;
				maxArea = Math.max(maxArea, area);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int height = heights[stack.pop()];
			int length = stack.isEmpty() ? n : n - stack.peek() - 1;
			int area = height * length;
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}
//	public int largestRectangleArea(int[] heights) {
//		int res = 0;
//		for (int i = 0; i < heights.length; i++) {
//			int min = Integer.MAX_VALUE;
//			for (int j = i; j < heights.length; j++) {
//				min = Math.min(min, heights[j]);
//				res = Math.max((j - i + 1) * min, res);
//			}
//		}
//		return res;
//	}

}
