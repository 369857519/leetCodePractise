package categories.array;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AverageArray {

    public static void main(String[] args) {
        //处理不为0的情况
        AverageArray averageArray = new AverageArray();
        averageArray.rearrange(new int[]{502, 2, 22, 5});
        averageArray.rearrange(new int[]{500, 2, 22, 4, 22, 11, 2, 500});
        AtomicStampedReference<Integer> integerAtomicReference=new AtomicStampedReference<>(1,1);
        integerAtomicReference.compareAndSet(1,2,1,2);
    }

    public void rearrange(int[] array) {
        int average = 0;
        for (int i = 0; i < array.length; i++) {
            average += array[i];
        }
        //误差值处理，分析：如果有误差，每个盘子堆的误差不会超过1，范围应该为average.floor<=finalValue<=average.ceil
        int errorValue = average % array.length;
        average = average / array.length;

        int lastBiggerIndex = 0;
        int lastSmallerIndex = 0;

        for (int i = 0; i < array.length; i++) {
            //i必须要分出的情况
            while (array[i] > average && lastSmallerIndex < array.length) {
                //lastBigger必须要分出的情况
                while (lastSmallerIndex < array.length && array[lastSmallerIndex] >= average) {
                    lastSmallerIndex++;
                }
                move(array, i, lastSmallerIndex, average);
            }

            //i必须要分入的情况
            while (array[i] < average && lastBiggerIndex < array.length) {
                while (lastBiggerIndex < array.length && array[lastBiggerIndex] <= average) {
                    lastBiggerIndex++;
                }
                move(array, lastBiggerIndex, i, average);
            }
        }
        //抹平误差
        if (errorValue > 0) {
            lastSmallerIndex = 0;
            for (int i = 0; i < array.length; i++) {
                while (lastSmallerIndex < array.length && array[i] > average + 1) {
                    while (lastSmallerIndex < array.length
                        && array[lastSmallerIndex] >= average + 1) {
                        lastSmallerIndex++;
                    }
                    move(array, i, lastSmallerIndex, average + 1);
                }
            }
        }
    }

    public void move(int[] array, int bigger, int smaller, int average) {
        if (bigger >= array.length || smaller >= array.length) {
            return;
        }
        //开始挪动
        int num = Math.min(array[bigger] - average, average - array[smaller]);
        array[bigger] -= num;
        array[smaller] += num;
        System.out.println(bigger + "->" + smaller + ":" + num);
    }

}
