package categories.dp;

import Utils.ArrayPrintUtil;
import java.util.HashSet;
import java.util.Set;

public class LastStoneWeightII1049 {

    public static void main(String[] args) {
        LastStoneWeightII1049 lastStoneWeightII1049 = new LastStoneWeightII1049();
        int res = lastStoneWeightII1049.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
        res = lastStoneWeightII1049.lastStoneWeightII(new int[]{2, 3, 5});
        res = lastStoneWeightII1049.lastStoneWeightII(new int[]{1, 5});
        res = lastStoneWeightII1049.lastStoneWeightII(new int[]{1});
    }

    private int res = Integer.MAX_VALUE;

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[][] dp = new int[stones.length + 1][target + 1];
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < stones[i - 1]) {
                    //放不进去，则直接取上一个值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //放或者不放的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
            ArrayPrintUtil.printArr(dp);
        }
        int max = 0;
        for (int count : dp[stones.length]) {
            max = Math.max(max, count);
        }
        return Math.abs(sum - dp[stones.length][target] * 2);

    }

    public int lastStoneWeightIIWithSearch(int[] stones) {
        search(stones, 0, new HashSet<>());
        return res;
    }

    public void search(int[] stones, int lastValue, Set<Integer> choosed) {
        if (choosed.size() == stones.length) {
            res = Math.min(res, lastValue);
        }
        for (int i = 0; i < stones.length; i++) {
            if (!choosed.contains(i)) {
                choosed.add(i);
                if (stones[i] == lastValue) {
                    lastValue = 0;
                } else {
                    lastValue = Math.abs(stones[i] - lastValue);
                }
                search(stones, lastValue, choosed);
                choosed.remove(i);
            }
        }
    }

}
