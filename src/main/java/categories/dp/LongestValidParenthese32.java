package categories.dp;

import java.util.Stack;

public class LongestValidParenthese32 {

	public static void main(String[] args) {
		LongestValidParenthese32 longestValidParenthese32 = new LongestValidParenthese32();
		int res = longestValidParenthese32.longestValidParentheses("(()");
		res = longestValidParenthese32.longestValidParentheses(")()())");
		res = longestValidParenthese32.longestValidParentheses("");
	}

	public int longestValidParentheses(String s) {
		int maxans = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}
		return maxans;
	}

//	public int longestValidParentheses(String s) {
//		//o(n^2)循环，最慢的方式
//		int max = 0;
//		int record = 0;
//		int stk = 0;
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) == ')') {
//				continue;
//			}
//			for (int j = i; j < s.length(); j++) {
//				if (s.charAt(j) == '(') {
//					stk++;
//				}
//				if (s.charAt(j) == ')') {
//					stk--;
//				}
//				record += 1;
//				if (stk == 0) {
//					max = Math.max(max, record);
//				}
//				if (stk < 0) {
//					record = 0;
//					stk = 0;
//				}
//			}
//			record = 0;
//			stk = 0;
//		}
//		return max;
//	}
}
