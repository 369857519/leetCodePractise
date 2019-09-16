package categories.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {

	public static void main(String[] args) {
		PalindromePartitioning131 palindromePartitioning131 = new PalindromePartitioning131();
		palindromePartitioning131.partition("aabaaacc");
	}

	public List<List<String>> partition(String s) {
		int lastCenter = 0;
		int lastRight = 0;
		String countingS = "@" + String.join("#", s.split(""));
		int[] record = new int[countingS.length()];
		for (int i = 0; i < countingS.length(); i++) {
			if (i < lastRight) {
				int symmetricI = 2 * lastCenter - i;
				record[i] = record[symmetricI];
				if (i + record[i] >= lastRight) {
					//从symmetricI开始重新计算
					int count = lastRight - i;
					while ((i - count) >= 0 && (i + count) < countingS.length()
						&& countingS.charAt(i + count) == countingS.charAt(i - count)) {
						count++;
					}
					record[i] = count;
					lastRight = i + count - 1;
					lastCenter = i;
				}
			} else {
				int count = 1;
				while ((i - count) >= 0 && (i + count) < countingS.length()
					&& countingS.charAt(i + count) == countingS.charAt(i - count)) {
					count++;
				}
				record[i] = count;
				lastRight = i + count - 1;
				lastCenter = i;
			}
		}
		List<List<String>> res = new ArrayList<>();
		split(res, new ArrayList(), record, 0, s);
		return res;
	}

	public void split(List<List<String>> res, List<String> list, int[] record,
		int start, String s) {
		if (start == s.length()) {
			res.add(list);
		}
		for (int i = start + 1; i < s.length(); i++) {
			if (checkIfPalindrome(record, start, i)) {
				list.add(s.substring(start, i));
				split(res, list, record, i + 1, s);
			}
		}
	}

	public boolean checkIfPalindrome(int[] record, int start, int end) {
		return true;
	}
}
