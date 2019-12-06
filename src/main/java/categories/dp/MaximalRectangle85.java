package categories.dp;

public class MaximalRectangle85 {

	public static void main(String[] args) {
		MaximalRectangle85 maximalRectangle85 = new MaximalRectangle85();
		maximalRectangle85.maximalRectangle(new char[][]{
			{'1', '0', '1', '0', '0'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '0', '1', '0'}
		});
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int[][] leftCount = new int[matrix.length + 1][matrix[0].length + 1];
		int[][] topCount = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					int memi = i + 1;
					int memj = j + 1;
					//如何选左边的值，新增的一行和上面一行的matrix值比大小
					leftCount[memi][memj] = leftCount[memi][memj - 1] + 1;
					topCount[memi][memj] = topCount[memi - 1][memj] + 1;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {

			}
		}

		return res;
	}
}
