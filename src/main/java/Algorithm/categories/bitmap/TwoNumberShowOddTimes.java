package Algorithm.categories.bitmap;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.IntBinaryOperator;

public class TwoNumberShowOddTimes {

    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        atomicIntegerArray.accumulateAndGet(4, 10, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
    }

    //一个有两个数字出现了奇数次，其它数字出现了偶数次
    public int[] showNumber(int[] array) {
        int res = array[0];
        for (int i = 0; i < array.length; i++) {
            res ^= res;
        }
        //res 为两个奇数次的数字异或后留下的位
        return new int[2];
    }
}
