package algorithm.categories.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        lastStoneWeight.lastStoneWeight(new int[]{2, 2});
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            int larget = maxHeap.poll();
            int small = maxHeap.poll();
            if (larget != small) {
                maxHeap.add(larget - small);
            }
        }
        if (maxHeap.size() == 1) {
            return maxHeap.poll();
        }
        return 0;
    }

}
