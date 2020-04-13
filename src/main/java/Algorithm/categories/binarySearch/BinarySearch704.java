package Algorithm.categories.binarySearch;

public class BinarySearch704 {

	public static void main(String[] args) {
		BinarySearch704 binarySearch704 = new BinarySearch704();
		int res = binarySearch704.search(new int[]{-1, 0, 3, 5, 8, 12}, 13);
	}

	public int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = l + r >>> 1;
			if (nums[mid] < target) {
				l = mid + 1;
			} else if (nums[mid] > target) {
				r = mid - 1;
			} else {
				return mid;
			}
		}
		return l;
	}
}
