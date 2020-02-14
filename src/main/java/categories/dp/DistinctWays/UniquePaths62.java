package categories.dp.DistinctWays;

public class UniquePaths62 {

	public static void main(String[] args) {
		UniquePaths62 uniquePaths62 = new UniquePaths62();
		uniquePaths62.uniquePaths(2, 2);
	}

	public int uniquePaths(int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		}
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			matrix[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			matrix[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
			}
		}
		return matrix[m - 1][n - 1];
	}
}
