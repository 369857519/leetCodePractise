package categories.dp.MergingIntervals;

public class MinScoreTrianulation1039 {

    public int minScoreTriangulation(int[] A) {
        //dp[i][j]
        //for k in i到j
        //这里注意需要计算环形的情况
        //Min(dp[k-1][k+1]+A[k]*A[k-1]+A[k+1]
        //记录以i为起点，j为终点的最小值
        int dp[][] = new int[A.length][A.length];

        //初始化三个节点的情况
        for (int i = 0; i < A.length; i++) {
            cal(A, i, i + 3, dp);
        }

        int min = Integer.MAX_VALUE;
        for (int length = 4; length <= A.length; length++) {
            for (int i = 0; i < A.length; i++) {
                int res = cal(A, i, i + length, dp);
                if (length == A.length) {
                    min = Math.min(min, res);
                }
            }
        }

        return min;
    }

    private int cal(int[] A, int i, int j, int[][] dp) {
        return 0;
    }
}
