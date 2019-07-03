package categories.binarySearch;

public class SearchInsertPosition35 {

	public static void main(String[] args) {
		SearchInsertPosition35 searchInsertPosition35=new SearchInsertPosition35();
		int test=searchInsertPosition35.searchInsert(new int[]{1,3,5,6},2);
		test=searchInsertPosition35.searchInsert(new int[]{1,3,5,6},5);
		test=searchInsertPosition35.searchInsert(new int[]{1,3,5,6},6);
		test=searchInsertPosition35.searchInsert(new int[]{1},0);
		test=searchInsertPosition35.searchInsert(new int[]{1,3},0);
		test=searchInsertPosition35.searchInsert(new int[]{3,5,7,9,10},8);

	}

	public int searchInsert(int[] nums, int target) {
		return binarySearch(nums,0,nums.length-1,target );
	}

	public int binarySearch(int[] nums, int start, int end, int target) {
		if(end<0)return start;
		if(start>nums.length-1)return end;
		if(start>=end){
			if(nums[start]>=target)return start;
			return start+1;
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
