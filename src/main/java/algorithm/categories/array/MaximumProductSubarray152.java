package algorithm.categories.array;

public class MaximumProductSubarray152 {

    public static void main(String[] args) {
        MaximumProductSubarray152 maximumProductSubarray152 = new MaximumProductSubarray152();
        int res = maximumProductSubarray152.maxProduct(new int[]{2, 3, -2, 4});
        res = maximumProductSubarray152.maxProduct(new int[]{-2, 0, -1});
        res = maximumProductSubarray152.maxProduct(new int[]{});
        res = maximumProductSubarray152.maxProduct(new int[]{1, 2, 3, 4, -5, 6, 7, 8});
        res = maximumProductSubarray152.maxProduct(new int[]{-2, 3, -4});
    }

    //两边
    public int maxProduct(int[] nums) {
        int[] product = new int[nums.length + 1];
        int max = 0;
        product[0] = 1;
        for (int i = 1; i < nums.length + 1; i++) {
            product[i] = product[i - 1] * nums[i - 1];
        }
        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = i + 1; j < nums.length + 1; j++) {
                max = Math.max(product[j] / product[i], max);
            }
        }
        return max;
    }
}
