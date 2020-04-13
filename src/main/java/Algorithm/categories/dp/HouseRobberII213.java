package Algorithm.categories.dp;

import java.util.Arrays;

/**
 * Created by 祁连山 on 2019/4/2.
 */
public class HouseRobberII213 {
    public static void main(String[] args) {
        HouseRobberII213 houseRobberII213=new HouseRobberII213();
        houseRobberII213.rob(new int[]{1,2,1,1});
    }
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[1],nums[0]);
        }

        return Math.max(robBySide(Arrays.copyOfRange(nums,1,nums.length)),robBySide(Arrays.copyOfRange(nums,0,nums.length-1)));
    }
    public int robBySide(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[1],nums[0]);
        }
        int[] record=new int[nums.length];
        record[0]=nums[0];
        record[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            record[i]=Math.max(record[i-1],record[i-2]+nums[i]);
        }
        int max=0;
        for(int j=0;j<record.length;j++){
            max=Math.max(record[j],max);
        }
        return max;
    }
}
