package categories.string;

public class LongestSubStringWithRepeatingK395 {

	public static void main(String[] args) {
		LongestSubStringWithRepeatingK395 longestSubStringWithRepeatingK395 = new LongestSubStringWithRepeatingK395();
		longestSubStringWithRepeatingK395.longestSubstring("aaabb", 3);
		longestSubStringWithRepeatingK395.longestSubstring("ababbc", 2);
		longestSubStringWithRepeatingK395.longestSubstring("ababacb", 3);
		longestSubStringWithRepeatingK395.longestSubstring("aaabbb", 3);
		longestSubStringWithRepeatingK395.longestSubstring("bbaaacbd", 3);

	}

	public int longestSubstring(String s, int k) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int[] tempRecord = new int[26];
			for (int j = i; j < s.length(); j++) {
				tempRecord[s.charAt(j) - 'a']++;
				if (j - i + 1 >= k && isLegal(tempRecord, k)) {
					res = Math.max(res, j - i + 1);
				}
			}
			for (int j = 0; j < 26; j++) {
				tempRecord[j] = 0;
			}
		}
		return res;
	}

	public boolean isLegal(int[] tempRecord, int k) {
		boolean notEnough = true;
		for (int j = 0; j < 26; j++) {
			if (tempRecord[j] > 0 && tempRecord[j] < k) {
				notEnough = false;
			}
		}
		return notEnough;
	}
}
