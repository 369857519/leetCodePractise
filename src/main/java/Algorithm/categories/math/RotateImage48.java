package Algorithm.categories.math;

public class RotateImage48 {

	/***
	 * Given input matrix =
	 * [
	 *   [1,2,3],
	 *   [4,5,6],
	 *   [7,8,9]
	 * ],
	 *
	 * rotate the input matrix in-place such that it becomes:
	 * [
	 *   [7,4,1],
	 *   [8,5,2],
	 *   [9,6,3]
	 * ]
	 * @param
	 */

	public static void main(String[] args) {
		int[][] matrix = {
			{1, 2, 3, 4,5},
			{4, 5, 6, 7,6},
			{5, 6, 7, 8,7},
			{9, 10, 11, 12,}
		};
		RotateImage48 rotateImage48 = new RotateImage48();
		rotateImage48.rotate(matrix);
	}

	public void rotate(int[][] matrix) {
		int n = matrix.length - 1;
		int startIndex = 0;
		while (n > startIndex) {
			//层内的旋转
			for (int i = startIndex; i < n; i++) {
				int temp = matrix[i][startIndex];
				matrix[i][startIndex] = matrix[n][i];
				matrix[n][i] = matrix[n - i + startIndex][n];
				matrix[n - i + startIndex][n] = matrix[startIndex][n - i + startIndex];
				matrix[startIndex][n - i + startIndex] = temp;
			}
			n -= 1;
			startIndex += 1;
		}

	}
}
