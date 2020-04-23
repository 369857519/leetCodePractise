package categories.bitmap;

public class TwoNumberShowOddTimes {

    public static void main(String[] args) {

    }

    //一个有两个数字出现了奇数次，其它数字出现了偶数次
    public int[] showNumber(int[] array){
        int res=array[0];
        for(int i=0;i<array.length;i++){
            res^=res;
        }
        //res 为两个奇数次的数字异或后留下的位
        return new int[2];
    }
}
