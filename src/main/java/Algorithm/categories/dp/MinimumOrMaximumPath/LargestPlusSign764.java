package Algorithm.categories.dp.MinimumOrMaximumPath;

public class LargestPlusSign764 {

	public static void main(String[] args) {
		LargestPlusSign764 largestPlusSign764 = new LargestPlusSign764();
		int res = largestPlusSign764.orderOfLargestPlusSign(5, new int[][]{{4, 2}});
		res = largestPlusSign764.orderOfLargestPlusSign(2, new int[][]{});
		res = largestPlusSign764.orderOfLargestPlusSign(2, new int[][]{{0, 0}, {0, 1}, {1, 0}});
		res = largestPlusSign764.orderOfLargestPlusSign(5, new int[][]{{3, 0}, {3, 3}});
	}

	public int orderOfLargestPlusSign(int N, int[][] mines) {
		int[][] map = new int[N][N];
		int[][] leftStatus = new int[N][N];
		int[][] topStatus = new int[N][N];
		int[][] rightStatus = new int[N][N];
		int[][] bottomStatus = new int[N][N];
		int[][] finalStatus = new int[N][N];
		int max = 0;

		//初始化
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 1;
			}
		}
		for (int i = 0; i < mines.length; i++) {
			map[mines[i][0]][mines[i][1]] = 0;
		}

		//计算左下的dp
		for (int i = 0; i < N; i++) {
			leftStatus[0][i] = map[0][i];
			leftStatus[i][0] = map[i][0];
			topStatus[0][i] = map[0][i];
			topStatus[i][0] = map[i][0];
			finalStatus[0][i] = map[0][i];
			finalStatus[i][0] = map[i][0];
			max = Math.max(max, Math.max(map[i][0], map[0][i]));
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 0) {
					leftStatus[i][j] = 0;
					topStatus[i][j] = 0;
				} else {
					leftStatus[i][j] = leftStatus[i][j - 1] + 1;
					topStatus[i][j] = topStatus[i - 1][j] + 1;
				}
				finalStatus[i][j] = Math.min(leftStatus[i][j], topStatus[i][j]);
			}
		}

		//计算右上的dp
		for (int i = 0; i < N; i++) {
			rightStatus[N - 1][i] = map[N - 1][i];
			rightStatus[i][N - 1] = map[i][N - 1];
			bottomStatus[N - 1][i] = map[N - 1][i];
			bottomStatus[i][N - 1] = map[i][N - 1];
			finalStatus[N - 1][i] = map[N - 1][i];
			finalStatus[i][N - 1] = map[i][N - 1];
			max = Math.max(max, Math.max(map[i][N - 1], map[N - 1][i]));
		}
		for (int i = N - 2; i >= 0; i--) {
			for (int j = N - 2; j >= 0; j--) {
				if (map[i][j] == 0) {
					rightStatus[i][j] = 0;
					rightStatus[i][j] = 0;
				} else {
					rightStatus[i][j] = rightStatus[i][j + 1] + 1;
					bottomStatus[i][j] = bottomStatus[i + 1][j] + 1;
				}
				int rightBottom = Math.min(rightStatus[i][j], bottomStatus[i][j]);
				finalStatus[i][j] = Math.min(rightBottom, finalStatus[i][j]);
				max = Math.max(finalStatus[i][j], max);
			}
		}
		return max;
	}
}
