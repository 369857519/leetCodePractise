package Algorithm.categories.hashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MinimumWindowSubstring76 {

    public static void main(String[] args) {
        MinimumWindowSubstring76 minimumWindowSubstring76 = new MinimumWindowSubstring76();
        minimumWindowSubstring76.minWindow("ADOBECODEBANC", "ABC");
        minimumWindowSubstring76.minWindow("aa", "aa");
    }

    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() == 0) {
            return "";
        }
        if (t.length() == 1) {
            return s.contains(t) ? t : "";
        }

        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            chars.merge(t.charAt(i), 1, Integer::sum);
        }

        Map<Character, Integer> viewedInChars = new HashMap<>();
        int start = 0, i;
        int resCount = s.length();
        String resString = "";
        for (i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (chars.containsKey(cur)) {
                viewedInChars.merge(cur, 1, Integer::sum);
            }

            while (isConveredBy(chars, viewedInChars)) {
                if (resCount >= i - start + 1) {
                    resString = s.substring(start, i + 1);
                    resCount = resString.length();
                }
                Character toBeRemove = s.charAt(start);
                if (viewedInChars.get(toBeRemove) != null
                    && viewedInChars.get(toBeRemove) != 1) {
                    viewedInChars.put(toBeRemove, viewedInChars.get(toBeRemove) - 1);
                } else {
                    viewedInChars.remove(toBeRemove);
                }
                start++;
            }
        }
        return resString;
    }

    public boolean isConveredBy(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.get(entry.getKey()) == null || map2.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
