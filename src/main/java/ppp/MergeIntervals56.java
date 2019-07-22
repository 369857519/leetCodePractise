package ppp;

import java.util.HashSet;
import java.util.Set;

//sort by first element
public class MergeIntervals56 {

	public static void main(String[] args) {
		MergeIntervals56 mergeIntervals56 = new MergeIntervals56();
		mergeIntervals56.merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}});
		mergeIntervals56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

	}

	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}
		int[] overlaped = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			if (overlaped[i] == 1) {
				continue;
			}
			for (int j = i + 1; j < intervals.length; j++) {
				if (overlaped[j] == 1) {
					continue;
				}
				if (ifOverLap(intervals[i], intervals[j])) {
					intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
					intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
					overlaped[j] = 1;
					//如果发生了更改，重新匹配一遍
					i--;
					break;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (overlaped[i] == 0) {
				count++;
			}
		}
		int[][] res = new int[count][];
		int resIndex = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (overlaped[i] == 0) {
				res[resIndex++] = intervals[i];
			}
		}
		return res;
	}

	public boolean ifOverLap(int[] a, int[] b) {
		if (a.length == 0 || b.length == 0) {
			return true;
		}
		if (a[1] < b[0] || b[1] < a[0]) {
			return false;
		}
		return true;
	}
}
