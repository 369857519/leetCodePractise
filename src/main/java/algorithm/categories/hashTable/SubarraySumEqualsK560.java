package algorithm.categories.hashTable;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK560 {

    public static void main(String[] args) {
        SubarraySumEqualsK560 subarraySumEqualsK560 = new SubarraySumEqualsK560();
        subarraySumEqualsK560.subarraySum(new int[]{-1, -1, 1}, 0);
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
            int target = -(k - sum);
            if (sumCount.get(target) != null) {
                count += sumCount.get(target);
            }
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
