package algorithm.categories.math;

import java.util.*;

public class PerfectSquares279 {
    public static void main(String[] args) {
        PerfectSquares279 perfectSquares279 = new PerfectSquares279();
        perfectSquares279.numSquares(13);
    }

    public int numSquares(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=1;
        for(int i=0;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
