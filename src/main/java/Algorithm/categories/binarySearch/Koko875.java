package Algorithm.categories.binarySearch;

public class Koko875 {

	public static void main(String[] args) {
		Koko875 koko875 = new Koko875();
		int res = koko875.minEatingSpeed(new int[]{3, 5, 7, 11}, 8);
		res = koko875.minEatingSpeed(new int[]{8}, 1);
		res = koko875.minEatingSpeed(new int[]{1}, 0);
	}

	public int minEatingSpeed(int[] piles, int H) {
		if (piles.length == 0) {
			return 0;
		}
		int h = 0;
		for (int i = 0; i < piles.length; i++) {
			h = Math.max(piles[i], h);
		}
		int l = 0;
		while (l < h) {
			int mid = l + h >>> 1;
			int count = getCount(piles, mid);
			if (count > H) {
				l = mid + 1;
			} else {
				h = mid;
			}
		}
		return l;
	}

	public int getCount(int[] piles, int eat) {
		int count = 0;
		for (int i = 0; i < piles.length; i++) {
			count += Math.ceil(piles[i] * 1.0 / eat);
		}
		return count;
	}
}
