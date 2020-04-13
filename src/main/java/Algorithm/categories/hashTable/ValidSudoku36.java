package Algorithm.categories.hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku36 {

	public static void main(String[] args) {
		char[][] one = new char[][]{
			{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		char[][] two = {
			{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
			{'.', '4', '.', '3', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '3', '.', '.', '1'},
			{'8', '.', '.', '.', '.', '.', '.', '2', '.'},
			{'.', '.', '2', '.', '7', '.', '.', '.', '.'},
			{'.', '1', '5', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
			{'.', '2', '.', '9', '.', '.', '.', '.', '.'},
			{'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
		ValidSudoku36 validSudoku36 = new ValidSudoku36();
		boolean res = validSudoku36.isValidSudoku(one);
		res = validSudoku36.isValidSudoku(two);
	}

	public boolean isValidSudoku(char[][] board) {
		Map<Integer, Set<Integer>> rowSet = new HashMap<>();
		Map<Integer, Set<Integer>> columnSet = new HashMap<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.' && (!isRowColumnLegal(i, board[i][j], rowSet) |
					!isRowColumnLegal(j, board[i][j], columnSet))) {
					return false;
				}
				if ((i > 0 && i < 8 && (i - 1) % 3 == 0) &&
					(j > 0 && j < 8 && (j - 1) % 3 == 0)) {
					if (!isBlockLegal(i, j, board)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	int[][] around = {
		{-1, -1}, {-1, 0}, {-1, 1},
		{0, -1}, {0, 0}, {0, 1},
		{1, -1}, {1, 0}, {1, 1}
	};

	public boolean isBlockLegal(int i, int j, char[][] borad) {
		Set<Character> set = new HashSet<>();
		for (int index = 0; index < 9; index++) {
			char value = borad[i + around[index][0]][j + around[index][1]];
			if (value != '.' && set.contains(value)) {
				return false;
			}
			set.add(value);
		}
		return true;
	}

	public boolean isRowColumnLegal(int index, int val, Map<Integer, Set<Integer>> map) {
		Set<Integer> set = map.get(index);
		if (set == null) {
			set = new HashSet<>();
			set.add(val);
			map.put(index, set);
		} else {
			if (set.contains(val)) {
				return false;
			} else {
				set.add(val);
			}
		}
		return true;
	}
}
