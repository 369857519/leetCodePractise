package categories.dp;

import java.util.Arrays;

/**
 * Created by 祁连山 on 2019/4/10.
 */
public class NLIS673 {
    public static void main(String[] args) {
        NLIS673 nlis673=new NLIS673();
//        nlis673.findNumberOfLIS(new int[]{1,3,5,4,7});
//        nlis673.findNumberOfLIS(new int[]{2,2,2,2,2});
//        nlis673.findNumberOfLIS(new int[]{1,2});
//        nlis673.findNumberOfLIS(new int[]{1});
        nlis673.findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2});
    }
    public int findNumberOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int len=0;
        int[] res=new int[nums.length];

        for(int num:nums){
            int i= Arrays.binarySearch(dp,0,len,num);
            if(i<0){
                i=-(i+1);
            }
            if(i==len){
                len++;
            }

            res[len-1]++;
            dp[i]=num;
            System.out.println();
        }
        int size=1;
        for(int num:res){
            if(num!=0){
                size*=num;
            }
        }
        return size;
    }
}
