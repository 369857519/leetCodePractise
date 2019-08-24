package categories.search.dp;

public class Backpack125Lint {

	public static void main(String[] args) {
		Backpack125Lint backpack125Lint = new Backpack125Lint();
		int res = backpack125Lint.backPackII(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4});
		res = backpack125Lint.backPackII(1, new int[]{2, 3, 8}, new int[]{2, 5, 8});
	}

	public int backPackII(int m, int[] A, int[] V) {
		// write your code here
		return dp(m, A, V);
	}

	public int dp(int m, int[] A, int[] V) {
		int[] memoize = new int[m + 1];
		for (int i = 0; i < A.length; i++) {
			for (int j = memoize.length - 1; j > 0; j--) {
				int prevMem = j - A[i];
				if ((prevMem >= 0 && prevMem < memoize.length && memoize[prevMem] != 0) ||
					prevMem == 0) {
					memoize[j] = Math.max(memoize[prevMem] + V[i], memoize[j]);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < memoize.length; i++) {
			max = Math.max(memoize[i], max);
		}
		return max;
	}

	public int traverse(int[] A, int[] V, int m, int currentIndex, int currentAmount) {
		if (m < A[currentIndex]) {
			return 0;
		}
		int putIn = traverse(A, V, m - A[currentAmount], currentIndex + 1,
			currentAmount) + V[currentIndex];
		int dontPutIn = traverse(A, V, m, currentIndex + 1, currentAmount);
		return Math.max(putIn, dontPutIn);
	}

}
