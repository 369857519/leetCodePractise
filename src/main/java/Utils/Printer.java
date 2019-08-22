package Utils;

import java.util.Arrays;

public class Printer {

	public static void printArr(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

}
