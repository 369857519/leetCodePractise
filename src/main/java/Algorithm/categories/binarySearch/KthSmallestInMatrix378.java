package Algorithm.categories.binarySearch;

public class KthSmallestInMatrix378 {

	public static void main(String[] args) {
		KthSmallestInMatrix378 kthSmallestInMatrix378 = new KthSmallestInMatrix378();
		int res = 0;
		for (int i = 0; i < 11; i++) {
			res = kthSmallestInMatrix378.kthSmallest(new int[][]{
				{1, 2, 3},
				{2, 3, 4},
				{4, 5, 6}
			}, i);
		}
	}


	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int l = matrix[0][0], h = matrix[n - 1][n - 1];
		while (l < h) {
			int mid = l + h >>> 1;
			int count = numLessEqual(matrix, mid);
			if (k > count) {
				l = mid + 1;
			} else {
				h = mid;
			}
		}
		return l;
	}

	public int numLessEqual(int[][] matrix, int val) {
		int res = 0;
		int n = matrix.length, i = n - 1, j = 0;
		while (i >= 0 && j < n) {
			if (matrix[i][j] > val) {
				i--;
			} else {
				res += i + 1;
				j++;
			}
		}
		return res;
	}


}
