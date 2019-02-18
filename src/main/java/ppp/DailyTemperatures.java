package ppp;

import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		DailyTemperatures dailyTemperatures = new DailyTemperatures();
		dailyTemperatures.dailyTemperaturesInStack(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
	}

	public int[] dailyTemperatures(int[] T) {
//		T = [73, 74, 75, 71, 69, 72, 76, 73]
//		[1, 1, 4, 2, 1, 1, 0, 0].
		int len = T.length;
		int[] res = new int[len];
		for (int i = 0; i < len; i++) {
			int count = 0;
			for (int j = i + 1; j < len; j++) {
				count++;
				if (T[j] > T[i]) {
					res[i] = count;
					break;
				}
			}
		}
		return res;
	}

	/*
	Intuition

	we should remember a list of indices representing a strictly increasing list of temperatures
	倒序向前
		1.如果index小但是值比较大，就把栈清空
		2.如果index小但是值小，推进去等待下一次比较
	 */

	public int[] dailyTemperaturesInStack(int[] T) {
//		T = [73, 74, 75, 71, 69, 72, 76, 73]
//		[1, 1, 4, 2, 1, 1, 0, 0].
		int len = T.length;
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[len];
		for (int i = len - 1; i > -1; --i) {
			while (!stack.empty() && T[stack.peek()] < T[i]) {
				stack.pop();
			}
			if (stack.empty()) {
				res[i] = 0;
			} else {
				res[i] = stack.peek() - i;
			}
			stack.push(i);
		}
		return res;
	}
}
