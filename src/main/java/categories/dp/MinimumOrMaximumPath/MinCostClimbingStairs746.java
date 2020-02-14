package categories.dp.MinimumOrMaximumPath;

public class MinCostClimbingStairs746 {

	public static void main(String[] args) {
		MinCostClimbingStairs746 minCostClimbingStairs746 = new MinCostClimbingStairs746();
		minCostClimbingStairs746.minCostClimbingStairs(new int[]{0, 0, 0, 1});
	}

	public int minCostClimbingStairs(int[] cost) {
		if (cost.length == 0) {
			return 0;
		}
		if (cost.length == 1) {
			return cost[0];
		}
		int[] memoize = new int[cost.length];
		memoize[0] = cost[0];
		memoize[1] = cost[1];
		for (int i = 2; i < memoize.length; i++) {
			memoize[i] = Math.min(memoize[i - 1], memoize[i - 2]) + cost[i];
		}
		return Math.min(memoize[cost.length - 1], memoize[cost.length - 2]);
	}

}
