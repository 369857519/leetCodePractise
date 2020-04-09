package categories.dp.MinimumOrMaximumPath;

import Utils.ArrayPrintUtil;

public class Backpack {
    public static void main(String[] args) {
        Backpack backpack=new Backpack();
        backpack.backPackII(10,new int[]{2,3,5,7},new int[]{1,5,2,4});
    }
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[][] dp=new int[A.length+1][m+1];
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=m;j++){
                if(A[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-A[i-1]]+V[i-1]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        ArrayPrintUtil.printArr(dp);
        return dp[A.length][m];
    }
}
