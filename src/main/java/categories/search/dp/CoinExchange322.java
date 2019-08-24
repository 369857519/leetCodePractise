package categories.search.dp;

public class CoinExchange322 {

	public static void main(String[] args) {
		CoinExchange322 coinExchange322 = new CoinExchange322();
		int min = coinExchange322.coinChangeTraverse(new int[]{5, 5, 1}, 11);
		min = coinExchange322.coinChange(new int[]{3}, 2);
		min = coinExchange322.coinChange(new int[]{2}, 3);
	}

	public int coinChange(int[] coins, int amount) {
		int[] memoize = new int[amount + 1];
		for (int i = 1; i < memoize.length; i++) {
			memoize[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i < memoize.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				int prevIndex = i - coins[j];
				if (prevIndex >= 0 && prevIndex < memoize.length) {
					memoize[i] = Math.min(
						(memoize[prevIndex] == Integer.MAX_VALUE ? Integer.MAX_VALUE
							: memoize[prevIndex] + 1), memoize[i]);
				}
			}
		}
		if (memoize[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		return memoize[amount];
	}

	public int coinChangeTraverse(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return 1;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			min = Math.min(min, coinChangeTraverse(coins, amount - coins[i]));
		}
		return min + 1;
	}
}
