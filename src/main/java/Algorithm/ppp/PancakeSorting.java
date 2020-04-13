package Algorithm.ppp;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

	public static void main(String[] args) {
		PancakeSorting pancakeSorting = new PancakeSorting();
		int[] A = new int[]{3, 2, 4, 1};
		System.out.println(pancakeSorting.pancakeSort(A));
	}

	public List<Integer> pancakeSort(int[] A) {
		List<Integer> path = new ArrayList<>();
		int currentEnd = A.length;
		while (currentEnd != 1) {
			int max = A[0];
			int maxPivot = 0;
			for (int i = 0; i < currentEnd; i++) {
				if (A[i] > max) {
					max = A[i];
					maxPivot = i;
				}
			}
			if (maxPivot != currentEnd) {
				if (maxPivot != 0) {
					flip(A, maxPivot + 1);
					path.add(maxPivot + 1);
				}
				flip(A, currentEnd);
				path.add(currentEnd);
			}
			currentEnd--;
		}
		return path;
	}

	private void flip(int[] A, int end) {
		int half = (int) Math.floor(end / 2.0);
		for (int i = 0; i < half; i++) {
			int temp = A[i];
			A[i] = A[end - 1 - i];
			A[end - 1 - i] = temp;
		}
	}
}
