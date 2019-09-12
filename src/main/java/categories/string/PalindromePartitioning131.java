package categories.string;

import java.util.Arrays;
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

		int[][] matrix = new int[countingS.length()][countingS.length()];
		//adjacency matrix
		System.out.println(Arrays.toString(record));

		return null;
	}
}
