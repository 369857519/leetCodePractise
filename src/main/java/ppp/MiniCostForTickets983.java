package ppp;

import java.util.HashSet;
import java.util.Set;

public class MiniCostForTickets983 {

	public static void main(String[] args) {
		MiniCostForTickets983 miniCostForTickets983 = new MiniCostForTickets983();
		miniCostForTickets983.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
	}

	int[] days, costs;
	Integer[] memo;
	int[] durations = new int[]{1, 7, 30};

	public int mincostTickets(int[] days, int[] costs) {
		this.days=days;
		this.costs=costs;
		memo=new Integer[days.length];
		return dp(0);
	}

	//深度优先遍历，但是每次会把最底层的值做缓存，消除重复计算，因为在某天内的最小值是固定的。
	public int dp(int i) {
		if (i > days.length) {
			return 0;
		}
		if (memo[i] != null) {
			return memo[i];
		}
		int ans=Integer.MAX_VALUE;

		return ans;
	}
}
