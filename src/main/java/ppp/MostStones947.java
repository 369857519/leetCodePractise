package ppp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MostStones947 {

	//[[3,2],[0,0],[3,3],[2,1],[2,3],[2,2],[0,2]]
	//	Example 1:
//
//	Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//	Output: 5
//	Example 2:
//
//	Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
//	Output: 3
//	Example 3:
//
//	Input: stones = [[0,0]]
//	Output: 0

	public static void main(String[] args) {
		MostStones947 mostStones947 = new MostStones947();
		int i = mostStones947.removeStones(new int[][]{
			{3, 2}, {3, 1}, {4, 4}, {1, 1}, {0, 2}, {4, 0}
		});
	}

	class UnionSet {

		private Set<Integer> rows = new HashSet<>();
		private Set<Integer> columns = new HashSet<>();
		private Set<int[]> points = new HashSet<>();

		public UnionSet add(int[] input) {
			rows.add(input[0]);
			columns.add(input[1]);
			points.add(input);
			return this;
		}

		public boolean contains(int[] input) {
			return points.contains(input);
		}

		public boolean inRowsOrColumn(int[] inputs) {
			return rows.contains(inputs[0]) || columns.contains(inputs[1]);
		}

		public int size() {
			return points.size();
		}

		public void clear() {
			rows.clear();
			columns.clear();
			points.clear();
		}

		public boolean isClear() {
			return points.isEmpty();
		}

		public boolean union(UnionSet unionSet) {
			if (!Collections.disjoint(unionSet.rows, rows) ||
				!Collections.disjoint(unionSet.columns, columns)) {
				this.rows.addAll(unionSet.rows);
				this.columns.addAll(unionSet.columns);
				this.points.addAll(unionSet.points);
				return true;
			}
			return false;
		}
	}

	public int removeStones(int[][] stones) {
		if (stones.length < 1) {
			return 0;
		}
		List<UnionSet> unionSetList = new ArrayList<>();
		List<int[]> list = Arrays.asList(stones);
		unionSetList.add(new UnionSet().add(list.get(0)));
		for (int i = 1; i < list.size(); i++) {
			boolean inset = false;
			for (UnionSet unionSet : unionSetList) {
				if (unionSet.inRowsOrColumn(list.get(i))) {
					inset = true;
					unionSet.add(list.get(i));
				} else if (unionSet.contains(list.get(i))) {
					inset = true;
				}
			}
			if (!inset) {
				UnionSet nextSet = new UnionSet();
				nextSet.add(list.get(i));
				unionSetList.add(nextSet);
			}
		}
		for (int i = 0; i < unionSetList.size(); i++) {
			for (int j = 0; j < unionSetList.size(); j++) {
				if (i != j && !unionSetList.get(i).isClear() && !unionSetList.get(j).isClear()) {
					if(unionSetList.get(i).union(unionSetList.get(j))){
						unionSetList.get(j).clear();
					}
				}
			}
		}
		int res = 0;
		for (UnionSet unionSet : unionSetList) {
			if (!unionSet.isClear()) {
				res += unionSet.size() - 1;
			}
		}
		return res;
	}
}
