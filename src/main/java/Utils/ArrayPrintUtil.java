package Utils;

import java.util.Arrays;

public class ArrayPrintUtil {

	public static void printArr(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		System.out.println();
	}

	public static void printArr(int[][][] array){
		for (int i = 0; i < array.length; i++) {
			for(int j=0;j<array[i].length;j++){
				System.out.print(Arrays.toString(array[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printArr(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		System.out.println();
	}

	public static void printArr(char[] array){
		System.out.println(Arrays.toString(array));
	}

	public static void printArr(int[] array){
		System.out.println(Arrays.toString(array));
	}

}
