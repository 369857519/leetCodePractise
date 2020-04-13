package Algorithm.categories.string;

public class StringToInt8 {

	public static void main(String[] args) {
		StringToInt8 stringToInt8 = new StringToInt8();
		int res = stringToInt8.myAtoi("100");
		res = stringToInt8.myAtoi("-2398943");
		res = stringToInt8.myAtoi(String.valueOf(Integer.MAX_VALUE + 1));
		res = stringToInt8.myAtoi("4193 with words");
		res = stringToInt8.myAtoi("jlkjkljl 4193 with words");
		res = stringToInt8.myAtoi("-91283472332");

	}

	//1 跳过空格
	//2 + -
	//3 减掉非数字位
	//4 溢出
	//5 next_value=olde_digits*10+next_int
	public int myAtoi(String str) {
		int res = 0, i = 0, sign = 1;
		char[] cs = str.toCharArray();
		int threshold = Integer.MAX_VALUE / 10;

		if (cs.length == 0) {
			return 0;
		}

		while (i < cs.length && cs[i] == ' ') {
			i++;
		}

		if (i < cs.length && (cs[i] == '+' || cs[i] == '-')) {
			sign = 1 - 2 * (cs[i++] == '-' ? 1 : 0);
		}

		while (i < cs.length && cs[i] >= '0' && cs[i] <= '9') {
			//前n-1位比threshold大；前n-1等于threshold且左右以为大于7
			//反向遍历，用MAX_VALUE/10作为临界值，进行比较
			if (res > threshold || (res == threshold && (cs[i] - '0') > 7)) {
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			res = res * 10 + (cs[i++] - '0');
		}

		return res * sign;
	}
}
