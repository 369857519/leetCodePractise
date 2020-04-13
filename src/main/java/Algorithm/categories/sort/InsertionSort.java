package Algorithm.categories.sort;

import Algorithm.Utils.ArrayPrintUtil;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(new int[]{67, 3, 3, 7, 10, 2});
        insertionSort.binarySort(new int[]{67, 3, 3, 7, 10, 2});
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
    public void binarySort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            int loc = binarySearch(arr, 0, i, temp);
            for (; j >= loc; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
        ArrayPrintUtil.printArr(arr);
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        right=right-1;
        while(left<right){
            int mid=left+right>>1;
            if(target>arr[mid]){
                left=mid+1;
            }else if(target<arr[mid]){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return left;
    }


}
