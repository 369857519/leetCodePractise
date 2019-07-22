package categories.array;

public class SetMatrixZeros73 {

	public static void main(String[] args) {
		SetMatrixZeros73 setMatrixZeros73 = new SetMatrixZeros73();
		setMatrixZeros73.setZeroes(new int[][]{
			{1, 1, 1},
			{0, 1, 2},
			{0, 2, 3}
		});
	}

	public void setZeroes(int[][] matrix) {
		boolean firstRowBeZero = false;
		boolean firstColumnBeZero = false;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0 || j == 0) {
						if (i == 0) {
							firstRowBeZero = true;
						}
						if (j == 0) {
							firstColumnBeZero = true;
						}
					} else {
						matrix[0][j] = 0;
						matrix[i][0] = 0;
					}
				}
			}
		}

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[i].length - 1; j >= 0; j--) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
				if (i == 0 && firstRowBeZero) {
					matrix[0][j] = 0;
				}
			}
			if (firstColumnBeZero) {
				matrix[i][0] = 0;
			}
		}

//		System.out.println();
	}
}
