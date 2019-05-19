package categories.BinarySearch;

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
    }

    private int m = 0;
    private int n = 0;

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        if (m == 0) {
            return 1;
        }
        n = dungeon[0].length;
        if (n == 0) {
            return 1;
        }
        int min = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = dungeon[i][j];
                if (k < 0) min += k;
            }
        }
        int l = 1, h = Math.abs(min) + 1;
        while (l < h) {
            int mid = l + h >>> 1;
            if (traverse(mid, dungeon, new int[m][n], 0, 0)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int[][] dir = new int[][]{{0, 1}, {1, 0}};

    public boolean traverse(int currentVal, int[][] grid, int[][] record, int x, int y) {
        currentVal += grid[x][y];
        if (currentVal > 0 && currentVal > record[x][y]) {
            record[x][y] = currentVal;
            if (x == m - 1 && y == n - 1 && currentVal > 0) {
                return true;
            }
            boolean res = false;
            for (int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if ((nx < m && ny < n) &&
                        traverse(currentVal, grid, record, nx, ny)) {
                    res = true;
                }
            }
            return res;
        }
        return false;
    }
}
