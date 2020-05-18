package algorithm.categories.string;

public class ValidAnagram242 {

	public static void main(String[] args) {
		ValidAnagram242 validAnagram242 = new ValidAnagram242();
		boolean test = validAnagram242.isAnagram("abc", "cba");
		test = validAnagram242.isAnagram("ccc", "abc");
		test = validAnagram242.isAnagram("", "a");
		test = validAnagram242.isAnagram("", "");
		test = validAnagram242.isAnagram("nl", "cx");
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() == 0 && t.length() == 0) {
			return true;
		}
		if (s.length() != t.length() ||
			(s.length() == 0 || t.length() == 0)) {
			return false;
		}
		int[] record = new int[26];

		for (int i = 0; i < s.length(); i++) {
			record[s.charAt(i) - 'a']++;
			record[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < record.length; i++) {
			if (record[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
