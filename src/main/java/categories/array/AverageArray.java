package categories.array;

public class AverageArray {

    public static void main(String[] args) {
        //处理不为0的情况
        AverageArray averageArray = new AverageArray();
        averageArray.rearrange(new int[]{500, 2, 22, 5});
        averageArray.rearrange(new int[]{500, 2, 22, 4, 22, 11, 2, 500});

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
            //目前值的大于average,需要在之前中一些坑填进去
            while (array[i] > average) {
                //找到第一个小于average的
                while (array[lastSmallerIndex] >= average) {
                    lastSmallerIndex++;
                }

                errorValue = move(array, i, lastSmallerIndex, average, errorValue);
            }

            //目前的值小于average，需要在前面找一些大于average的填过来
            while (array[i] < average) {
                while (array[lastBiggerIndex] <= average) {
                    lastBiggerIndex++;
                }
                errorValue = move(array, lastBiggerIndex, i, average, errorValue);
            }
        }
    }

    public int move(int[] array, int bigger, int smaller, int average, int errorValue) {
        //优先解决errorValue
        if (errorValue != 0 && array[bigger] > average + 1) {
            average++;
            errorValue--;
        }
        int num = Math.min(array[bigger] - average, average - array[smaller]);
        array[bigger] -= num;
        array[smaller] += num;
        System.out.println(bigger + "->" + smaller + ":" + num);
        return errorValue;
    }

}
