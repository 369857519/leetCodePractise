package algorithm.categories.search.DFS;

import java.util.ArrayList;
import java.util.List;

public class NQueens51 {

	public static void main(String[] args) {
		NQueens51 nQueens51 = new NQueens51();
		List<List<String>> res = nQueens51.solveNQueens(5);
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		List<Integer[]> arr = new ArrayList<>();
		search(result, arr, 0, n);
		return result;
	}

	public void search(List<List<String>> result, List<Integer[]> record, int row, int n) {
		if (row == n) {
			result.add(recordToString(n, record));
			return;
		}
		for (int column = 0; column < n; column++) {
			if (canPut(row, column, record)) {
				record.add(new Integer[]{row, column});
				search(result, record, row + 1, n);
				record.remove(record.size() - 1);
			}
		}
	}

	public List<String> recordToString(int n, List<Integer[]> record) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (record.get(i)[1] == j) {
					stringBuilder.append("Q");
				} else {
					stringBuilder.append(".");
				}
			}
			res.add(stringBuilder.toString());
		}
		return res;
	}

	public boolean canPut(int row, int column, List<Integer[]> record) {
		for (Integer[] coordinate : record) {
			if (row == coordinate[0] || column == coordinate[1]
				|| Math.abs((row - coordinate[0]) * 1.0 / (column - coordinate[1])) == 1) {
				return false;
			}
		}
		return true;
	}
}
