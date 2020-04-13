package Algorithm.categories.search.BFS;

import Algorithm.Utils.ArrayPrintUtil;
import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions130 {

	public static void main(String[] args) {
		SurroundedRegions130 surroundedRegions130 = new SurroundedRegions130();
		surroundedRegions130.solve(new char[][]{
			{'X', 'X', 'X', 'X'},
			{'X', 'O', 'O', 'X'},
			{'X', 'X', 'O', 'X'},
			{'X', 'O', 'X', 'X'}
		});
		surroundedRegions130.solve(new char[][]{});
		surroundedRegions130.solve(new char[][]{
			{'X'}
		});
		surroundedRegions130.solve(new char[][]{
			{'X', 'O', 'X'},
			{'X', 'O', 'X'},
			{'X', 'O', 'X'}
		});
		surroundedRegions130.solve(new char[][]{
			{'O', 'O', 'O', 'O', 'O', 'O'},
			{'O', 'X', 'X', 'X', 'X', 'O'},
			{'O', 'X', 'O', 'O', 'X', 'O'},
			{'O', 'X', 'O', 'O', 'X', 'O'},
			{'O', 'X', 'X', 'X', 'X', 'O'},
			{'O', 'O', 'O', 'O', 'O', 'O'}
		});

	}

	public void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				//在边缘切未被看过的
				if (board[i][j] == 'O' && !visited(i, j)
					&& (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)
					) {
					traverse(i, j, board);
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (!visited(i, j)) {
					board[i][j] = 'X';
				}
			}
		}
		ArrayPrintUtil.printArr(board);
	}

	//traverse

	private int[][] directions = new int[][]{
		{1, 0}, {-1, 0}, {0, 1}, {0, -1}
	};

	private void traverse(int i, int j, char[][] board) {
		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !visited(i, j)
			&& board[i][j] == 'O') {
			visit(i, j);
			for (int k = 0; k < directions.length; k++) {
				traverse(directions[k][0] + i, directions[k][1] + j, board);
			}
		}
	}

	//visitedRecord

	private Set<Integer> visitedSet = new HashSet<>();

	private void visit(int x, int y) {
		int hash = ((x + y) * (x + y + 1) / 2) + y;
		visitedSet.add(hash);
	}

	private boolean visited(int x, int y) {
		int hash = ((x + y) * (x + y + 1) / 2) + y;
		return visitedSet.contains(hash);
	}

}
