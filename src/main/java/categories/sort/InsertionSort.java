package categories.sort;

import Utils.ArrayPrintUtil;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(new int[]{67, 3, 3, 7, 10, 2});
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j > -1 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
        ArrayPrintUtil.printArr(arr);
    }

    //Binary insertion
    public void BinarySort() {

    }

    public int BinarySearch(int[] arr, int left, int right, int target) {
        right = right - 1;
        int mid = 0;
        while (left < right) {
            mid = left + right >>> 1;
            if (target > mid) {
                left = mid + 1;
            } else if (target < mid) {
                right = mid - 1;
            } else {
                break;
            }
        }
        return mid + left;
    }


}
