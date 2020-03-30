package categories.sort;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(new int[]{3, 4, 5, 1, 7, 10, 22, 1231, 32, 1, 1, 2});
    }

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length);
    }

    public void sort(int[] nums, int start, int end) {
        end = end - 1;
        if (start == end) {
            return;
        }
        int pivot = start;
        int left = pivot + 1;
        int right = end;
        while (left < right) {
            if (nums[left] >= nums[pivot]) {
                swap(nums, left, right--);
            } else {
                left++;
            }
        }
        swap(nums, pivot, start);
        sort(nums, pivot - 1, start);
        sort(nums, start, end + 1);
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
