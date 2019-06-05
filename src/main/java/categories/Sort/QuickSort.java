package categories.Sort;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(new int[]{3, 7, 1, 8, 15,9,22,10,88});
	}

	public void quickSort(int[] nums) {
		sort(0, nums.length - 1, nums);
	}

	public void sort(int start, int end, int[] nums) {
		int l = start, r = end;
		if (l >= r) {
			return;
		}
		int pivot = l;
		while (l < r) {
			if (nums[l] < nums[pivot]) {
				l++;
				continue;
			}
			if (nums[r] >= nums[pivot]) {
				r--;
				continue;
			}
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
		}
		int temp = nums[r];
		nums[r] = nums[pivot];
		nums[pivot] = temp;
		sort(start, r, nums);
		sort(r + 1, end, nums);
	}

}
