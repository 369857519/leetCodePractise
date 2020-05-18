package algorithm.categories.math;

import java.util.Stack;

public class Pow50 {

	public static void main(String[] args) {
		Pow50 pow50 = new Pow50();
		Double res = pow50.myPow(2, -2147483648);
	}

	public double myPow(double x, int n) {
		if (n == 0 || x == 1.0) {
			return 1;
		}
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}

		Stack<Double> restStk = new Stack<>();
		while (n != 0) {
			if (n % 2 != 0) {
				restStk.push(x);
			} else {
				restStk.push(1.0);
			}
			n = n / 2;
		}
		Double res = 1.0;
		while (!restStk.empty()) {
			res = res * res * restStk.pop();
		}
		return res;
	}
}
