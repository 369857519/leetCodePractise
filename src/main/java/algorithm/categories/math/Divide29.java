package algorithm.categories.math;

public class Divide29 {

	public static void main(String[] args) {
		Divide29 divide29 = new Divide29();
		int a = divide29.add(11, 1);
		int b = divide29.multiply(3, 100);
		int c = divide29.divide(10, -3);
		int d = divide29.divide(2147483647, 2);


	}

	//a^b 异或：获得本轮计算中，不进位的所有位
	//a&b 与：获得本轮计算中，进位的所有位
	//(a&b)<<1 左移即可得到这些位在下一轮计算中的位置
	//如果进位不为0，递归加一次，如果为0，返回a^b
	public int add(int a, int b) {
		int left = a ^ b;
		int right = (a & b) << 1;
		if (right != 0) {
			return add(left, right);
		} else {
			return left;
		}
	}

	//~(b-1) = -b
	public int minus(int a, int b) {
		return add(a, add(~b, 1));
	}

	/*
   1011
*  1010
--------
  10110 (1011<<1,相当于乘以0010)
1011000 (1011<<3,相当于乘以1000)
--------
1101110
	 */
	public int multiply(int a, int b) {
		int res = 0;
		int count = 0;
		while (a != 0) {
			if ((a & 1) == 1) {
				res += b << count;
			}
			a = a >> 1;
			count++;
		}
		return res;
	}

	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		boolean isSameSign = (dividend < 0) == (divisor < 0);
		int res = divideHelper(-Math.abs(dividend), -Math.abs(divisor));
		return isSameSign ? res : -res;
	}

	private int divideHelper(int dividend, int divisor) {
		int res = 0;
		int currentDivisor = divisor;
		while (dividend <= divisor) {
			int temp = 0;
			while ((currentDivisor << 1) >= dividend && (currentDivisor << 1) > 0) {
				temp <<= 1;
				currentDivisor <<= 1;
			}
			dividend -= currentDivisor;
			res += temp;
			currentDivisor = divisor;
		}
		return res;
	}

}
