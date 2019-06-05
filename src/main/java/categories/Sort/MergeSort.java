package categories.Sort;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(new int[]{3, 4, 5, 1, 7, 10, 22, 1231, 32, 1, 1, 2});
	}

	public void mergeSort(int[] nums) {
		sort(0, nums.length - 1, nums);
	}

	public int[] sort(int start, int end, int[] nums) {
		if (start == end) {
			return new int[]{nums[start]};
		}
		int mid = start + end >>> 1;
		int count = 0;
		int[] left = sort(start, mid, nums);
		int[] right = sort(mid + 1, end, nums);
		int[] res = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		while (count <= end - start) {
			if (i >= left.length) {
				res[count++] = right[j++];
			} else if (j >= right.length) {
				res[count++] = left[i++];
			} else {
				if (left[i] > right[j]) {
					res[count] = right[j];
					i++;
				} else {
					res[count] = left[i];
					j++;
				}
				count++;
			}
		}
		return res;
	}

}
