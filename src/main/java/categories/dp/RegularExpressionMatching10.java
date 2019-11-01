package categories.dp;

public class RegularExpressionMatching10 {

	public static void main(String[] args) {
		RegularExpressionMatching10 regularExpressionMatching10 = new RegularExpressionMatching10();
//		boolean res = regularExpressionMatching10.isMatch("abc", "a.c");
//		res = regularExpressionMatching10.isMatch("aa", "a*");
//		res = regularExpressionMatching10.isMatch("abcccc", "abc*");
//		res = regularExpressionMatching10.isMatch("abcccc", "aba");
		boolean res = regularExpressionMatching10.isMatch("aab", "c*a*b");
	}

	enum Result {
		TRUE, FALSE
	}

	Result[][] memo;

	public boolean isMatch(String s, String p) {
		return true;
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

}
