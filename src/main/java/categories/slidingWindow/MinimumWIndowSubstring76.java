package categories.slidingWindow;

public class MinimumWIndowSubstring76 {

	public static void main(String[] args) {
		MinimumWIndowSubstring76 minimumWIndowSubstring76 = new MinimumWIndowSubstring76();
		String res = minimumWIndowSubstring76.minWindow("ADOBECODEBANC", "ABC");
		res = minimumWIndowSubstring76.minWindow("", "");
		res = minimumWIndowSubstring76.minWindow("", "ABC");
		res = minimumWIndowSubstring76.minWindow("abcdaaa", "aa");
		res = minimumWIndowSubstring76.minWindow("a", "a");

	}

	//Input: S = "ADOBECODEBANC", T = "ABC"
	//Output: "BANC"

	//o(n)
	//sliding window
	public String minWindow(String s, String t) {
		int[] record = new int[58];
		int[] targetRecord = new int[58];
		for (int i = 0; i < t.length(); i++) {
			record[t.charAt(i) - 'A']++;
		}
		int start = 0;
		int end = 0;
		int resCount = s.length();
		String resString = "";
		while (end <= s.length()) {
			boolean isLegal = legal(record, targetRecord);
			if (isLegal || end == s.length()) {
				if (end - start <= resCount && isLegal) {
					resCount = end - start;
					resString = s.substring(start, end);
				}
				if (start == s.length()) {
					break;
				}
				int currentCode = s.charAt(start) - 'A';
				if (record[currentCode] > 0) {
					targetRecord[currentCode]--;
				}
				start++;
			} else {
				int currentCode = s.charAt(end) - 'A';
				if (record[currentCode] > 0) {
					targetRecord[currentCode]++;
				}
				end++;
			}
		}
		return resString;
	}

	public boolean legal(int[] record, int[] newRecord) {
		for (int i = 0; i < record.length; i++) {
			if (record[i] > newRecord[i]) {
				return false;
			}
		}
		return true;
	}

}
