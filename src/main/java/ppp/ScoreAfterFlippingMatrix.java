package ppp;

public class ScoreAfterFlippingMatrix {

	public int matrixScore(int[][] A) {
		int R = A.length;
		int C = A[0].length;
		int[] colCount = new int[C];
		for (int r = 0; r < R; ++r) {
			for (int c = 0; c < C; ++c) {
				colCount[c] += A[r][c] ^ A[r][0];
			}
		}
		int res = 0;
		for (int i = 0; i < colCount.length; i++) {
			res += Math.max(colCount[i], R - colCount[i]) * (1 << (colCount.length - i - 1));
		}
		return res;
	}
}
