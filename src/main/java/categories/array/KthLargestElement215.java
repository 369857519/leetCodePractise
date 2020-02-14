package categories.array;

import Utils.Heap;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement215 {

	public static void main(String[] args) {
		KthLargestElement215 kthLargestElement215 = new KthLargestElement215();
		kthLargestElement215.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
	}

	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> heap = new PriorityQueue<>();
		for (int n : nums) {
			if (heap.size() < k) {
				heap.add(n);
				continue;
			}
			if (n > heap.peek()) {
				heap.poll();
				heap.add(n);
			}
		}
		return heap.isEmpty() ? -1 : heap.poll();
	}

	//堆或者快速选择
	public int findKthLargestWithHeap(int[] nums, int k) {
		Heap heap = new Heap(k);

		for (int i = 0; i < nums.length; i++) {
			boolean res = heap.insert(nums[i]);
			if (!res) {
				heap.deleteMax();
				heap.insert(nums[i]);
			}
		}

		int res = 0;
		for (int i = 0; i < k; i++) {
			res = heap.deleteMax();
		}

		return res;
	}


}
