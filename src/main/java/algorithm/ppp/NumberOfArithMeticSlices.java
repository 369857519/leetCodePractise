package algorithm.ppp;

public class NumberOfArithMeticSlices {

	public static void main(String[] args) {
		NumberOfArithMeticSlices numberOfArithMeticSlices = new NumberOfArithMeticSlices();
		numberOfArithMeticSlices.numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
	}

	public int numberOfArithmeticSlices(int[] A) {
		if (A.length < 3) {
			return 0;
		}
		int substract = A[1] - A[0];
		int res = 0;
		int count = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == substract) {
				count++;
				res += count;
			} else {
				count = 0;
			}
			substract = A[i] - A[i - 1];
		}
		return res;
	}
}
