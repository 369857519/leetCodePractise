package algorithm.categories.math;

public class myAtoi8 {
    public int myAtoi(String str) {
        int res = 0, i = 0, sign = 1;
        char[] cs = str.toCharArray();
        int threshold = Integer.MAX_VALUE;

        if (cs.length == 0) {
            return 0;
        }

        while (i < cs.length && cs[i] == ' ') {
            i++;
        }
        if (i < cs.length && cs[i] == '+' || cs[i] == '-') {
            sign = cs[i++] == '-' ? -1 : 1;
        }
        while (i < cs.length && cs[i] >= '0' && cs[i] <= '9') {
            //最后一位如果大于7，则发生了溢出，进行处理
            //2147483647
            if (res > threshold || (res == threshold && (cs[i] - '0') > 7)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + (cs[i]++ - '0');
        }
        return res * sign;
    }
}
