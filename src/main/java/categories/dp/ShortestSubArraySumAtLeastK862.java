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
		int[] sumMinusK = new int[A.length + 1];
		for(int i=0;i<A.length;i++){
			sumMinusK[i]=sumMinusK[i]-K;
		}
		int min = -1;
		//缓存一下和小于X的最大长度
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum.length; j++) {
				if (sum[i] - sum[j] >= K) {
					if (min == -1) {
						min = i - j;
					} else {
						min = Math.min(min, i - j);
					}
				}
			}
		}
		return min;
	}
}
