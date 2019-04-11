package categories.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 祁连山 on 2019/4/9.
 */
public class LIS300 {
    public static void main(String[] args) {
        int[] test=new int[]{0,8,4,12,2};
        LIS300 lis300=new LIS300();
        int i=lis300.lengthOfLISB(test);
    }
    public int lengthOfLISB(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return 1;
        int[] lens=new int[nums.length];
        int[] maxs=new int[nums.length];
        lens[0]=0;
        maxs[0]=nums[0];
        for(int i=0;i<nums.length;i++){
            maxs[i]=nums[i];
            for(int j=0;j<i;j++){
                if(nums[i]>maxs[j]){
                    lens[i]=Math.max(lens[i],lens[j]);
                }
            }
            lens[i]++;
        }
        int max=0;
        for(int i=0;i<lens.length;i++){
            max=Math.max(lens[i],max);
        }
        return max;
    }
}
