package categories.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by 祁连山 on 2019/5/29.
 */
public class ShortestSubArraySumAtLeastK862 {
    public int shortestSubarray(int[] A, int K) {
        int[] sum = new int[A.length + 1];
        sum[0] = 0;
        for (int i = 0; i < A.length; i++) {
            sum[i + 1] = A[i] + sum[i];
        }
        int min = -1;
        //缓存一下和为sum[i]-K的所有sum，并进行排序，然后二分查找
        Map<Integer,List<Integer>> map= new HashMap<>();

        for (int i = 0; i < sum.length; i++) {
            int j=0;
                if (sum[i] - sum[j] >= K) {
                    if (min == -1) {
                        min = i - j;
                    } else {
                        min = Math.min(min, i - j);
                    }
                }
        }
        return min;
    }
}
