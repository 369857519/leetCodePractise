package algorithm.categories.binarySearch;

public class KthInMulTable668 {

	public static void main(String[] args) {
		KthInMulTable668 kthInMulTable668 = new KthInMulTable668();
		int res = 0;
		for (int i = 0; i < 10; i++) {
			res = kthInMulTable668.findKthNumber(3, 3, i);
		}
	}

	public int findKthNumber(int m, int n, int k) {
		int l = 1, h = m * n;
		while (l < h) {
			int mid = l + h >>> 1;
			int count = getCountLessOrEqual(m, n, mid);
			if (k > count) {
				l = mid + 1;
			} else {
				h = mid;
			}
		}
		return l;
	}

	public int getCountLessOrEqual(int m, int n, int midVal) {
		int i = m, j = 1;
		int res = 0;
		while (i >= 0 && j <= n) {
			int cur = i * j;
			if (cur > midVal) {
				i--;
			} else {
				res += i;
				j++;
			}
		}
		return res;
	}
}
