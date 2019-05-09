package categories.BinarySearch;

import java.util.Arrays;

public class SearchRangePosition34 {

	public static void main(String[] args) {
		SearchRangePosition34 searchRangePosition35=new SearchRangePosition34();
		int[] test=searchRangePosition35.searchRange(new int[]{1,3,5,6},2);
		test=searchRangePosition35.searchRange(new int[]{1,3,5,6},5);
		test=searchRangePosition35.searchRange(new int[]{1,3,5,6},6);
		test=searchRangePosition35.searchRange(new int[]{1},0);
		test=searchRangePosition35.searchRange(new int[]{1,3},0);
		test=searchRangePosition35.searchRange(new int[]{5,7,7,8,8,10},8);

	}

	public int[] searchRange(int[] nums, int target) {
		int res=binarySearch(nums,0,nums.length-1,target);
		if(res==-1){
			return new int[]{-1,-1};
		}
		int right=0;
		for(int i=res+1;i<nums.length;i++){
			if(nums[i]==target){
				right++;
			}else{
				break;
			}
		}
		int left=0;
		for(int i=res-1;i>=0;i--){
			if(nums[i]==target){
				left--;
			}else{
				break;
			}
		}
		return new int[]{res+left,res+right};

	}

	public int binarySearch(int[] nums, int start, int end, int target) {
		if(end<0 || start> nums.length-1)return -1;
		if(start>=end){
			if(nums[start]==target)return start;
			if(nums[end]==target)return end;
			return -1;
		}
		int middleIndex = Math.round((end - start) / 2) + start;
		if (target > nums[middleIndex]) {
			return binarySearch(nums, middleIndex+1, end, target);
		}
		if (target < nums[middleIndex]) {
			return binarySearch(nums, start, middleIndex-1, target);
		}
		return middleIndex;
	}
}
