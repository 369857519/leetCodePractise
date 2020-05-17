package algorithm.categories.bitmap;

public class FindSingleElement {

    public static void main(String[] args) {
        FindSingleElement findSingleElement = new FindSingleElement();
        int res=findSingleElement.getSingleElement(new int[]{5, 2, 3, 2, 3});
    }

    public int getSingleElement(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= num;
        }
        return num;
    }

}
