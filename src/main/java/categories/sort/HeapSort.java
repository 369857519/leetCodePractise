package categories.sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2,
			5, 9, 7, 4, 0, 2, 6};
		new HeapSort().sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private int[] arr;

	public void sort(int[] arr) {
		this.arr = arr;
		int firstP = arr.length >>> 1;
		for (int i = firstP; i >= 0; i--) {
			heapify(i, arr.length);
		}

		for (int i = 1; i < arr.length; i++) {
			swap(0, arr.length - i);
			heapify(0, arr.length - i - 1);
		}
	}

	private void heapify(int index, int len) {
		int l = index << 1;
		int r = l + 1;
		if (l >= len) {
			return;
		}
		int maxIndex = l;
		if (r < len && arr[r] > arr[l]) {
			maxIndex = r;
		}

		if (arr[index] < arr[maxIndex]) {
			swap(index, maxIndex);
			heapify(maxIndex, len);
		}
	}

	private void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}


}
