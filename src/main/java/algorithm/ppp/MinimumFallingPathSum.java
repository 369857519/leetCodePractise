package algorithm.ppp;

import java.util.Arrays;

public class MinimumFallingPathSum {

	public static void main(String[] args) {
//		[[1,2,3],[4,5,6],[7,8,9]]
		MinimumFallingPathSum minimumFallingPathSum = new MinimumFallingPathSum();
		int a = minimumFallingPathSum.minFallingPathSum(new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		});
	}

	public int minFallingPathSum(int[][] A) {
		for (int i = 1; i < A[0].length; i++) {
			calNextLevel(A, i);
		}
		Arrays.sort(A[A.length - 1]);
		return A[A.length - 1][0];
	}

	//从何第二行开始，上一个最小的值
	public void calNextLevel(int[][] A, int n) {
		int column = A[0].length;
		for (int i = 0; i < column; i++) {
			int minOfLeaf = Integer.MAX_VALUE;
			for (int j = i - 1; j <= i + 1; j++) {
				if (j >= 0 && j < column) {
					minOfLeaf = Math.min(A[n - 1][j], minOfLeaf);
				}
			}
			A[n][i] += minOfLeaf;
		}
	}
}
