package Algorithm.categories.dp;

import Algorithm.Utils.ArrayPrintUtil;

public class MaximalRectangle85 {

    public static void main(String[] args) {
        MaximalRectangle85 maximalRectangle85 = new MaximalRectangle85();
        maximalRectangle85.maximalRectangle(new char[][]{
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        });
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n <= 0) {
            return 0;
        }
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    dp[i][j] = matrix[i][j] == '1' ? (dp[i - 1][j] + 1) : 0;
                }
                int min = dp[i][j];
                ArrayPrintUtil.printArr(dp);
                maxArea = kepp(maxArea, min, i, j, dp);
            }
        }
        return maxArea;
    }

    private int kepp(int maxArea, int min, int i, int j, int[][] dp) {
        for (int k = j; k >= 0; k--) {
            if (min == 0) {
                break;
            }
            if (dp[i][k] < min) {
                min = dp[i][k];
            }
            maxArea = Math.max(maxArea, min * (j - k + 1));
        }
        return maxArea;
    }
}
