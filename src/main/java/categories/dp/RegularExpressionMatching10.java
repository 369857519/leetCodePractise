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

	public boolean isMatch(String s, String p) {
		int[][] memoize = new int[s.length() + 1][p.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			int len = 0;
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '.') {
					len++;
					if (memoize[i][j] == 1 || len == 1) {
						memoize[i + 1][j + 1] = 1;
					}
				} else if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) == '.') {
						if (memoize[i][j] == 1) {
							return true;
						}
					} else if (currentChar == p.charAt(j - 1)) {
						if (memoize[i][j] == 1) {
							int k = i;
							while (k < s.length() && s.charAt(k) == p.charAt(j - 1)) {
								memoize[k + 1][j] = 1;
								k++;
								if (k == s.length() - 1) {
									return true;
								}
							}
						}
					}
				} else {
					if (memoize[i][j] == 1 && p.charAt(j) == currentChar && j <= i) {
						memoize[i + 1][j + 1] = 1;
					}
				}
			}
//			ArrayUtil.printArr(memoize);
		}
		for (int i = 0; i < memoize[s.length()].length; i++) {
			if (memoize[s.length()][i] == 1) {
				return true;
			}
		}
		return false;
	}

}
