package Algorithm.categories.binarySearch;

/**
 * Created by 祁连山 on 2019/5/12.
 */
public class FindMinInArrII154 {
    public static void main(String[] args) {
        FindMinInArrII154 findMinInArr154=new FindMinInArrII154();
        int res=findMinInArr154.findMin(new int[]{5,1,2,3,4});
        res=findMinInArr154.findMin(new int[]{2,2,2,0,1});
        res=findMinInArr154.findMin(new int[]{3,1,3,3});
        res=findMinInArr154.findMin(new int[]{5,6,7,1});
        res=findMinInArr154.findMin(new int[]{1,2,3});
        res=findMinInArr154.findMin(new int[]{5,6,7,1,2,3});
        res=findMinInArr154.findMin(new int[]{1,1});
        res=findMinInArr154.findMin(new int[]{1,1,1});
        res=findMinInArr154.findMin(new int[]{-1,-1,-1,-1});
        res=findMinInArr154.findMin(new int[]{10,10,10,10,1});
        res=findMinInArr154.findMin(new int[]{1,1,2,0,0,1});
        res=findMinInArr154.findMin(new int[]{1,3,1,1,1});
        res=findMinInArr154.findMin(new int[]{2,2,2,3,1});
    }
    public int findMin(int[] nums) {
        if(nums.length==1)return nums[0];
        //判断是否旋转
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        return nums[binarySearch(nums,0,nums.length)];
    }
    public int binarySearch(int[] nums,int low,int high){
        while(low<high-2){
            int mid=(low+high)>>>1;
            if(nums[high-1]<nums[mid]){
                low=mid;
            }else if(nums[high-1]>nums[mid]){
                high=mid+1;
            }else{
               int left=binarySearch(nums,low,mid);
               int right=binarySearch(nums,mid+1,high);
               if(nums[left]<=nums[right]){
                   return left;
               }else if(nums[left]>nums[right]){
                   return right;
               }
            }
        }
        if(low==-1)return high;
        return nums[low]<nums[high-1]?low:high-1;
    }
}
//class Solution {
//    public:
//    int findMin(vector<int> &num) {
//        int lo = 0;
//        int hi = num.size() - 1;
//        int mid = 0;
//
//        while(lo < hi) {
//            mid = lo + (hi - lo) / 2;
//
//            if (num[mid] > num[hi]) {
//                lo = mid + 1;
//            }
//            else if (num[mid] < num[hi]) {
//                hi = mid;
//            }
//            else { // when num[mid] and num[hi] are same
//                hi--;
//            }
//        }
//        return num[lo];
//    }
//};