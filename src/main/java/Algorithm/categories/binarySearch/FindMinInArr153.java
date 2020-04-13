package Algorithm.categories.binarySearch;

/**
 * Created by 祁连山 on 2019/5/12.
 */
public class FindMinInArr153 {
    public static void main(String[] args) {
        FindMinInArr153 findMinInArr153=new FindMinInArr153();
        int res=findMinInArr153.findMin(new int[]{5,1,2,3,4});
        res=findMinInArr153.findMin(new int[]{2,2,2,0,1});
        res=findMinInArr153.findMin(new int[]{5,6,7,1});
        res=findMinInArr153.findMin(new int[]{1,2,3});
        res=findMinInArr153.findMin(new int[]{5,6,7,1,2,3});
    }
    public int findMin(int[] nums) {
        if(nums.length==1)return nums[0];
        //判断是否旋转
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        return nums[binarySearch(nums,0,nums.length,nums[0])];
    }
    public int binarySearch(int[] nums,int low,int high,int interval){
        while(low!=high-1){
            int mid=(low+high)>>>1;
            if(interval>nums[mid]){
                high=mid;
            }else if(interval<nums[mid]){
                low=mid;
            }else{
                return mid;
            }
        }
        if(high==nums.length)return low;
        if(low==-1)return high;
        return nums[low]<nums[high]?low:high;
    }
}
