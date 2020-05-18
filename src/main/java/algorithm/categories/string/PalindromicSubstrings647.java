package algorithm.categories.string;

public class PalindromicSubstrings647 {

    public static void main(String[] args) {
        PalindromicSubstrings647 palindromicSubstrings647 = new PalindromicSubstrings647();
        palindromicSubstrings647.countSubstrings("aaa");
    }

    public int countSubstrings(String s) {
        int count = 0;
        //奇数
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            while (j + i < s.length() && i - j >= 0) {
                if (s.charAt(i + j) == s.charAt(i - j)) {
                    count++;
                    j++;
                } else {
                    break;
                }
            }
        }
        //偶数
        for (int i = 0; i < s.length() - 1; i++) {
            int j = 0;
            while (j + i + 1 < s.length() && i - j >= 0) {
                if (s.charAt(i + j + 1) == s.charAt(i - j)) {
                    count++;
                    j++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

}
