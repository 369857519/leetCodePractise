package ppp;

public class FindPrime762 {

	public static void main(String[] args) {
		FindPrime762 findPrime762 = new FindPrime762();
		findPrime762.countPrimeSetBits(244, 269);
	}

	public int countPrimeSetBits(int L, int R) {
		int res = 0;
		for (int i = L; i <= R; i++) {
			int count = 0;
			int current = i;
			while (current != 0) {
				count++;
				current = current & (current - 1);
			}
			res += isPrime(count) ? 1 : 0;
		}
		return res;
	}

	public boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
