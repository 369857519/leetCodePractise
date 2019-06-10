package categories.sort;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(new int[]{3, 4, 5, 1, 7, 10, 22, 1231, 32, 1, 1, 2});
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
			if (nums[l] <= nums[pivot]) {
				l++;
				continue;
			}
			if (nums[r] > nums[pivot]) {
				r--;
				continue;
			}
			swap(l,r,nums);
		}
		swap(pivot,r-1,nums);
		sort(start, r - 1, nums);
		sort(r, end, nums);
	}

	public void swap(int l, int r, int[] nums) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
}
