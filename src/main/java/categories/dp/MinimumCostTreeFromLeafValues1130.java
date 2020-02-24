package categories.dp;

public class MinimumCostTreeFromLeafValues1130 {

    public int getmax(int nums[],int start,int end){
        int res=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            res=Math.max(res,nums[i]);
        }
        return res;
    }

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length - 1;
        int[][] maxs = new int[n][n];
        //记录i到j的最大值，越大的值放在越上方
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                maxs[i][j]=getmax(arr,i,j);
            }
        }

        //每个位置的
        int[][] dp = new int[n][n];
        //逐步增加元素个数
        for (int l = 1; l < n; ++l) {

            for (int i = 0; i < n - l; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    dp[i][j] = Math
                        .min(dp[i][j], dp[i][k] + dp[k + 1][j] + maxs[i][k] * maxs[k + 1][j]);
                }
            }
        }
        return dp[0][n-1];
    }

}
