package categories.binarySearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 祁连山 on 2019/5/19.
 */
public class DungeonGame174 {

	public static void main(String[] args) {
		DungeonGame174 dungeonGame174 = new DungeonGame174();
		int res = dungeonGame174.calculateMinimumHP(new int[][]{
			{3, 0, -3},
			{-3, -2, -2},
			{3, 1, -5}
		});

		res = dungeonGame174.calculateMinimumHP(new int[][]{
			{-2, -3, 3},
			{-5, -10, 1},
			{10, 30, -5}
		});

		res = dungeonGame174.calculateMinimumHP(new int[][]{
			{-3,5}
		});
	}


	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		if (m == 0) {
			return 1;
		}
		int n = dungeon[0].length;
		if (n == 0) {
			return 1;
		}
		int min = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int k = dungeon[i][j];
				if (k < 0) {
					min += k;
				}
			}
		}
		int l = 1, h = Math.abs(min) + 1;
		while (l < h) {
			int mid = l + h >>> 1;
			if (traverse(mid, dungeon, new int[m][n], m, n)) {
				h = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	public boolean traverse(int initial, int[][] grid, int[][] record, int m, int n) {
		//初始化
		int[][] dir = new int[][]{{0, 1}, {1, 0}};
		Queue<Integer[]> queue = new LinkedList<>();
		queue.offer(new Integer[]{0, 0});
		record[0][0] = grid[0][0] + initial;
		if(record[0][0]<=0)return false;
		//开始遍历
		while (!queue.isEmpty()) {
			Integer[] currentPosition = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int nx = dir[i][0] + currentPosition[0];
				int ny = dir[i][1] + currentPosition[1];
				if (nx < m && ny < n) {
					int nextRecord = record[nx][ny];
					int newNexRecord =
						record[currentPosition[0]][currentPosition[1]] + grid[nx][ny];
					if (newNexRecord > nextRecord) {
						record[nx][ny] = newNexRecord;
						queue.offer(new Integer[]{nx, ny});
						if (nx == m - 1 && ny == n - 1 && newNexRecord > 0) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
