package algorithm.categories.dp.DpStrings;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
//        int res = palindromicSubstrings.countSubstrings("aaa");
        int res = palindromicSubstrings.countSubstrings("abccc");

    }

    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        //初始化
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            int j = i + 1;
            sum++;
            if (j < s.length() && s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 1;
                sum++;
            }
        }
        //计算
        for (int subLen = 3; subLen <= s.length(); subLen++) {
            for (int i = 0; i <= len - subLen; i++) {
                if (s.charAt(i) == s.charAt(i + subLen - 1)
                    && dp[i + 1][i + subLen - 2] != 0) {
                    dp[i][i + subLen - 1] = 1;
                    sum++;
                }
            }
        }
        return sum;
    }

}
