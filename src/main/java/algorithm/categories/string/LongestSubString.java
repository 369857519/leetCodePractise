package algorithm.categories.string;

public class LongestSubString {

    public int LongestSubString(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        //如果相等，则取前面的加1
        int max=0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = 0;
                }
                max=Math.max(max,dp[i+1][j+1]);
            }
        }
        return max;
    }

}
