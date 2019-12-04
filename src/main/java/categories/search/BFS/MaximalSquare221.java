package categories.search.BFS;

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
