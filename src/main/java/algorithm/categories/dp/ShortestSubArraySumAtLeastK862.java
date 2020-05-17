package algorithm.categories.dp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by 祁连山 on 2019/5/29.
 */
public class ShortestSubArraySumAtLeastK862 {

	public static void main(String[] args) {
		ShortestSubArraySumAtLeastK862 shortestSubArraySumAtLeastK862 = new ShortestSubArraySumAtLeastK862();
		int res=shortestSubArraySumAtLeastK862.shortestSubarray(new int[]{2, -1, 2}, 3);
	}

	public int shortestSubarray(int[] A, int K) {
		int N = A.length;
		long[] P = new long[N + 1];
		for (int i = 0; i < N; ++i) {
			P[i + 1] = P[i] + (long) A[i];
		}

		int ans = N + 1;
		Deque<Integer> monoq = new LinkedList<>();
		for (int y = 0; y < P.length; ++y) {
			//如果P[y]<=P[monoq.getLast()]，则说明中间有负数，加过来肯定小于k，更新monoq为y
			//随着y的循环，检查上一项与本项的关系，能最小代价保持单调递增
			while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()]) {
				monoq.removeLast();
			}
			//检查是否合法，从
			while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K) {
				ans = Math.min(ans, y - monoq.removeFirst());
			}
			monoq.addLast(y);
		}
		return ans < N + 1 ? ans : -1;
	}
}
