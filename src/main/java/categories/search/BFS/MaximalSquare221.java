package categories.search.BFS;

import Utils.ArrayUtil;

public class MaximalSquare221 {

	public static void main(String[] args) {
		MaximalSquare221 maximalSquare221 = new MaximalSquare221();
		int res = maximalSquare221.maximalSquare(new char[][]{
			{'1', '0', '1', '0', '0'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '1', '1', '1'}
		});
		res = maximalSquare221.maximalSquare(new char[][]{
			{'1', '0', '1', '0', '0'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '0', '1', '0'}
		});
		res = maximalSquare221.maximalSquare(new char[][]{
			{'1', '0', '1', '0', '0'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '0', '1', '0'}});
		res = maximalSquare221.maximalSquare(new char[][]{
			{'0', '0', '0', '1', '0', '1', '1', '1'},
			{'0', '1', '1', '0', '0', '1', '0', '1'},
			{'1', '0', '1', '1', '1', '1', '0', '1'},
			{'0', '0', '0', '1', '0', '0', '0', '0'},
			{'0', '0', '1', '0', '0', '0', '1', '0'},
			{'1', '1', '1', '0', '0', '1', '1', '1'},
			{'1', '0', '0', '1', '1', '0', '0', '1'},
			{'0', '1', '0', '0', '1', '1', '0', '0'},
			{'1', '0', '0', '1', '0', '0', '0', '0'}}
		);
		res = maximalSquare221.maximalSquare(new char[][]{{}});
		res = maximalSquare221.maximalSquare(new char[][]{{'1', '0'}});
	}

	public int maximalSquare(char[][] matrix) {
		int res = 0;
		if (matrix.length == 0) {
			return 0;
		}
		int[] memoize = new int[matrix.length + 1];
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					if (i - 1 < 0 || j - 1 < 0) {
						matrix[i][j] = 1;
					} else {
						memoize[i] =0;
					}
				} else {
					memoize[i] = 0;
				}
			}
		}
		return 0;
	}

	public int maximalSquareWithOMNSpace(char[][] matrix) {
		int res = 0;
		if (matrix.length == 0) {
			return 0;
		}
		int[][] memoize = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					if (i - 1 < 0 || j - 1 < 0) {
						memoize[i][j] = 1;
					} else {
						memoize[i][j] = Math.min(memoize[i - 1][j - 1],
							Math.min(memoize[i - 1][j], memoize[i][j - 1])) + 1;
					}
					res = Math.max(res, memoize[i][j]);
					ArrayUtil.printArr(memoize);
				}
			}
		}
		return res * res;
	}

	public int maximalSquareBruteForce(char[][] matrix) {
		//左上角遍历
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					res = Math.max(res, leftTopConnerCount(matrix, i, j));
				}
			}
		}
		return res;
	}

	public int leftTopConnerCount(char[][] matrix, int i, int j) {
		int q = 0;
		while (true) {
			q++;
			boolean currentRound = true;
			for (int count = 0; count <= q; count++) {
				if (j + count == matrix[0].length || i + count == matrix.length
					|| q + i == matrix.length || q + j == matrix[0].length
					|| matrix[i + q][j + count] == '0' || matrix[i + count][j + q] == '0') {
					q--;
					currentRound = false;
					break;
				}
			}
			if (!currentRound) {
				break;
			}
		}
		q += 1;
		return q * q;
	}
}
