package categories.BinarySearch;

/**
 * Created by 祁连山 on 2019/5/19.
 */
public class SwimInRisingWater778 {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}};
        SwimInRisingWater778 swimInRisingWater778 = new SwimInRisingWater778();
        swimInRisingWater778.swimInWater(input);
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = grid[n - 1][n - 1], h = n * n - 1;
        while (l < h) {
            int mid = l + h >>> 1;
            if (traverse(mid, grid, new int[n][n], 0, 0, n)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean traverse(int t, int[][] grid, int[][] visited, int x, int y, int n) {
        if (grid[x][y] <= t && visited[x][y] == 0) {
            visited[x][y] = 1;
            if (x == n - 1 && y == n - 1) {
                return true;
            }
            boolean res = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if ((nx >= 0 && nx < n && ny >= 0 && ny < n) &&
                        traverse(t, grid, visited, nx, ny, n)) {
                    res = true;
                }
            }
            return res;
        }
        return false;
    }
}
