package categories.math;

public class Divide29 {

	public static void main(String[] args) {
		Divide29 divide29 = new Divide29();
		int a = divide29.add(Integer.MAX_VALUE, 1);
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
		while (b != 0) {
			if ((b & 1) == 1) {
				res = add(res, a << count);
			}
			count++;
			b = b >> 1;
		}
		return res;
	}

	public int divide(int dividend, int divisor) {
		if (dividend == 0 || divisor == 1) {
			return dividend;
		}
		if (divisor == -1) {
			return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
		}
		boolean neg = (dividend > 0) ^ (divisor > 0);
		if (dividend < 0) {
			dividend = -dividend;
		}
		if (divisor < 0) {
			divisor = -divisor;
		}
		if (dividend < divisor) {
			return 0;
		}

		int msb;
		for (msb = 0; msb < 32; msb++) {
			if ((divisor << msb) > dividend) {
				break;
			}
		}

		int q = 0;
		for (int i = msb; i >= 0; i--) {
			if ((divisor << i) > dividend) {
				continue;
			}
			q |= (1 << i);
			dividend -= (divisor << i);
		}
		if (neg) {
			return -q;
		}
		return q;
	}
}
