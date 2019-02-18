package ppp;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
		int f = palindromicSubstrings.countSubstrings("aaa");
		int s = palindromicSubstrings.countSubstrings("abc");
	}

	public int countSubstrings(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += judge(i, s);
		}
		return res;
	}

	public int judge(int i, String s) {
		int count = 1;
		//以自己为中心
		int offset = 1;
		while (i - offset >= 0 && i + offset < s.length() && s.charAt(i - offset) == s
			.charAt(i + offset)) {
			count++;
			offset++;
		}
		//以自己和下一个为中心
		if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
			count++;
			offset = 1;
			while (i - offset >= 0 && i + 1 + offset < s.length() && s.charAt(i - offset) == s
				.charAt(i + 1 + offset)) {
				count++;
				offset++;
			}
		}
		return count;
	}

}
