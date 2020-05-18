package algorithm.categories.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralMatrix {

    /***
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     *
     * Input:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * @param args
     */
    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralOrder(new int[][]{{1}});
        spiralMatrix.spiralOrder(new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        });
        spiralMatrix.spiralOrder(new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
            {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
            {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
            {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
            {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
            {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
            {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}}
        );
    }

    //右下左上
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int len = matrix[0].length * matrix.length;
        Set<String> viewed = new HashSet<>();

        int currentDirection = 0;
        int x = 0;
        int y = 0;
        while (list.size() < len) {
            if (x < matrix.length && y < matrix[0].length && x >= 0 && y >= 0
                && view(x, y, viewed)) {
                list.add(matrix[x][y]);
            } else {
                x -= directions[currentDirection][0];
                y -= directions[currentDirection][1];
                currentDirection++;
                if (currentDirection > 3) {
                    currentDirection = 0;
                }
            }
            x += directions[currentDirection][0];
            y += directions[currentDirection][1];
        }
        return list;
    }

    public boolean view(int x, int y, Set<String> viewed) {
        String hash = x + "," + y;
        if (viewed.contains(hash)) {
            return false;
        } else {
            viewed.add(hash);
            return true;
        }
    }
}
