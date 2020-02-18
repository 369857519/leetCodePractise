package categories.dp.DistinctWays;

public class NumberOfLongestSequence673 {

    public static void main(String[] args) {
        NumberOfLongestSequence673 numberOfLongestSequence673 = new NumberOfLongestSequence673();
        numberOfLongestSequence673.findNumberOfLIS(new int[]{1, 2, 4, 7, 5});
    }

    public int findNumberOfLIS(int[] nums) {
        return traverse(nums, 1, nums[0], 0);
    }

    public int traverse(int[] nums, int index, int lastBiggest, int count) {
        if (index == nums.length) {
            return count;
        }
        //choose
        int chooseThisNum = 0;
        if (nums[index] > lastBiggest) {
            chooseThisNum = traverse(nums, index + 1, nums[index], count + 1);
        }
        int notChooseNum = traverse(nums, index + 1, lastBiggest, count);
        return Math.max(chooseThisNum, notChooseNum);
    }

}
