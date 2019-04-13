package categories.dp;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by 祁连山 on 2019/4/10.
 */
public class NLIS673 {
    public static void main(String[] args) {
        NLIS673 nlis673=new NLIS673();
        nlis673.findNumberOfLIS(new int[]{1,3,5,4,7});
        nlis673.findNumberOfLIS(new int[]{2,2,2,2,2});
        nlis673.findNumberOfLIS(new int[]{1,2});
        nlis673.findNumberOfLIS(new int[]{1});
        nlis673.findNumberOfLIS(new int[]{1,2,4,2,3});
        nlis673.findNumberOfLIS(new int[]{2,1});
        nlis673.findNumberOfLIS(new int[]{3,1,2});
    }
    public int findNumberOfLIS(int[] nums) {
            if(nums.length==0)return 0;
            if(nums.length==1)return 1;
            int[] lens=new int[nums.length];
            int[] maxs=new int[nums.length];
            int[] counts=new int[nums.length];
            counts[0]=1;
            maxs[0]=nums[0];
            for(int i=0;i<nums.length;i++) {
                maxs[i] = nums[i];
                for (int j = 0; j < i; j++) {
                    if (nums[i] > maxs[j]) {
                        lens[i] = Math.max(lens[i], lens[j]);
                    }
                }
                lens[i]++;
            }
            for(int i=0;i<nums.length;i++){
                if(lens[i]==1){
                    counts[i]=1;
                }
                for(int j=0;j<i;j++){
                    if(lens[j]==lens[i]-1&&nums[j]<nums[i]){
                        counts[i]+=counts[j];
                    }
                }
            }

            int max=0;
            for(int i=0;i<lens.length;i++){
                max= Math.max(max,lens[i]);
            }
            int count=0;
            for(int i=0;i<lens.length;i++){
                if(lens[i]==max){
                    count+=counts[i];
                }
            }
            return count;
    }
}
