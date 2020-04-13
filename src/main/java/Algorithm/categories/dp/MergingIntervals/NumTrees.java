package Algorithm.categories.dp.MergingIntervals;

public class NumTrees {

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
    }

    public int numTrees(int n) {
        //n = 1 根为1
        //n = 2 一个右节点或者一个左节点 dp[1]*dp[0]+d[0]*dp[1]
        //n = 3
        // 可能有三种情况，左节点三个元素
        // 做节点一个，右节点一个
        // 右节点三个
        // dp[3]=dp[0]*dp[2]+dp[1]*dp[1]+dp[2]*dp[0]
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - j - 1];
            }
        }
        return 0;
    }

}
