package categories.search.DFS;

public class DecodeWays91 {

	public static void main(String[] args) {
		DecodeWays91 decodeWays91 = new DecodeWays91();
		int res = decodeWays91.numDecodingsTimeLimitExceeded("01");
	}

	public int numDecodings(String s) {
		int[] record = new int[s.length()];
		record[0] = legal(s.substring(0, 1));
		record[1] = legal(s.substring(0, 2)) + legal(s.substring(1, 2)) * record[0];
		for (int i = 2; i < s.length(); i++) {
			record[i] = record[i - 1] * legal(s.substring(0, i)) + record[i - 2] + legal(
				s.substring(0, i + 1));
		}
		return record[s.length() - 1];
	}


	public int numDecodingsTimeLimitExceeded(String s) {
		if (s.length() == 0) {
			//说明分完了
			return 1;
		}
		if (s.length() == 1) {
			return legal(s);
		}
		int one = legal(s.substring(0, 1));
		int two = legal(s.substring(0, 2));
		if (one == 0 && two == 0) {
			return 0;
		} else if (one == 0) {
			return numDecodingsTimeLimitExceeded(s.substring(2, s.length()));
		} else if (two == 0) {
			return numDecodingsTimeLimitExceeded(s.substring(1, s.length()));
		} else {
			return numDecodingsTimeLimitExceeded(s.substring(2, s.length()))
				+ numDecodingsTimeLimitExceeded(
				s.substring(1, s.length()));
		}
	}

	public int legal(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}
		int num = Integer.parseInt(s);
		return (num > 0 && num < 27) ? 1 : 0;
	}
}
