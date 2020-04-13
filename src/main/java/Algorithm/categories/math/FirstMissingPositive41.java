package Algorithm.categories.math;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive41 {

    public static void main(String[] args) {
        FirstMissingPositive41 firstMissingPositive41 = new FirstMissingPositive41();
        int res = firstMissingPositive41.firstMissingPositive(new int[]{1, 2, 0});
        res = firstMissingPositive41.firstMissingPositive(new int[]{3, 4, -1, 1});
        res = firstMissingPositive41.firstMissingPositive(new int[]{7, 8, 9, 11, 12});
    }

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int firstMissing = 1;
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                firstMissing = i;
                break;
            }
        }
        return firstMissing;
    }

}
