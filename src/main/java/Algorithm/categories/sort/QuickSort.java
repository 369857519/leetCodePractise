package Algorithm.categories.sort;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(new int[]{10, 33, 2, 111, 4, 60, 3});
    }

    public void quickSort(int[] nums) {

        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int pivot = arr[j];
        while (i < j) {
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
        }
        arr[j] = pivot;
        sort(arr, left, j - 1);
        sort(arr, j + 1, right);
    }
}
