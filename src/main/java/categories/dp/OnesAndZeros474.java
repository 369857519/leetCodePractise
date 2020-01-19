package categories.dp;

import Utils.ArrayPrintUtil;

public class OnesAndZeros474 {

    public static void main(String[] args) {
        OnesAndZeros474 onesAndZeros474 = new OnesAndZeros474();
        onesAndZeros474.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        onesAndZeros474.findMaxForm(new String[]{"10", "0", "1"}, 1, 1);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] record = new int[2];
            for (Character chr : str.toCharArray()) {
                if (chr == '0') {
                    record[0]++;
                } else {
                    record[1]++;
                }
            }
            for (int i = m; i >= record[0]; i--) {
                for (int j = n; j >= record[1]; j--) {
                    dp[i][j] = Math.max(dp[i - record[0]][j - record[1]] + 1, dp[i][j]);
                }
            }
            ArrayPrintUtil.printArr(dp);
        }
        return dp[m][n];
    }

}
