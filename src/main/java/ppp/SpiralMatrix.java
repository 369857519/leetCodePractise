package ppp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
		spiralMatrix.spiralOrder(new int[][]{
			{1}
		});

	}

	//右下左上
	int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new ArrayList<>();
		}
		int hashBase = matrix[0].length;
		List<Integer> resList = new ArrayList<>();
		Set<Integer> viewedSet = new HashSet<>();
		int x = 0, y = 0, currentDirection = 0;
		while (resList.size() < matrix.length * matrix[0].length) {
			//添加本次足迹
			resList.add(matrix[x][y]);
			int hash = deHash(x, y, hashBase);
			viewedSet.add(hash);

			//判断下一次足迹以及方向
			int nextX = x + directions[currentDirection][0];
			int nextY = y + directions[currentDirection][1];
			//如果已经该换方向了
			if (viewedSet.contains(deHash(nextX, nextY, hashBase))
				|| nextX < 0 || nextX > matrix.length - 1
				|| nextY < 0 || nextY > matrix[0].length - 1) {
				currentDirection = (currentDirection + 1) % 4;
			}
			x = x + directions[currentDirection][0];
			y = y + directions[currentDirection][1];
		}
		return resList;
	}

	public int deHash(int x, int y, int decimal) {
		return x * decimal + y;
	}
}
