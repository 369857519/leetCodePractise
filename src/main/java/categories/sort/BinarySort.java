package categories.sort;

public class BinarySort {

	public static void main(String[] args) {
		BinarySort binarySort = new BinarySort();
		binarySort.binarySort(new int[]{3, 4, 5, 1, 7, 10, 22, 1231, 32, 1, 1, 2});
	}

	public void binarySort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int index = binarySearch(0, i - 1, nums[i], nums);
			int insertVal = nums[i];
			for (int j = i; j > index; j--) {
				nums[j] = nums[j - 1];
			}
			nums[index] = insertVal;
		}
	}

	public int binarySearch(int l, int r, int target, int[] nums) {
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
