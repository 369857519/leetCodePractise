package categories.dp.MergingIntervals;

public class MinScoreTrianulation1039 {

    private int length;

    public int minScoreTriangulation(int[] A) {
        this.length = A.length;
        //dp[i][j]
        //for k in i到j
        //这里注意需要计算环形的情况
        //Min(dp[k-1][k+1]+A[k]*A[k-1]+A[k+1]
        //记录以i为起点，j为终点的最小值
        int dp[][] = new int[A.length][A.length];

        //初始化三个节点的情况
        for (int i = 0; i < A.length; i++) {
            dp[i][i] = A[i];
            dp[i][i + 2] = A[i] * A[index(i + 1)] * A[index(i + 2)];
        }

        int min = Integer.MAX_VALUE;
        for (int length = 4; length <= A.length; length++) {
            for (int i = 0; i < A.length; i++) {
                dp[i][i + length] = cal(A, i, length, dp);
            }
        }

        return min;
    }

    public int index(int i) {
        if (i >= length) {
            return i - length;
        } else {
            return i;
        }
    }

    private int cal(int[] A, int i, int length, int[][] dp) {
        int min = Integer.MAX_VALUE;
        int end = i + length;
        for (int k = i; k <= end; k++) {
            int left = 0;
            int right = 0;
            min = Math.min(min, A[k] * A[index(k - 1)] * A[index(k + 1)] + left + right);
        }
        return min;
    }
}
