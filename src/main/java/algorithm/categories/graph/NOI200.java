package algorithm.categories.graph;

import java.util.Arrays;

/**
 * Created by 祁连山 on 2019/4/14.
 */
public class NOI200 {
    public static void main(String[] args) {
        char[][] map = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        NOI200 noi200 = new NOI200();
        noi200.numIslands(map);
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;
        //是否遍历过
        int[][] visited = new int[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    visited[i][j] = 1;
                    traverseIsland(grid, i, j, visited);
                    System.out.println(Arrays.deepToString(visited));
                    count++;
                }
            }
        }
        return count;
    }

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void traverseIsland(char[][] grid, int i, int j, int[][] visited) {
        for (int[] direction : directions) {
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            if (nextI >= 0 && nextI < grid.length && nextJ >= 0
                    && nextJ < grid[0].length && visited[nextI][nextJ] == 0 && grid[nextI][nextJ] == '1') {
                visited[nextI][nextJ] = 1;
                traverseIsland(grid, nextI, nextJ, visited);
            }
        }
    }
}
