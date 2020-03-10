package categories.array;

import java.util.Arrays;

//sort by first element
public class MergeIntervals56 {

    public static void main(String[] args) {
        MergeIntervals56 mergeIntervals56 = new MergeIntervals56();
        int[][] res = mergeIntervals56.merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}});
        res = mergeIntervals56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

    }

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        for (int i = 0; i < length; i++) {
            boolean overlapped = false;
            for (int j = i + 1; j < length; j++) {
                if (ifOverLap(intervals[i], intervals[j])) {
                    intervals[j] = intervals[length - 1];
                    length--;
                    overlapped = true;
                }
            }
            //如果有重叠，需要重新从0开始
            if (overlapped) {
                i = -1;
            }
        }
        return Arrays.copyOfRange(intervals, 0, length);
    }

    public boolean ifOverLap(int[] a, int[] b) {
        boolean res = true;
        if (a[1] < b[0] || b[1] < a[0]) {
            res = false;
        }
        if (res) {
            a[0] = Math.min(a[0], b[0]);
            a[1] = Math.max(a[1], b[1]);
        }
        return res;
    }
}
