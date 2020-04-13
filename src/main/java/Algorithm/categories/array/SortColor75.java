package Algorithm.categories.array;

import java.util.HashMap;

public class SortColor75 {

    public static void main(String[] args) {
        SortColor75 sortColor = new SortColor75();
        sortColor.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, zeroIndex++);
            }
        }
        int twoIndex = nums.length - 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == 2) {
                swap(nums, j, twoIndex--);
            }
        }
        new HashMap<>();
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
