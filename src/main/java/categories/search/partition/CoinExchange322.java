package categories.search.partition;

public class CoinExchange322 {

	public static void main(String[] args) {
		CoinExchange322 coinExchange322 = new CoinExchange322();
		coinExchange322.coinChange(new int[]{5, 5, 1}, 10);
	}

	public int coinChange(int[] coins, int amount) {
		int[] memoize = new int[amount + 1];
		for (int i = 0; i < coins.length; i++) {
			memoize[coins[i]] = 1;
		}
		for (int i = 1; i < memoize.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				int prevIndex = i - coins[j];
				if (prevIndex >= 0 && prevIndex < memoize.length && memoize[prevIndex] > 0) {
					memoize[i] = Math.min(memoize[prevIndex], min);
				}
			}
			memoize[i] = min;
		}
		if (memoize[amount] == 0) {
			return -1;
		}
		return memoize[amount];
	}
}
