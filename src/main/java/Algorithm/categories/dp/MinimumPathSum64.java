package Algorithm.categories.dp;

public class MinimumPathSum64 {

	public static void main(String[] args) {
		MinimumPathSum64 minimumPathSum64 = new MinimumPathSum64();
		minimumPathSum64.minPathSum(new int[][]{
			{1, 3, 1},
			{1, 5, 1},
			{4, 2, 1}
		});
	}

	public int minPathSum(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		for (int i = 1; i < grid.length; i++) {
			grid[i][0] = grid[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < grid[0].length; j++) {
			grid[0][j] = grid[0][j - 1] + grid[0][j];
		}
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}

}
