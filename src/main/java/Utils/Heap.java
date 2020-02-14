package Utils;

public class Heap {

	int[] heap;

	int size = 0;

	public Heap(int len) {
		heap = new int[len];
		for (int i = 0; i < heap.length; i++) {
			heap[i] = Integer.MAX_VALUE;
		}
	}

	public boolean insert(int x) {
		int i;
		if (size == heap.length) {
			return false;
		}
		for (i = size; heap[i / 2] < x; i /= 2) {
			heap[i] = heap[i / 2];
		}
		heap[i] = x;
		size++;
		return true;
	}

	public int deleteMax() {
		if (size == 0) {
			return 0;
		}
		int maxElement = heap[0];
		int lastElement = heap[size - 1];
		int child, i;
		for (i = 0; i * 2 + 1 <= size; i = child) {
			child = i * 2 + 1;
			if (child + 1 < size && heap[child + 1] > heap[child]) {
				child++;
			}
			if (lastElement < heap[child]) {
				heap[i] = heap[child];
			} else {
				break;
			}
		}
		heap[i] = lastElement;
		size--;
		return maxElement;
	}
}
