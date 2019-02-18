package ppp;

import java.util.HashSet;
import java.util.Set;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int[][] str = new int[][]{
			{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
			{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
			{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
		MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
		int res = maxAreaOfIsland.maxAreaOfIsland(str);
	}

	public int maxAreaOfIsland(int[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int max = 0;
		int[][] seen = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				max = Math.max(max, scan(grid, i, j, seen));
			}
		}
		return max;
	}

	private int scan(int[][] grid, int i, int j, int[][] stepRecord) {
		if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1
			|| grid[i][j] == 0 || stepRecord[i][j] == 1) {
			return 0;
		}
		int current = 1;
		stepRecord[i][j] = 1;
		current += scan(grid, i - 1, j, stepRecord);
		current += scan(grid, i + 1, j, stepRecord);
		current += scan(grid, i, j - 1, stepRecord);
		current += scan(grid, i, j + 1, stepRecord);
		return current;
	}
}
