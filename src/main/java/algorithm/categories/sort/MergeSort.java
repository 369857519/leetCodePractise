package algorithm.categories.sort;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] test=new int[]{3, 4, 5, 1, 7, 10, 22, 1231, 32, 1, 1, 2};
        mergeSort.mergeSort(test, 0, test.length);
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start == end - 1) {
            return;
        }
        //left,right
        int mid = start + end >>> 1;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid, end);
        //merge
        int[] newStr = new int[end - start];
        int left = start;
        int right = mid;
        int ptr = 0;
        while (left != mid || right != end) {
            if (left == mid) {
                newStr[ptr++] = nums[right++];
                continue;
            }
            if (right == end) {
                newStr[ptr++] = nums[left++];
                continue;
            }
            if (nums[left] >= nums[right]) {
                newStr[ptr++] = nums[right++];
            } else {
                newStr[ptr++] = nums[left++];
            }
        }
        for (int i = 0; i < end - start; i++) {
            nums[i + start] = newStr[i];
        }
    }


}
