package categories.search.partition;

public class Backpack125Lint {

	public int backPackII(int m, int[] A, int[] V) {
		// write your code here
		return dp(m, A, V);
	}

	public int dp(int m, int[] A, int[] V) {
		int[] memoize = new int[m + 1];
		for (int i = 0; i < memoize.length; i++) {
			for (int j = 0; i < A.length; j++) {
				int prevIndex = memoize[i] - A[j];
				if (prevIndex >= 0 && prevIndex < memoize[i]) {
					memoize[i] = Math.max(memoize[prevIndex] + V[j], memoize[i]);
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
