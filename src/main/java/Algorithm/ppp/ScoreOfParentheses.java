package Algorithm.ppp;

import java.util.Stack;

public class ScoreOfParentheses {

	public int scoreOfParentheses(String S) {
		Stack<Character> parentheseStk = new Stack<>();
		Stack<Integer> parentheseIndexes = new Stack<>();
		int totalCount = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				parentheseStk.push('(');
				parentheseIndexes.push(i);
			}
			if (S.charAt(i) == ')') {
				if (parentheseIndexes.peek() == i - 1) {
					totalCount += Math.pow(2, parentheseStk.size() - 1);
				}
				parentheseStk.pop();
				parentheseIndexes.pop();
			}
		}
		return totalCount;
	}
}
