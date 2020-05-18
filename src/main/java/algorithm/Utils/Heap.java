package algorithm.Utils;

public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(2);
        heap.insert(7);
        heap.insert(33);
        heap.insert(2);
        heap.insert(2);
    }

    private int len = 0;

    private int[] heap;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    //放在尾部，然后上滤
    public boolean insert(int val) {
        if (len == heap.length) {
            return false;
        }
        int i;
        for (i = len++ - 1; heap[i] < val; i = (i - 1) / 2) {
            heap[i] = heap[(i - 1) / 2];
        }
        heap[i] = val;
        return true;
    }

    //交换头尾，下滤头
    public int pop() {
        if (len == 0) {
            return -1;
        }
        int res = heap[0];
        heap[0] = heap[(len--) - 1];

        int val = 0;
        for (int i = 0, c = i * 2 + 1; c < len; i = c, c = i * 2 + 1) {
            if (heap[c] < heap[i]) {
                heap[c] = heap[i];
                val = heap[c];
            }
        }
        heap[0] = val;
        return res;
    }
}
