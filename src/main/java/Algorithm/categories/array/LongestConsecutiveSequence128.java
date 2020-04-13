package Algorithm.categories.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {

    public static void main(String[] args) {
        LongestConsecutiveSequence128 longestConsecutiveSequence128 = new LongestConsecutiveSequence128();
        longestConsecutiveSequence128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }
        int resCont = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numsSet.contains(nums[i])) {
                int count = 1;
                int cur = nums[i] + 1;
                while (numsSet.contains(cur)) {
                    numsSet.remove(cur++);
                    count++;
                }
                cur = nums[i] - 1;
                while (numsSet.contains(cur)) {
                    numsSet.remove(cur--);
                    count++;
                }
                resCont = Math.max(resCont, count);
            }
        }
        return resCont;
    }

}
