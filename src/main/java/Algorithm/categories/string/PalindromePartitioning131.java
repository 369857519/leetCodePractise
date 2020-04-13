package Algorithm.categories.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {

	public static void main(String[] args) {
		PalindromePartitioning131 palindromePartitioning131 = new PalindromePartitioning131();
		List<List<String>> strArr = palindromePartitioning131.partition("aab");
		strArr=palindromePartitioning131.partition("");
		strArr=palindromePartitioning131.partition("ccccc");
	}

	public int[] maxPalindromeRecord;
	public String counting;

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
		counting = countingS;
		maxPalindromeRecord = record;
		List<List<String>> res = new ArrayList<>();
		split(res, new ArrayList(), 0, s);
		return res;
	}

	public void split(List<List<String>> res, List<String> list,
		int start, String s) {
		if (start == s.length()) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = start + 1; i <= s.length(); i++) {
			if (checkIfPalindrome(start, i)) {
				list.add(s.substring(start, i));
				split(res, list, i, s);
				list.remove(list.size() - 1);
			}
		}
	}

	public boolean checkIfPalindrome(int start, int end) {
		int recStart = start * 2 + 1;
		int recEnd = end * 2;
		int mid = recStart + recEnd >> 1;
		return maxPalindromeRecord[mid] >= end - start;
	}
}
