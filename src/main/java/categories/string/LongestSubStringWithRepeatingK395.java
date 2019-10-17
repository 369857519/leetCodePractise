package categories.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithRepeatingK395 {

	public static void main(String[] args) {
		LongestSubStringWithRepeatingK395 longestSubStringWithRepeatingK395 = new LongestSubStringWithRepeatingK395();
		longestSubStringWithRepeatingK395.longestSubstring("aaabb", 3);
		longestSubStringWithRepeatingK395.longestSubstring("ababbc", 2);
	}

	public int longestSubstring(String s, int k) {
		Map<Character, Integer> counter = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character cur = s.charAt(i);
			if (counter.get(cur) == null) {
				counter.put(cur, 1);
			} else {
				counter.put(cur, counter.get(cur) + 1);
			}
		}
		int count = 0, res = 0;
		boolean lasting = false;
		for (int i = 0; i < s.length(); i++) {
			if (counter.get(s.charAt(i)) >= k) {
				if (lasting || i == 0) {
					count++;
					res = Math.max(count, res);
				}
				lasting = true;
			} else {
				count = 0;
				lasting = false;
			}
		}
		return res;
	}
}
