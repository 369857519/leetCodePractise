package Utils;

import java.util.Arrays;

public class ArrayPrintUtil {

	public static void printArr(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		System.out.println();
	}

	public static void printArr(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		System.out.println();
	}

}
