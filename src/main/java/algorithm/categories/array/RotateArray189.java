package algorithm.categories.array;

public class RotateArray189 {

    public static void main(String[] args) {
        RotateArray189 rotateArray189 = new RotateArray189();
        rotateArray189.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotateArray189.rotate(new int[]{1, 2}, 0);
        rotateArray189.rotate(new int[]{1, 2}, 1);
        rotateArray189.rotate(new int[]{1, 2}, 2);
        rotateArray189.rotate(new int[]{1, 2}, 3);
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        k = nums.length - k;
        swapFromMiddle(nums, 0, k - 1);
        swapFromMiddle(nums, k, nums.length - 1);
        swapFromMiddle(nums, 0, nums.length - 1);
    }

    public void swapFromMiddle(int[] nums, int start, int end) {
        int mid = start + end >> 1;
        for (int i = start; i <= mid; i++) {
            int temp = nums[i];
            nums[i] = nums[end];
            nums[end] = temp;
            end--;
        }
    }

}
