package algorithm.categories.dp;

public class RegularExpressionMatching10 {

	public static void main(String[] args) {
		RegularExpressionMatching10 regularExpressionMatching10 = new RegularExpressionMatching10();
		boolean res = regularExpressionMatching10.isMatch("abc", "a.c");
		res = regularExpressionMatching10.isMatch("aa", "a*");
		res = regularExpressionMatching10.isMatch("abcccc", "abc*");
		res = regularExpressionMatching10.isMatch("abcccc", "aba");
		res = regularExpressionMatching10.isMatch("aab", "c*a*b");
	}

	enum Result {
		TRUE, FALSE
	}

	Result[][] memo;

	public boolean isMatch(String s, String p) {
		return isMatchDPBottomUp(s, p);
	}

	public boolean isMatchRecursive(String text, String pattern) {
		if (pattern.isEmpty()) {
			return text.isEmpty();
		}
		boolean first_match = (!text.isEmpty() &&
			(pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (isMatchRecursive(text, pattern.substring(2)) ||
				(first_match && isMatchRecursive(text.substring(1), pattern)));
		} else {
			return first_match && isMatchRecursive(text.substring(1), pattern.substring(1));
		}
	}

	public boolean isMatchDP(String text, String pattern) {
		memo = new Result[text.length() + 1][pattern.length() + 1];
		return dp(0, 0, text, pattern);
	}

	public boolean dp(int i, int j, String text, String pattern) {
		if (memo[i][j] != null) {
			return memo[i][j] == Result.TRUE;
		}
		boolean ans;
		if (j == pattern.length()) {
			ans = i == text.length();
		} else {
			boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i)
				|| pattern.charAt(j) == '.'));
			if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
				ans = (dp(i, j + 2, text, pattern)) || first_match && dp(i + 1, j, text, pattern);
			} else {
				ans = first_match && dp(i + 1, j + 1, text, pattern);
			}
		}
		memo[i][j] = ans ? Result.TRUE : Result.FALSE;
		return ans;
	}

	public boolean isMatchDPBottomUp(String text, String pattern) {
		boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
		dp[text.length()][pattern.length()] = true;

		for (int i = text.length(); i >= 0; i--) {
			for (int j = pattern.length() - 1; j >= 0; j--) {
				boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i)
					|| pattern.charAt(j) == '.'));
				if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
					dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
				} else {
					dp[i][j] = first_match && dp[i + 1][j + 1];
				}
			}
		}
		return dp[0][0];
	}
}
