package categories.BinarySearch;

/**
 * Created by 祁连山 on 2019/5/12.
 */
public class SearchRotetedArray33 {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0]==target?0:-1;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                //发现交叉点
                if(target<nums[0]){
                    return bSearch(nums,target,i,nums.length-1);
                }else{
                    return bSearch(nums,target,0,i-1);
                }
            }
        }
        return bSearch(nums,target,0,nums.length-1);
    }
    public int bSearch(int[] nums, int target, int low, int high) {
        while(low<=high){
            int mid=(low+high)>>>1;
            long midVal=nums[mid];

            if(midVal<target){
                low=mid+1;
            }else if(midVal>target){
                high=mid-1;
            }else{
                return mid;
            }
        }
//		return -(low+1);
        return -1;
    }
}
