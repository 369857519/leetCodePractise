package Algorithm.categories.dp.MinimumOrMaximumPath;

public class DungeonGame174DP {

	public static void main(String[] args) {
		DungeonGame174DP dungeonGame174 = new DungeonGame174DP();
//		int res = dungeonGame174.calculateMinimumHP(new int[][]{
//			{3, 0, -3},
//			{-3, -2, -2},
//			{3, 1, -5}
//		});

		int res = dungeonGame174.calculateMinimumHP(new int[][]{
			{-2, -3, 3},
			{-5, -10, 1},
			{10, 30, -5}
		});

		res = dungeonGame174.calculateMinimumHP(new int[][]{
			{-3, 5}
		});
	}

	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			dp[i][n] = Integer.MIN_VALUE;
		}
		for (int i = 0; i <= n; i++) {
			dp[m][i] = Integer.MIN_VALUE;
		}
		dp[m][n - 1] = 1;
		dp[m - 1][n] = 1;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int minToNext = Math.min(dp[i][j + 1], dp[i + 1][j]);

				if (dungeon[i][j] >= minToNext) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = minToNext - dungeon[i][j];
				}
			}
		}

		return dp[0][0];
	}
}
