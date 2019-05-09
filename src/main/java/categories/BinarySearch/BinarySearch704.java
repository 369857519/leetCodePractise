package categories.BinarySearch;

public class BinarySearch704 {

	public static void main(String[] args) {
		BinarySearch704 binarySearch704=new BinarySearch704();
		int res=binarySearch704.search(new int[]{-1,0,3,5,9,12},9);
	}
	public int search(int[] nums, int target) {
		int low=0;
		int high=nums.length-1;
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
