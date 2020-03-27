package categories.string;

import Utils.ArrayPrintUtil;

public class EditDistance72 {

    public static void main(String[] args) {
        EditDistance72 editDistance72 = new EditDistance72();
        int res = editDistance72.minDistance("horse", "ros");
        res = editDistance72.minDistance("intention", "execution");
        res=editDistance72.minDistance("","");
    }

    //最长公共子序列
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        //dp状态为到word1的i，到word2的j为止，最长公共子序列的长度
        //dp[0][0]=0
        //dp[1][0]=1
        //dp[0][1]=1
        //dp[1][1]=Math.max([n-1][n]+1,[n][n-1]+1,[n-1][n-1]+ifEqual)
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }
        ArrayPrintUtil.printArr(dp);
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                int minLast = Math.min(dp[i][j + 1] + 1, dp[i + 1][j] + 1);
                int add = word1.charAt(i) != word2.charAt(j) ? 1 : 0;
                dp[i + 1][j + 1] = Math.min(add + dp[i][j], minLast);
            }
            ArrayPrintUtil.printArr(dp);
        }
        return dp[word1.length()][word2.length()];
    }

}
