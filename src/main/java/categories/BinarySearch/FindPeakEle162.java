package categories.BinarySearch;

public class FindPeakEle162 {
	public static void main(String[] args) {

	}
	public int findPeakElement(int[] nums) {
		int l=0;int r=nums.length-1;
		while(l<r){
			int mid=l+r>>>1;
			if(nums[mid]>nums[mid+1]){
				r=mid;
			}else{
				l=mid+1;
			}
		}
		return l;
	}
}
