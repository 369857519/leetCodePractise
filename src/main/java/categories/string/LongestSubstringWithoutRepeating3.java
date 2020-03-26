package categories.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating3 {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating3 longestSubstringWithoutRepeating3 = new LongestSubstringWithoutRepeating3();
        int res = longestSubstringWithoutRepeating3.lengthOfLongestSubstring("aaabcdee");
        res = longestSubstringWithoutRepeating3.lengthOfLongestSubstring("au");
        res = longestSubstringWithoutRepeating3.lengthOfLongestSubstring(" ");
    }

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int left = 0;
        int resLength = 0;
        for (int i = 0; i < s.length(); i++) {
            //如果发现目前i所处的位置已经有元素，left向右移
            while (set.contains(s.charAt(i))) {
                resLength = Math.max(resLength, i - left);
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
        }
        resLength = Math.max(set.size(), resLength);
        return resLength;
    }

}
