package Algorithm.categories.dp.MinimumOrMaximumPath;

public class CoinExchange322 {

    public static void main(String[] args) {
        CoinExchange322 coinExchange322 = new CoinExchange322();
        int min = coinExchange322.coinChange(new int[]{5, 5, 1}, 11);
        min = coinExchange322.coinChange(new int[]{3}, 2);
        min = coinExchange322.coinChange(new int[]{2}, 3);
    }

    public int coinChange(int[] coins, int amount) {
        int[] memoize = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            int tmp = -1;
            for (int c : coins) {
                if (i - c < 0 || memoize[i - c] < 0) {
                    continue;
                }
                if (tmp < 0) {
                    tmp = memoize[i - c] + 1;
                } else {
                    tmp = Math.min(tmp, memoize[i - c] + 1);
                }
            }
            memoize[i] = tmp;
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
